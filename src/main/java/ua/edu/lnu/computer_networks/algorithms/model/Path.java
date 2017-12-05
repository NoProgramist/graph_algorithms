package ua.edu.lnu.computer_networks.algorithms.model;

import java.util.List;

import org.apache.commons.lang.StringUtils;

public class Path {
	
	private List<Integer> vertexes;
	
	private double length;
	
	int from;
	
	int to;

	public Path(List<Integer> vertexes, double length) {
		super();
		this.vertexes = vertexes;
		this.length = length;
	}

	public List<Integer> getVertexes() {
		return vertexes;
	}

	public void setVertexes(List<Integer> vertexes) {
		this.vertexes = vertexes;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}
	
	@Override
	public String toString() {
		return "{" + StringUtils.join(vertexes.toArray(), ", ") + "} - " + length;
	}

	public int getFrom() {
		return vertexes.get(0);
	}

	public int getTo() {
		return vertexes.get(vertexes.size() - 1);
	}
}
