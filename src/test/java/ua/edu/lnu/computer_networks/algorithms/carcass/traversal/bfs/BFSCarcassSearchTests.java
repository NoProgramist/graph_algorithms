package ua.edu.lnu.computer_networks.algorithms.carcass.traversal.bfs;

import org.junit.Test;

import ua.edu.lnu.computer_networks.algorithms.GraphSamples;
import ua.edu.lnu.computer_networks.algorithms.carcass.traversal.TraversalCarcassSearchResult;

public class BFSCarcassSearchTests {

	@Test
	public void runTests() {
		BFSCarcassSearch bfsCarcassSearch = new BFSCarcassSearchImpl();
		for (int i = 0; i < GraphSamples.graphs.length; ++i) {
			TraversalCarcassSearchResult result = bfsCarcassSearch.findCarcass(GraphSamples.rootNodes[i], GraphSamples.graphs[i]);
			System.out.println(GraphSamples.rootNodes[i]);
			System.out.println(GraphSamples.format(result.getAdjacencyMatrix()));
		}

	}
}
