package ua.edu.lnu.computer_networks.algorithms.carcass.distance.dynamic_add_remove;

import java.util.Vector;

import org.la4j.Matrix;

import ua.edu.lnu.computer_networks.algorithms.carcass.distance.dijkstra.DijkstraCarcassSearch;
import ua.edu.lnu.computer_networks.algorithms.carcass.distance.dijkstra.DijkstraCarcassSearchImpl;
import ua.edu.lnu.computer_networks.algorithms.carcass.distance.dijkstra.DijkstraCarcassSearchResult;
import ua.edu.lnu.computer_networks.utils.GraphUtils;

public class DynamicAddRemoveImpl implements DynamicAddRemove {

	private final GraphUtils graphUtils = new GraphUtils(Double.MAX_VALUE / 2);
	
	private final DijkstraCarcassSearch dijkstraCarcassSearch = new DijkstraCarcassSearchImpl(graphUtils);
	
	private Matrix adjacencyMatrix;
	
	private int root;
	
	private DijkstraCarcassSearchResult result;
	
	@Override
	public DijkstraCarcassSearchResult addEdge(int a, int b, double weight) {
		adjacencyMatrix.set(a, b, weight);
		adjacencyMatrix.set(b, a, weight);		
		return dijkstraCarcassSearch.findCarcass(root, adjacencyMatrix);
	}

	@Override
	public DijkstraCarcassSearchResult removeEdge(int a, int b) {
		adjacencyMatrix.set(a, b, graphUtils.InfinityWeight);
		adjacencyMatrix.set(b, a, graphUtils.InfinityWeight);
		return dijkstraCarcassSearch.findCarcass(root, adjacencyMatrix);
	}

	@Override
	public DijkstraCarcassSearchResult addVertex(int a, Vector distances) {
		for(int i = 0; i < distances.size(); i++) {
			adjacencyMatrix.set(a, i, (double)distances.get(i));
			adjacencyMatrix.set(i, a, (double)distances.get(i));
		}
		return dijkstraCarcassSearch.findCarcass(root, adjacencyMatrix);
	}

	@Override
	public DijkstraCarcassSearchResult removeVertex(int a) {
		for(int i = 0; i < adjacencyMatrix.rows(); i++) {
			adjacencyMatrix.set(a, i, graphUtils.InfinityWeight);
			adjacencyMatrix.set(i, a, graphUtils.InfinityWeight);
		}
		return dijkstraCarcassSearch.findCarcass(root, adjacencyMatrix);
	}

	@Override
	public DijkstraCarcassSearchResult init(int root, Matrix adjacencyMatrix) {
		this.root = root;
		this.adjacencyMatrix = adjacencyMatrix;
		result = dijkstraCarcassSearch.findCarcass(root, adjacencyMatrix);
		return result;
	}
	
	private void smartUpdate(int v) {
		for(int u: result.getGraph().get(v)) {
//			adjacencyMatrix.set(u, v, result.getDistances().get(v) + adjacencyMatrix);
		}
	}
}
