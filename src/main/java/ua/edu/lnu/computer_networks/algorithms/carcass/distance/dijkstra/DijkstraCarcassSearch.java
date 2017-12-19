package ua.edu.lnu.computer_networks.algorithms.carcass.distance.dijkstra;

import org.la4j.Matrix;

import ua.edu.lnu.computer_networks.algorithms.carcass.distance.DistanceCarcassSearch;
import ua.edu.lnu.computer_networks.algorithms.model.Path;
import ua.edu.lnu.computer_networks.algorithms.model.SimpleGraph;

public interface DijkstraCarcassSearch extends DistanceCarcassSearch {

	@Override
	DijkstraCarcassSearchResult findCarcass(int root, SimpleGraph graph);

	@Override
	DijkstraCarcassSearchResult findCarcass(int root, Matrix adjacencyMatrix);

	Path findPath(int from, int to, Matrix adjacencyMatrix);
}
