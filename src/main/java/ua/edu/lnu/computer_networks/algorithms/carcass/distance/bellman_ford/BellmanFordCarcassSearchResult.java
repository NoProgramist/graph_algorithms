package ua.edu.lnu.computer_networks.algorithms.carcass.distance.bellman_ford;

import org.la4j.Matrix;
import org.la4j.Vector;

import ua.edu.lnu.computer_networks.algorithms.carcass.CarcassSearchResult;

public class BellmanFordCarcassSearchResult extends CarcassSearchResult {

	private Vector distances;

	private boolean hasNegativeCycles;

	public BellmanFordCarcassSearchResult(Matrix adjacencyMatrix, Vector distances, boolean hasNegativeCycles) {
		super(adjacencyMatrix);
		this.distances = distances;
		this.hasNegativeCycles = hasNegativeCycles;
	}

	public Vector getDistances() {
		return distances;
	}

	public void setDistances(Vector distances) {
		this.distances = distances;
	}

	public boolean isHasNegativeCycles() {
		return hasNegativeCycles;
	}

	public void setHasNegativeCycles(boolean hasNegativeCycles) {
		this.hasNegativeCycles = hasNegativeCycles;
	}

}
