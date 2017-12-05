package ua.edu.lnu.computer_networks.algorithms.yen;

import java.util.List;

import org.la4j.Matrix;

import ua.edu.lnu.computer_networks.algorithms.model.Path;

public interface YensPathesSearch {
	
	List<Path> findKthShortestPath(int from, int to, int k, Matrix adjacencyMatrix);
}
