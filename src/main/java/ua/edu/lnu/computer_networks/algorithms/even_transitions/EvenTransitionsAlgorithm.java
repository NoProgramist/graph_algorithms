package ua.edu.lnu.computer_networks.algorithms.even_transitions;

import org.la4j.Matrix;

public interface EvenTransitionsAlgorithm {
	
	EvenTransitionResult init(int root, Matrix adjacencyMatrix);
}
