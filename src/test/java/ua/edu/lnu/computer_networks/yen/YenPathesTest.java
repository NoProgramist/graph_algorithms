package ua.edu.lnu.computer_networks.yen;

import java.util.List;

import org.junit.Test;
import org.la4j.Matrix;

import ua.edu.lnu.computer_networks.algorithms.GraphSamples;
import ua.edu.lnu.computer_networks.algorithms.model.Path;
import ua.edu.lnu.computer_networks.algorithms.yen.YensPathesSearch;
import ua.edu.lnu.computer_networks.algorithms.yen.YensPathesSearchImpl;

public class YenPathesTest {
	
	@Test
	public void runTests() {
		YensPathesSearch yensPathesSearch = new YensPathesSearchImpl();
		List<Path> result = yensPathesSearch.findKthShortestPath(0, 4, 3, Matrix.from2DArray(GraphSamples.yenGraph));
		result.forEach(path -> System.out.println(path));
	}
	
	@Test
	public void runTests2() {
		YensPathesSearch yensPathesSearch = new YensPathesSearchImpl();
		List<Path> result = yensPathesSearch.findKthShortestPath(0, 4, 7, Matrix.from2DArray(GraphSamples.yenGraph2));
		result.forEach(path -> System.out.println(path));
	}
}
