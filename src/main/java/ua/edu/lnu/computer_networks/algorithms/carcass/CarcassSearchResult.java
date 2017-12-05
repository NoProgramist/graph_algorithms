package ua.edu.lnu.computer_networks.algorithms.carcass;

import org.la4j.Matrix;

public class CarcassSearchResult {

	private Matrix adjacencyMatrix;

	public CarcassSearchResult(Matrix adjacencyMatrix) {
		super();
		this.adjacencyMatrix = adjacencyMatrix;
	}

	public Matrix getAdjacencyMatrix() {
		return adjacencyMatrix;
	}

	public void setAdjacencyMatrix(Matrix adjacencyMatrix) {
		this.adjacencyMatrix = adjacencyMatrix;
	}
}
