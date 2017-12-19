package ua.edu.lnu.computer_networks.algorithms.carcass.distance.dijkstra;

import java.util.Map;

import org.la4j.Vector;

import ua.edu.lnu.computer_networks.algorithms.carcass.distance.DistanceCarcassSearchResult;
import ua.edu.lnu.computer_networks.algorithms.model.SimpleGraph;

public class DijkstraCarcassSearchResult extends DistanceCarcassSearchResult {

	private Map<Integer, Integer> parent;

	protected DijkstraCarcassSearchResult(SimpleGraph graph, Vector distances) {
		super(graph, distances);
	}

	protected DijkstraCarcassSearchResult(SimpleGraph graph, Vector distances, Map<Integer, Integer> parent) {
		this(graph, distances);
		this.parent = parent;
	}

	public Map<Integer, Integer> getParent() {
		return parent;
	}

	public void setParent(Map<Integer, Integer> parent) {
		this.parent = parent;
	}
}
