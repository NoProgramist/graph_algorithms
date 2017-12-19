package ua.edu.lnu.computer_networks.algorithms.carcass.distance.bellman_ford;

import org.la4j.Matrix;

import ua.edu.lnu.computer_networks.algorithms.carcass.distance.DistanceCarcassSearch;
import ua.edu.lnu.computer_networks.algorithms.model.SimpleGraph;

public interface BellmanFordCarcassSearch extends DistanceCarcassSearch {

	@Override
	BellmanFordCarcassSearchResult findCarcass(int root, SimpleGraph graph);

	@Override
	BellmanFordCarcassSearchResult findCarcass(int root, Matrix adjacencyMatrix);

}
