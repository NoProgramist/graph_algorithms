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
			int vertexInRemovedEdge1 = -1;
			int vertexInRemovedEdge2 = -1;
			for(int i = 0; i + 1 < bestPath.getVertexes().size(); i++) {
				int v = bestPath.getVertexes().get(i);
				int u = bestPath.getVertexes().get(i + 1);
				double edgeWeight = adjacencyMatrix.get(v, u);
				adjacencyMatrix.set(v, u, Double.MAX_VALUE / 2);
				adjacencyMatrix.set(u, v, Double.MAX_VALUE / 2);
				Path path = dijkstraCarcassSearch.findPath(from, to, adjacencyMatrix);
				if (nextBestPath == null || nextBestPath.getLength() > path.getLength()) {
					nextBestPath = path;
					vertexInRemovedEdge1 = v;
					vertexInRemovedEdge2 = u;
				}
				adjacencyMatrix.set(v, u, edgeWeight);
				adjacencyMatrix.set(u, v, edgeWeight);
			}
			result.add(nextBestPath);
			bestPath = nextBestPath;
			adjacencyMatrix.set(vertexInRemovedEdge1, vertexInRemovedEdge2, Double.MAX_VALUE / 2);
			adjacencyMatrix.set(vertexInRemovedEdge2, vertexInRemovedEdge1, Double.MAX_VALUE / 2);
		}
		return result;
	}

}
