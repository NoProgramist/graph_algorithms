package ua.edu.lnu.computer_networks.algorithms.carcass.traversal;

import org.la4j.Matrix;
import org.la4j.Vector;

import ua.edu.lnu.computer_networks.algorithms.carcass.CarcassSearchResult;

public class TraversalCarcassSearchResult extends CarcassSearchResult {

	private Vector traversalSqeuence;

	public TraversalCarcassSearchResult(Matrix adjacencyMatrix, Vector traversalSqeuence) {
		super(adjacencyMatrix);
		this.traversalSqeuence = traversalSqeuence;
	}

	public Vector getTraversalSqeuence() {
		return traversalSqeuence;
	}

	public void setTraversalSqeuence(Vector traversalSqeuence) {
		this.traversalSqeuence = traversalSqeuence;
	}
}
