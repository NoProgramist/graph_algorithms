package ua.edu.lnu.computer_networks.algorithms.carcass.distance.dijkstra;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.la4j.Matrix;
import org.la4j.Vector;

import ua.edu.lnu.computer_networks.algorithms.carcass.CarcassSearchResult;
import ua.edu.lnu.computer_networks.algorithms.model.Edge;

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
	
	public Collection<Edge> getEdges() {
		Collection<Edge> edges = new HashSet<>();
		parent.keySet().forEach(key -> {
			edges.add(new Edge(parent.get(key), key));
//			edges.add(new Edge(key, parent.get(key)));
		});
		return edges;
	}
	
	public Map<Integer, Set<Integer>> getGraph() {
		Map<Integer, Set<Integer>> graph = new HashMap<>();
		parent.keySet().forEach(key -> {
			graph.putIfAbsent(parent.get(key), new HashSet<Integer>());
			graph.get(parent.get(key)).add(key);
		});
		return graph;
	}
}
