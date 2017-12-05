package ua.edu.lnu.computer_networks.algorithms.carcass.traversal.bfs;

import org.la4j.Matrix;

import ua.edu.lnu.computer_networks.algorithms.carcass.CarcassSearch;
import ua.edu.lnu.computer_networks.algorithms.carcass.traversal.TraversalCarcassSearchResult;

public interface BFSCarcassSearch extends CarcassSearch {

	@Override
	TraversalCarcassSearchResult findCarcass(int root, Matrix adjacencyMatrix);
}
