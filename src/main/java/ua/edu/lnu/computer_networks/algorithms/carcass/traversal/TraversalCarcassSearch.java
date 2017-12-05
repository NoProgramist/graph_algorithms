package ua.edu.lnu.computer_networks.algorithms.carcass.traversal;

import java.util.LinkedList;

import org.la4j.Matrix;
import org.la4j.Vector;

import ua.edu.lnu.computer_networks.algorithms.carcass.CarcassSearch;

public abstract class TraversalCarcassSearch implements CarcassSearch {

	@Override
	public TraversalCarcassSearchResult findCarcass(int root, Matrix adjacencyMatrix) throws IllegalArgumentException {
		checkArgs(root, adjacencyMatrix);
		Matrix carcass = Matrix.constant(adjacencyMatrix.rows(), adjacencyMatrix.columns(), Double.MAX_VALUE);
		Vector traversalSeq = Vector.constant(adjacencyMatrix.rows(), -1.0);
		Integer traversalId = 0;
		TravesalDequeue traversalDequeue = getTravesalDequeue();
		boolean[] wasProcessed = new boolean[adjacencyMatrix.columns()];
		traversalDequeue.pushTravesalNode(root);
		wasProcessed[root] = true;
		traversalSeq.set(root, traversalId++);
		do {
			int head = traversalDequeue.nextTravesalNode();
			Vector nodeAdjacency = adjacencyMatrix.getRow(head);
			for (int j = 0; j < wasProcessed.length; ++j) {
				if (wasProcessed[j]) {
					nodeAdjacency.set(j, Double.MAX_VALUE);
				} else {
					if (nodeAdjacency.get(j) != Double.MAX_VALUE) {
						traversalDequeue.pushTravesalNode(j);
						wasProcessed[j] = true;
						traversalSeq.set(j, traversalId++);
					}
				}
			}
			nodeAdjacency.set(head, adjacencyMatrix.get(head, head));
			carcass.setRow(head, nodeAdjacency);
			traversalDequeue.pop();
		} while (!traversalDequeue.isEmpty());
		return new TraversalCarcassSearchResult(carcass, traversalSeq);
	}

	protected abstract TravesalDequeue getTravesalDequeue();

	protected void checkArgs(int root, Matrix adjacencyMatrix) throws IllegalArgumentException {
		if (adjacencyMatrix.rows() != adjacencyMatrix.columns()) {
			throw new IllegalArgumentException();
		}
		if (root < 0 || root > adjacencyMatrix.rows() - 1) {
			throw new IllegalArgumentException();
		}
	}

	protected abstract class TravesalDequeue extends LinkedList<Integer> {

		/**
		 * 
		 */
		private static final long serialVersionUID = 5669650242915538424L;

		protected abstract void pushTravesalNode(Integer value);

		protected abstract Integer nextTravesalNode();

		protected abstract Integer popTravesalNode();
	}
}
