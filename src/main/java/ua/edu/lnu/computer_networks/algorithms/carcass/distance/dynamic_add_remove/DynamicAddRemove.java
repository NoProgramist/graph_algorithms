package ua.edu.lnu.computer_networks.algorithms.carcass.distance.dynamic_add_remove;

import java.util.Vector;

import org.la4j.Matrix;

import ua.edu.lnu.computer_networks.algorithms.carcass.distance.dijkstra.DijkstraCarcassSearchResult;

public interface DynamicAddRemove {
	
	DijkstraCarcassSearchResult addEdge(int a, int b, double weight);
	
	DijkstraCarcassSearchResult removeEdge(int a, int b);
	
	DijkstraCarcassSearchResult addVertex(int a, Vector distances);
	
	DijkstraCarcassSearchResult removeVertex(int a);
	
	DijkstraCarcassSearchResult init(int root, Matrix adjacencyMatrix);
}
