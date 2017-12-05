package ua.edu.lnu.computer_networks.algorithms.carcass;

import org.la4j.Matrix;

public interface CarcassSearch {

	CarcassSearchResult findCarcass(int root, Matrix adjacencyMatrix);
}
