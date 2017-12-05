package ua.edu.lnu.computer_networks.algorithms.carcass.distance.bellman_ford;

import org.la4j.Matrix;

import ua.edu.lnu.computer_networks.algorithms.carcass.CarcassSearch;

public interface BellmanFordCarcassSearch extends CarcassSearch {

	@Override
	BellmanFordCarcassSearchResult findCarcass(int root, Matrix adjacencyMatrix);

}
