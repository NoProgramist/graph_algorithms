package ua.edu.lnu.computer_networks.algorithms.carcass.distance.dijkstra;

import org.junit.Test;

import ua.edu.lnu.computer_networks.algorithms.GraphSamples;
import ua.edu.lnu.computer_networks.algorithms.model.SimpleGraphUtils;

public class DijkstraCarcassSearchTests {

	@Test
	public void runTests() {
		DijkstraCarcassSearch dijkstraCarcassSearch = new DijkstraCarcassSearchImpl(new SimpleGraphUtils(100));
		for (int i = 0; i < GraphSamples.graphs.size(); ++i) {
			DijkstraCarcassSearchResult result = dijkstraCarcassSearch.findCarcass(GraphSamples.rootNodes.get(i), GraphSamples.graphs.get(i));
			System.out.println(result.getGraph());
			System.out.println(result.getDistances());
			System.out.println(result.getParent());
		}
	}
}
