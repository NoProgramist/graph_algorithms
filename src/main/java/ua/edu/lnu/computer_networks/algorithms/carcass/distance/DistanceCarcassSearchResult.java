package ua.edu.lnu.computer_networks.algorithms.carcass.distance;

import org.la4j.Vector;

import ua.edu.lnu.computer_networks.algorithms.carcass.CarcassSearchResult;
import ua.edu.lnu.computer_networks.algorithms.model.SimpleGraph;

public class DistanceCarcassSearchResult extends CarcassSearchResult {

	private Vector distances;

	public DistanceCarcassSearchResult(SimpleGraph graph, Vector distances) {
		super(graph);
		this.distances = distances;
	}

	public Vector getDistances() {
		return distances;
	}

	public void setDistances(Vector distances) {
		this.distances = distances;
	}
}
