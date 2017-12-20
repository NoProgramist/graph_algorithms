package dynamic_update;

import org.junit.Test;
import org.la4j.Matrix;

import ua.edu.lnu.computer_networks.algorithms.GraphSamples;
import ua.edu.lnu.computer_networks.algorithms.carcass.distance.dijkstra.DijkstraCarcassSearchResult;
import ua.edu.lnu.computer_networks.algorithms.carcass.distance.dynamic_add_remove.DynamicAddRemove;
import ua.edu.lnu.computer_networks.algorithms.carcass.distance.dynamic_add_remove.DynamicAddRemoveImpl;
import ua.edu.lnu.computer_networks.utils.GraphUtils;

public class DynamicUpdateTest {
	
	private static final GraphUtils graphUtils = new GraphUtils(Double.MAX_VALUE / 2);
	private static final double n = graphUtils.InfinityWeight;
	
	@Test
	public void runTests() {
		DynamicUpdate service = new DynamicUpdateImpl();
		DijkstraCarcassSearchResult result = service.init(0, Matrix.from2DArray(GraphSamples.update));
		print(result);
		result = service.updateEdge(0, 3, 2);
		print(result);
		
		result = service.updateEdge(1, 3, 100);
		print(result);
	}
	
	void print(DijkstraCarcassSearchResult result) {
		System.out.println();
		result.getEdges().forEach(edge -> System.out.println(edge.toString()));
		System.out.println();
		result.getDistances().forEach(dist -> System.out.print(dist + " "));
		System.out.println();
	}
	
}
