package ua.edu.lnu.computer_networks.algorithms.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.la4j.Matrix;

public class SimpleGraphUtils {

	private final double maxWeight;

	public SimpleGraphUtils(double maxWeight) {
		super();
		this.maxWeight = maxWeight;
	}

	public Matrix buildAdjacencyMatrix(SimpleGraph graph) {
		Matrix adjMat = Matrix.constant(graph.getVertexes().size(), graph.getVertexes().size(), this.maxWeight);
		graph.getVertexes().stream().sequential().forEachOrdered(node -> {
			if (node.isReflexive()) {
				adjMat.set(node.getId(), node.getId(), 0);
			}
		});
		graph.getEdges().stream().sequential().forEachOrdered(edge -> {
			if (edge.isLeft()) {
				adjMat.set(edge.getSource(), edge.getTarget(), edge.getWeight());
			}
			if (edge.isRight()) {
				adjMat.set(edge.getTarget(), edge.getSource(), edge.getWeight());
			}
		});
		return adjMat;
	}

	public SimpleGraph buildGraph(Matrix adjMat) {
		if (adjMat.rows() != adjMat.columns()) {
			throw new IllegalArgumentException("Adjacency matrix is not square");
		}
		List<Vertex> nodes = new ArrayList<>(adjMat.rows());
		for (int i = 0; i < adjMat.rows(); ++i) {
			nodes.add(new Vertex(i, adjMat.get(i, i) < this.maxWeight));
		}
		Set<Edge> edges = new HashSet<>(10 * adjMat.columns());
		for (int i = 0; i < adjMat.rows() - 1; ++i) {
			for (int j = i + 1; j < adjMat.columns(); ++j) {
				double weight = adjMat.get(i, j);
				if (weight < this.maxWeight) {
					edges.add(new Edge(i, j, true, false, weight));
				}
			}
		}
		for (int i = 1; i < adjMat.rows(); ++i) {
			for (int j = 0; j < i; ++j) {
				double weight = adjMat.get(i, j);
				if (weight < this.maxWeight) {
					final int row = i;
					final int col = j;
					Optional<Edge> possibleEdge = edges.stream().filter(edge -> {
						return edge.getSource() == col && edge.getTarget() == row;
					}).findAny();
					if (possibleEdge.isPresent()) {
						Edge edge = possibleEdge.get();
						if (weight == edge.getWeight()) {
							edge.setRight(true);
						} else {
							edges.add(new Edge(j, i, true, false, weight));
						}
					} else {
						edges.add(new Edge(i, j, false, true, weight));
					}
				}
			}
		}
		return new SimpleGraph(nodes, new ArrayList<>(edges));
	}

	public double getMaxWeight() {
		return maxWeight;
	}

}
