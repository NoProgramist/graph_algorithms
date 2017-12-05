package ua.edu.lnu.computer_networks.algorithms.yen;

import java.util.ArrayList;
import java.util.List;

import org.la4j.Matrix;

import ua.edu.lnu.computer_networks.algorithms.carcass.distance.dijkstra.DijkstraCarcassSearch;
import ua.edu.lnu.computer_networks.algorithms.carcass.distance.dijkstra.DijkstraCarcassSearchImpl;
import ua.edu.lnu.computer_networks.algorithms.model.Path;
import ua.edu.lnu.computer_networks.utils.GraphUtils;

public class YensPathesSearchImpl implements YensPathesSearch {
	
	private final GraphUtils graphUtils = new GraphUtils(Double.MAX_VALUE / 2);
	
	@Override
	public List<Path> findKthShortestPath(int from, int to, int k, Matrix adjacencyMatrix) {
		DijkstraCarcassSearch dijkstraCarcassSearch = new DijkstraCarcassSearchImpl(graphUtils);
		Path bestPath = dijkstraCarcassSearch.findPath(from, to, adjacencyMatrix);
		List<Path> result = new ArrayList<>();
		result.add(bestPath);
		while(k > 1) {
			k--;
			Path nextBestPath = null;
			for(int i = 0; i + 1 < bestPath.getVertexes().size(); i++) {
				int v = bestPath.getVertexes().get(i);
				int u = bestPath.getVertexes().get(i + 1);
				adjacencyMatrix.set(v, u, Double.MAX_VALUE / 2);
				adjacencyMatrix.set(u, v, Double.MAX_VALUE / 2);
				Path path = dijkstraCarcassSearch.findPath(from, to, adjacencyMatrix);
				if (nextBestPath == null || nextBestPath.getLength() > path.getLength()) {
					nextBestPath = path;
				}
			}
			result.add(nextBestPath);
			bestPath = nextBestPath;
			adjacencyMatrix.set(nextBestPath.getFrom(), nextBestPath.getTo(), Double.MAX_VALUE / 2);
			adjacencyMatrix.set(nextBestPath.getTo(), nextBestPath.getFrom(), Double.MAX_VALUE / 2);
		}
		return result;
	}

}
