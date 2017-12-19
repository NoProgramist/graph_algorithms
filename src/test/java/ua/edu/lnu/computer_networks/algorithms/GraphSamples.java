package ua.edu.lnu.computer_networks.algorithms;

import java.util.Arrays;
import java.util.List;

import ua.edu.lnu.computer_networks.algorithms.model.Edge;
import ua.edu.lnu.computer_networks.algorithms.model.SimpleGraph;
import ua.edu.lnu.computer_networks.algorithms.model.SimpleGraphUtils;
import ua.edu.lnu.computer_networks.algorithms.model.Vertex;

public class GraphSamples {

	private static final SimpleGraphUtils graphUtils = new SimpleGraphUtils(Double.MAX_VALUE / 2);

	private static final List<Vertex> nodes1 = Arrays.asList(new Vertex(0, true), new Vertex(1, true), new Vertex(2, true), new Vertex(3, true), new Vertex(4, true),
			new Vertex(5, true), new Vertex(6, true), new Vertex(7, true), new Vertex(8, true), new Vertex(9, true), new Vertex(10, true));
	private static final List<Edge> edges1 = Arrays.asList(new Edge(0, 1, true, true, 2), new Edge(0, 2, true, true, 7), new Edge(1, 3, true, true, 3),
			new Edge(3, 0, true, true, 4), new Edge(3, 2, true, true, 2), new Edge(3, 4, true, true, 3), new Edge(2, 4, true, true, -1), new Edge(2, 8, true, true, 4),
			new Edge(4, 8, true, true, 4), new Edge(4, 5, true, true, 2), new Edge(5, 10, true, true, 5), new Edge(5, 6, true, true, 7), new Edge(5, 7, true, true, 6),
			new Edge(5, 9, true, true, 5), new Edge(8, 6, true, true, 1), new Edge(7, 8, true, true, 1), new Edge(9, 8, true, true, 1), new Edge(6, 7, true, true, 1),
			new Edge(7, 9, true, true, 1));

	private static final List<Vertex> nodes2 = Arrays.asList(new Vertex(0, true), new Vertex(1, true), new Vertex(2, true), new Vertex(3, true), new Vertex(4, true),
			new Vertex(5, true), new Vertex(6, true), new Vertex(7, true));

	private static final List<Edge> edges2 = Arrays.asList(new Edge(0, 1, true, true, 3), new Edge(0, 2, true, true, 3), new Edge(0, 3, true, true, 2),
			new Edge(1, 3, true, true, 7), new Edge(1, 4, true, true, 5), new Edge(2, 5, true, true, 6), new Edge(3, 4, true, true, 4), new Edge(3, 5, true, true, 6),
			new Edge(3, 6, true, true, 8), new Edge(4, 6, true, true, 5), new Edge(4, 7, true, true, 9), new Edge(5, 7, true, true, 5), new Edge(6, 7, true, true, 2));

	public static final List<SimpleGraph> graphs = Arrays.asList(new SimpleGraph(nodes1, edges1), new SimpleGraph(nodes1, edges1), new SimpleGraph(nodes2, edges2));

	public static final List<Integer> rootNodes = Arrays.asList(0, 5, 0);

}
