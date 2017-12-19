package ua.edu.lnu.computer_networks.algorithms.carcass;

import ua.edu.lnu.computer_networks.algorithms.model.SimpleGraph;

public class CarcassSearchResult {

	private SimpleGraph graph;

	public CarcassSearchResult(SimpleGraph graph) {
		super();
		this.graph = graph;
	}

	public SimpleGraph getGraph() {
		return graph;
	}

	public void setGraph(SimpleGraph graph) {
		this.graph = graph;
	}

}
