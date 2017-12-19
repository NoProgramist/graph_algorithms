package ua.edu.lnu.computer_networks.algorithms.carcass.distance.dijkstra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.la4j.Matrix;
import org.la4j.Vector;

import ua.edu.lnu.computer_networks.algorithms.model.Path;
import ua.edu.lnu.computer_networks.algorithms.model.SimpleGraph;
import ua.edu.lnu.computer_networks.algorithms.model.SimpleGraphUtils;

public class DijkstraCarcassSearchImpl implements DijkstraCarcassSearch {

	protected final SimpleGraphUtils graphUtils;

	public DijkstraCarcassSearchImpl(SimpleGraphUtils graphUtils) {
		super();
		this.graphUtils = graphUtils;
	}

	@Override
	public DijkstraCarcassSearchResult findCarcass(int root, SimpleGraph graph) {
		return this.findCarcass(root, graphUtils.buildAdjacencyMatrix(graph));
	}

	@Override
	public DijkstraCarcassSearchResult findCarcass(int root, Matrix adjacencyMatrix) {
		VertexLabels[] distances = buildInitialDistances(root, adjacencyMatrix);
		Matrix carcass = Matrix.constant(adjacencyMatrix.rows(), adjacencyMatrix.columns(), graphUtils.getMaxWeight());
		Map<Integer, Integer> parent = new HashMap<>();
		int i = root;
		int tempNodeMinimum;

		do {
			tempNodeMinimum = -1;
			Vector nodeAdjacency = adjacencyMatrix.getRow(i);
			double tempDistanceMinimum = graphUtils.getMaxWeight();
			for (int j = 0; j < adjacencyMatrix.columns(); ++j) {
				if (nodeAdjacency.get(j) != graphUtils.getMaxWeight()) {
					if (!distances[j].isFinal) {
						if (distances[j].distance > distances[i].distance + nodeAdjacency.get(j)) {
							parent.put(j, i);
							distances[j].distance = distances[i].distance + nodeAdjacency.get(j);
						}
					}
				}
			}
			for (int j = 0; j < distances.length; ++j) {
				if (!distances[j].isFinal && distances[j].distance < tempDistanceMinimum) {
					tempNodeMinimum = j;
					tempDistanceMinimum = distances[j].distance;
				}
			}
			if (tempNodeMinimum > -1) {
				carcass.set(parent.get(tempNodeMinimum), tempNodeMinimum, adjacencyMatrix.get(parent.get(tempNodeMinimum), tempNodeMinimum));
				distances[tempNodeMinimum].isFinal = true;
				i = tempNodeMinimum;
			}
		} while (tempNodeMinimum > -1);
		Vector finalDistances = Vector.zero(carcass.rows());
		for (int j = 0; j < adjacencyMatrix.columns(); j++) {
			finalDistances.set(j, distances[j].distance);
		}
		return new DijkstraCarcassSearchResult(graphUtils.buildGraph(carcass), finalDistances, parent);
	}

	private VertexLabels[] buildInitialDistances(int root, Matrix adjacencyMatrix) {
		VertexLabels[] distances = new VertexLabels[adjacencyMatrix.rows()];
		for (int i = 0; i < adjacencyMatrix.rows(); ++i) {
			distances[i] = new VertexLabels();
		}
		distances[root].distance = 0;
		distances[root].isFinal = true;
		return distances;
	}

	protected class VertexLabels {
		double distance = graphUtils.getMaxWeight();
		boolean isFinal = false;
	}

	@Override
	public Path findPath(int from, int to, Matrix adjacencyMatrix) {
		DijkstraCarcassSearchResult searchToAll = findCarcass(from, adjacencyMatrix);
		List<Integer> path = new ArrayList<>();
		Integer v = to;
		while (v != null) {
			path.add(v);
			v = searchToAll.getParent().get(v);
		}
		Collections.reverse(path);
		return new Path(path, searchToAll.getDistances().get(to));
	}
}
