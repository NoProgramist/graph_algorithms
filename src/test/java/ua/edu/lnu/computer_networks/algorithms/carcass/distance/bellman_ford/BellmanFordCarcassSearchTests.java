package ua.edu.lnu.computer_networks.algorithms.carcass.distance.bellman_ford;

import org.junit.Test;

import ua.edu.lnu.computer_networks.algorithms.GraphSamples;
import ua.edu.lnu.computer_networks.algorithms.model.SimpleGraphUtils;

public class BellmanFordCarcassSearchTests {

	@Test
	public void runTests() {
		BellmanFordCarcassSearch bellmanFordCarcassSearch = new BellmanFordCarcassSearchImpl(new SimpleGraphUtils(100));
		for (int i = 0; i < GraphSamples.graphs.size(); ++i) {
			BellmanFordCarcassSearchResult result = bellmanFordCarcassSearch.findCarcass(GraphSamples.rootNodes.get(i), GraphSamples.graphs.get(i));
			System.out.println(result.getGraph());
			System.out.println(result.hasNegativeCycles());
			System.out.println(result.getDistances());
		}
	}
}
