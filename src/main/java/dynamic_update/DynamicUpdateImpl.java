package dynamic_update;

import org.la4j.Matrix;

import ua.edu.lnu.computer_networks.algorithms.carcass.distance.dijkstra.DijkstraCarcassSearchResult;
import ua.edu.lnu.computer_networks.algorithms.carcass.distance.dynamic_add_remove.DynamicAddRemove;
import ua.edu.lnu.computer_networks.algorithms.carcass.distance.dynamic_add_remove.DynamicAddRemoveImpl;

public class DynamicUpdateImpl implements DynamicUpdate {

	private DynamicAddRemove solver = new DynamicAddRemoveImpl();
	
	@Override
	public DijkstraCarcassSearchResult updateEdge(int a, int b, double weight) {
		solver.removeEdge(a, b);
		return solver.addEdge(a, b, weight);
	}

	@Override
	public DijkstraCarcassSearchResult init(int root, Matrix adjacencyMatrix) {
		return solver.init(root, adjacencyMatrix);
	}

}
