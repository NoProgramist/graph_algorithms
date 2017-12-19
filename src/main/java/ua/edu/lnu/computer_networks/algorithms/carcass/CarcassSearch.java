package ua.edu.lnu.computer_networks.algorithms.carcass;

import org.la4j.Matrix;

import ua.edu.lnu.computer_networks.algorithms.model.SimpleGraph;

public interface CarcassSearch {

	CarcassSearchResult findCarcass(int root, SimpleGraph graph);

	CarcassSearchResult findCarcass(int root, Matrix adjacencyMatrix);
}
