package ua.edu.lnu.computer_networks.algorithms.carcass.traversal;

import org.la4j.Vector;

import ua.edu.lnu.computer_networks.algorithms.carcass.CarcassSearchResult;
import ua.edu.lnu.computer_networks.algorithms.model.SimpleGraph;

public class TraversalCarcassSearchResult extends CarcassSearchResult {

	private Vector traversalSqeuence;

	public TraversalCarcassSearchResult(SimpleGraph graph, Vector traversalSqeuence) {
		super(graph);
		this.traversalSqeuence = traversalSqeuence;
	}

	public Vector getTraversalSqeuence() {
		return traversalSqeuence;
	}

	public void setTraversalSqeuence(Vector traversalSqeuence) {
		this.traversalSqeuence = traversalSqeuence;
	}
}
