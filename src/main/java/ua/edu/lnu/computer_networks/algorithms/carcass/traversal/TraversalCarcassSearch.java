package ua.edu.lnu.computer_networks.algorithms.carcass.traversal;

import java.util.LinkedList;

import org.la4j.Matrix;

import ua.edu.lnu.computer_networks.algorithms.carcass.CarcassSearch;
import ua.edu.lnu.computer_networks.algorithms.model.SimpleGraph;
import ua.edu.lnu.computer_networks.algorithms.model.SimpleGraphUtils;

public abstract class TraversalCarcassSearch implements CarcassSearch {

	protected final SimpleGraphUtils graphUtils;

	public TraversalCarcassSearch(SimpleGraphUtils graphUtils) {
		super();
		this.graphUtils = graphUtils;
	}

	@Override
	public TraversalCarcassSearchResult findCarcass(int root, SimpleGraph graph) {
		return this.findCarcass(root, this.graphUtils.buildAdjacencyMatrix(graph));
	}

	@Override
	public abstract TraversalCarcassSearchResult findCarcass(int root, Matrix adjacencyMatrix);

	protected abstract TravesalDequeue getTravesalDequeue();

	protected void checkArgs(int root, Matrix adjacencyMatrix) throws IllegalArgumentException {
		if (adjacencyMatrix.rows() != adjacencyMatrix.columns()) {
			throw new IllegalArgumentException();
		}
		if (root < 0 || root > adjacencyMatrix.rows() - 1) {
			throw new IllegalArgumentException();
		}
	}

	protected static abstract class TravesalDequeue extends LinkedList<Integer> {

		/**
		 * 
		 */
		private static final long serialVersionUID = 5669650242915538424L;

		public abstract void pushTravesalNode(Integer value);

		public abstract Integer nextTravesalNode();

		public abstract Integer popTravesalNode();
	}
}
