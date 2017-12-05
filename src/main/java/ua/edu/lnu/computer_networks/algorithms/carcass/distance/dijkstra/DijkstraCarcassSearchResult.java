package ua.edu.lnu.computer_networks.algorithms.carcass.distance.dijkstra;

import java.util.Map;

import org.la4j.Matrix;
import org.la4j.Vector;

import ua.edu.lnu.computer_networks.algorithms.carcass.CarcassSearchResult;

public class DijkstraCarcassSearchResult extends CarcassSearchResult {

	private Vector distances;
	
	private Map<Integer, Integer> parent;
	
	protected DijkstraCarcassSearchResult(Matrix adjacencyMatrix, Vector distances) {
		super(adjacencyMatrix);
		this.distances = distances;
	}

	public Vector getDistances() {
		return distances;
	}

	public void setDistances(Vector distances) {
		this.distances = distances;
	}

	public Map<Integer, Integer> getParent() {
		return parent;
	}

	public void setParent(Map<Integer, Integer> parent) {
		this.parent = parent;
	}

	public DijkstraCarcassSearchResult(Matrix adjacencyMatrix, Vector distances, Map<Integer, Integer> parent) {
		super(adjacencyMatrix);
		this.distances = distances;
		this.parent = parent;
	}
}
