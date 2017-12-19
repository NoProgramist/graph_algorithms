package ua.edu.lnu.computer_networks.algorithms.carcass.distance.bellman_ford;

import org.la4j.Vector;

import ua.edu.lnu.computer_networks.algorithms.carcass.distance.DistanceCarcassSearchResult;
import ua.edu.lnu.computer_networks.algorithms.model.SimpleGraph;

public class BellmanFordCarcassSearchResult extends DistanceCarcassSearchResult {

	private boolean hasNegativeCycles;

	public BellmanFordCarcassSearchResult(SimpleGraph graph, Vector distances, boolean hasNegativeCycles) {
		super(graph, distances);
		this.hasNegativeCycles = hasNegativeCycles;
	}

	public boolean hasNegativeCycles() {
		return hasNegativeCycles;
	}

	public void setHasNegativeCycles(boolean hasNegativeCycles) {
		this.hasNegativeCycles = hasNegativeCycles;
	}

}
