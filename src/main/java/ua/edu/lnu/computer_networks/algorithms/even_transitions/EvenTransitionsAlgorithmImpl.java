package ua.edu.lnu.computer_networks.algorithms.even_transitions;

import org.la4j.Matrix;

import ua.edu.lnu.computer_networks.algorithms.carcass.distance.dijkstra.DijkstraCarcassSearch;
import ua.edu.lnu.computer_networks.algorithms.carcass.distance.dijkstra.DijkstraCarcassSearchImpl;
import ua.edu.lnu.computer_networks.algorithms.carcass.distance.dijkstra.DijkstraCarcassSearchResult;
import ua.edu.lnu.computer_networks.utils.GraphUtils;

public class EvenTransitionsAlgorithmImpl implements EvenTransitionsAlgorithm {
	
	private final GraphUtils graphUtils = new GraphUtils(Double.MAX_VALUE / 2);
	
	@Override
	public EvenTransitionResult init(int root, Matrix adjacencyMatrix) {
		DijkstraCarcassSearch dijkstraCarcassSearch = new DijkstraCarcassSearchImpl(graphUtils);
		DijkstraCarcassSearchResult dijkstraResult = dijkstraCarcassSearch.findCarcass(root, adjacencyMatrix);
		EvenTransitionResult result = new EvenTransitionResult();
		result.setEt(dijkstraResult.getEdges());
		
		for(int i = 0; i < adjacencyMatrix.rows(); i++)
			for(int j = 0; j < adjacencyMatrix.columns(); j++) 
				if (adjacencyMatrix.get(i, j) > 0) {
					if (result.EtContains(i, j)) {
						
					}
				}
		return result;
	}

}
