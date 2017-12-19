package ua.edu.lnu.computer_networks.algorithms.carcass.distance.bellman_ford;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.la4j.Matrix;
import org.la4j.Vector;

import ua.edu.lnu.computer_networks.algorithms.model.Edge;
import ua.edu.lnu.computer_networks.algorithms.model.SimpleGraph;
import ua.edu.lnu.computer_networks.algorithms.model.SimpleGraphUtils;

public class BellmanFordCarcassSearchImpl implements BellmanFordCarcassSearch {

	protected final SimpleGraphUtils graphUtils;

	public BellmanFordCarcassSearchImpl(SimpleGraphUtils graphUtils) {
		super();
		this.graphUtils = graphUtils;
	}

	@Override
	public BellmanFordCarcassSearchResult findCarcass(int root, SimpleGraph graph) {
		int vertexesCount = graph.getVertexes().size();
		List<VertexLabel> labels = IntStream.range(0, vertexesCount).mapToObj(id -> {
			return new VertexLabel();
		}).collect(Collectors.toList());
		labels.get(root).distance = 0;
		for (int i = 0; i < vertexesCount; ++i) {
			doSubStep(graph.getEdges(), i, labels);
		}
		Vector distances = Vector.fromArray(labels.stream().sequential().mapToDouble(label -> {
			return label.distance;
		}).toArray());
		return new BellmanFordCarcassSearchResult(buildCarcassGraph(labels, graph), distances, checkIfHasNegativeCycles(graph.getEdges(), vertexesCount, labels));
	}

	private SimpleGraph buildCarcassGraph(List<VertexLabel> labels, SimpleGraph graph) {
		SimpleGraph carcass = new SimpleGraph();
		carcass.setVertexes(new ArrayList<>(graph.getVertexes()));
		List<Edge> edges = new ArrayList<>(graph.getVertexes().size());
		for (int i = 0; i < labels.size(); ++i) {
			if (labels.get(i).parent > -1) {
				edges.add(new Edge(labels.get(i).parent, i, true, false, labels.get(i).weight));
			}
		}
		carcass.setEdges(edges);
		return carcass;
	}

	@Override
	public BellmanFordCarcassSearchResult findCarcass(int root, Matrix adjacencyMatrix) {
		return this.findCarcass(root, graphUtils.buildGraph(adjacencyMatrix));
	}

	protected void doSubStep(List<? extends Edge> edges, int i, List<VertexLabel> labels) {
		for (Edge edge : edges) {
			if (edge.isLeft()) {
				updateWeight(edge.getSource(), edge.getTarget(), edge.getWeight(), labels);
			}
			if (edge.isRight()) {
				updateWeight(edge.getTarget(), edge.getSource(), edge.getWeight(), labels);
			}
		}
	}

	protected void updateWeight(int source, int target, double weight, List<VertexLabel> labels) {
		double newDistance = labels.get(source).distance + weight;
		VertexLabel targetLabel = labels.get(target);
		if (targetLabel.distance > newDistance) {
			targetLabel.distance = newDistance;
			targetLabel.weight = weight;
			targetLabel.parent = source;
		}
	}

	protected boolean checkIfHasNegativeCycles(List<? extends Edge> edges, int vertexesCount, List<VertexLabel> labels) {
		Vector oldDistances = Vector.fromArray(labels.stream().sequential().mapToDouble(label -> {
			return label.distance;
		}).toArray());
		doSubStep(edges, vertexesCount, labels);
		Vector newDistances = Vector.fromArray(labels.stream().mapToDouble(label -> {
			return label.distance;
		}).toArray());
		return newDistances.subtract(oldDistances).euclideanNorm() > 0;
	}

	protected class VertexLabel implements Cloneable {
		double distance = graphUtils.getMaxWeight();
		double weight = graphUtils.getMaxWeight();
		int parent = -1;

		VertexLabel() {
			super();
		}

		VertexLabel(double distance, double weight, int parent) {
			super();
			this.distance = distance;
			this.weight = weight;
			this.parent = parent;
		}

		@Override
		public VertexLabel clone() {
			return new VertexLabel(distance, weight, parent);
		}
	}

}
