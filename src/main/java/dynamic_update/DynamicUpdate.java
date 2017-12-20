package dynamic_update;

import java.util.Vector;

import org.la4j.Matrix;

import ua.edu.lnu.computer_networks.algorithms.carcass.distance.dijkstra.DijkstraCarcassSearchResult;

public interface DynamicUpdate {

	DijkstraCarcassSearchResult updateEdge(int a, int b, double weight);

	DijkstraCarcassSearchResult init(int root, Matrix adjacencyMatrix);

}
