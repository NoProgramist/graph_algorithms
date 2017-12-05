package ua.edu.lnu.computer_networks.algorithms.carcass.distance.bellman_ford;

import org.junit.Test;

import ua.edu.lnu.computer_networks.algorithms.GraphSamples;
import ua.edu.lnu.computer_networks.utils.GraphUtils;

public class BellmanFordCarcassSearchTests {

	private final GraphUtils graphUtils = new GraphUtils(Double.MAX_VALUE / 2);

	@Test
	public void runTests() {
		BellmanFordCarcassSearch bellmanFordCarcassSearch = new BellmanFordCarcassSearchImpl(graphUtils);
		for (int i = 4; i < GraphSamples.graphs.length; ++i) {
			BellmanFordCarcassSearchResult result = bellmanFordCarcassSearch.findCarcass(GraphSamples.rootNodes[i], GraphSamples.graphs[i]);
			System.out.println(GraphSamples.rootNodes[i]);
			System.out.println(GraphSamples.format(GraphSamples.graphs[i]));
			System.out.println(GraphSamples.format(result.getAdjacencyMatrix()));
		}
	}
}
