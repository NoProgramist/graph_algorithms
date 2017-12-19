package ua.edu.lnu.computer_networks.algorithms.model;

import java.util.Collections;
import java.util.List;

public class SimpleGraph {

	protected List<? extends Vertex> vertexes;

	protected List<? extends Edge> edges;

	public SimpleGraph() {
		super();
	}

	public SimpleGraph(List<? extends Vertex> vertexes, List<? extends Edge> edges) {
		super();
		Collections.sort(vertexes);
		Collections.sort(edges);
		this.vertexes = vertexes;
		this.edges = edges;
	}

	public List<? extends Vertex> getVertexes() {
		return vertexes;
	}

	public void setVertexes(List<? extends Vertex> vertexes) {
		Collections.sort(vertexes);
		this.vertexes = vertexes;
	}

	public List<? extends Edge> getEdges() {
		return edges;
	}

	public void setEdges(List<? extends Edge> edges) {
		Collections.sort(edges);
		this.edges = edges;
	}

	@Override
	public String toString() {
		return "Graph " + edges;
	}
}
