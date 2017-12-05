package ua.edu.lnu.computer_networks.algorithms.carcass.distance.dijkstra;

import org.la4j.Matrix;

import ua.edu.lnu.computer_networks.algorithms.carcass.CarcassSearch;
import ua.edu.lnu.computer_networks.algorithms.model.Path;

public interface DijkstraCarcassSearch extends CarcassSearch {

	@Override
	DijkstraCarcassSearchResult findCarcass(int root, Matrix adjacencyMatrix);
	
	Path findPath(int from, int to, Matrix adjacencyMatrix);
}
