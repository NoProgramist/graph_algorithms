package ua.edu.lnu.computer_networks.algorithms.carcass.distance.dijkstra;

import org.junit.Test;

import ua.edu.lnu.computer_networks.algorithms.GraphSamples;
import ua.edu.lnu.computer_networks.utils.GraphUtils;

public class DijkstraCarcassSearchTests {

	private final GraphUtils graphUtils = new GraphUtils(Double.MAX_VALUE / 2);

	@Test
	public void runTests() {
		DijkstraCarcassSearch dijkstraCarcassSearch = new DijkstraCarcassSearchImpl(graphUtils);
		for (int i = 0; i < GraphSamples.graphs.length; ++i) {
			DijkstraCarcassSearchResult result = dijkstraCarcassSearch.findCarcass(GraphSamples.rootNodes[i], GraphSamples.graphs[i]);
			System.out.println(GraphSamples.rootNodes[i]);
			System.out.println(GraphSamples.format(GraphSamples.graphs[i]));
			System.out.println(GraphSamples.format(result.getAdjacencyMatrix()));
		}
	}
}
