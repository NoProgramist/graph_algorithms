package ua.edu.lnu.computer_networks.algorithms.carcass.distance;

import org.la4j.Matrix;

import ua.edu.lnu.computer_networks.algorithms.carcass.CarcassSearch;
import ua.edu.lnu.computer_networks.algorithms.model.SimpleGraph;

public interface DistanceCarcassSearch extends CarcassSearch {

	@Override
	DistanceCarcassSearchResult findCarcass(int root, SimpleGraph graph);

	@Override
	DistanceCarcassSearchResult findCarcass(int root, Matrix adjacencyMatrix);
}
