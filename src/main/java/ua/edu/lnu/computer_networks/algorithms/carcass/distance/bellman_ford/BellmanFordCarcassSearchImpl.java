package ua.edu.lnu.computer_networks.algorithms.carcass.distance.bellman_ford;

import org.la4j.Matrix;
import org.la4j.Vector;
import org.la4j.iterator.MatrixIterator;

import ua.edu.lnu.computer_networks.utils.GraphUtils;

public class BellmanFordCarcassSearchImpl implements BellmanFordCarcassSearch {

	protected final GraphUtils graphUtils;

	public BellmanFordCarcassSearchImpl(GraphUtils graphUtils) {
		super();
		this.graphUtils = graphUtils;
	}

	@Override
	public BellmanFordCarcassSearchResult findCarcass(int root, Matrix adjacencyMatrix) {
		Vector distances = Vector.constant(adjacencyMatrix.rows(), graphUtils.InfinityWeight);
		distances.set(root, 0);
		Matrix pathes = Matrix.constant(adjacencyMatrix.rows() + 1, adjacencyMatrix.columns(), graphUtils.InfinityWeight);
		for (int i = 0; i < adjacencyMatrix.rows(); ++i) {
			distances = doSubStep(adjacencyMatrix.iterator(), i, pathes, distances);
		}
		boolean hasNegativeCycles = checkIfHasNegativeCycles(adjacencyMatrix.iterator(), adjacencyMatrix.rows(), pathes, distances);
		return new BellmanFordCarcassSearchResult(buildCarcassMatrix(adjacencyMatrix, pathes), distances, hasNegativeCycles);
	}

	protected Vector doSubStep(MatrixIterator iterator, int i, Matrix pathes, Vector distances) {
		Vector tmpDistances = distances.copy();
		do {
			iterator.next();
			int u = iterator.rowIndex();
			int v = iterator.columnIndex();
			double weight = iterator.get();
			if (weight != graphUtils.InfinityWeight) {
				double newWeight = distances.get(u) + weight;
				if (distances.get(v) > newWeight) {
					tmpDistances.set(v, newWeight);
					pathes.set(i, v, u);
				}
			}
		} while (iterator.hasNext());
		return tmpDistances;
	}

	protected boolean checkIfHasNegativeCycles(MatrixIterator iterator, int rows, Matrix pathes, Vector distances) {
		Vector newDistances = doSubStep(iterator, rows, pathes, distances);
		return newDistances.subtract(distances).euclideanNorm() > 0;
	}

	private Matrix buildCarcassMatrix(Matrix adjacencyMatrix, Matrix pathes) {
		Matrix carcass = Matrix.constant(pathes.rows(), pathes.columns(), this.graphUtils.InfinityWeight);
		for (int j = 0; j < pathes.columns(); ++j) {
			for (int i = pathes.rows() - 1; i > -1; --i) {
				double to = pathes.get(i, j);
				if (to != this.graphUtils.InfinityWeight) {
					carcass.set(j, (int) to, adjacencyMatrix.get(j, (int) to));
				}
			}
		}
		return carcass;
	}

}
