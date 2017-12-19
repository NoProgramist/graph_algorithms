package ua.edu.lnu.computer_networks.algorithms.carcass.traversal.bfs;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ua.edu.lnu.computer_networks.algorithms.GraphSamples;
import ua.edu.lnu.computer_networks.algorithms.carcass.traversal.TraversalCarcassSearchResult;
import ua.edu.lnu.computer_networks.algorithms.model.SimpleGraphUtils;

public class BFSCarcassSearchTests {

	List<String> traversalSequence = Arrays.asList("0,000 1,000 2,000 3,000 4,000 6,000 7,000 8,000 5,000 9,000 10,000",
			"9,000 10,000 6,000 7,000 1,000 0,000 2,000 3,000 8,000 4,000 5,000", "0,000 1,000 2,000 3,000 4,000 5,000 6,000 7,000");
	List<String> carcasses = Arrays.asList(
			"Graph [Edge [source=0, target=1, weight=2.0], Edge [source=0, target=2, weight=7.0], Edge [source=0, target=3, weight=4.0], Edge [source=2, target=4, weight=-1.0], Edge [source=2, target=8, weight=4.0], Edge [source=4, target=5, weight=2.0], Edge [source=5, target=10, weight=5.0], Edge [source=8, target=6, weight=1.0], Edge [source=8, target=7, weight=1.0], Edge [source=8, target=9, weight=1.0]]",
			"Graph [Edge [source=2, target=0, weight=7.0], Edge [source=3, target=1, weight=3.0], Edge [source=4, target=2, weight=-1.0], Edge [source=4, target=3, weight=3.0], Edge [source=4, target=8, weight=4.0], Edge [source=5, target=4, weight=2.0], Edge [source=5, target=6, weight=7.0], Edge [source=5, target=7, weight=6.0], Edge [source=5, target=9, weight=5.0], Edge [source=5, target=10, weight=5.0]]",
			"Graph [Edge [source=0, target=1, weight=3.0], Edge [source=0, target=2, weight=3.0], Edge [source=0, target=3, weight=2.0], Edge [source=1, target=4, weight=5.0], Edge [source=2, target=5, weight=6.0], Edge [source=3, target=6, weight=8.0], Edge [source=4, target=7, weight=9.0]]");

	@Test
	public void runTests() {
		BFSCarcassSearch bfsCarcassSearch = new BFSCarcassSearch(new SimpleGraphUtils(Double.MAX_VALUE / 2));
		for (int i = 0; i < GraphSamples.graphs.size(); ++i) {
			TraversalCarcassSearchResult result = bfsCarcassSearch.findCarcass(GraphSamples.rootNodes.get(i), GraphSamples.graphs.get(i));
			Assert.assertEquals(traversalSequence.get(i), result.getTraversalSqeuence().toString());
			Assert.assertEquals(carcasses.get(i), result.getGraph().toString());
		}

	}
}
