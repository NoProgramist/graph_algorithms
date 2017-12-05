package ua.edu.lnu.computer_networks.algorithms;

import org.la4j.Matrix;
import org.la4j.Vector;
import org.la4j.iterator.MatrixIterator;
import org.la4j.iterator.VectorIterator;

import ua.edu.lnu.computer_networks.utils.GraphUtils;

public class GraphSamples {

	private static final GraphUtils graphUtils = new GraphUtils(Double.MAX_VALUE / 2);
	private static final double n = graphUtils.InfinityWeight;

	private static final double[][] graph1 = { { n, 1.0, 1.0, 1.0, n, n }, { 1.0, n, 1.0, n, 1.0, n }, { 1.0, 1.0, n, 1.0, n, n }, { 1.0, n, 1.0, n, 1.0, n },
			{ n, 1.0, n, 1.0, n, n }, { n, n, n, n, n, n } };

	private static final double[][] graph2 = { { n, 1.0, 1.0, 1.0, n, n }, { 1.0, n, 1.0, n, 1.0, n }, { 1.0, 1.0, n, 1.0, n, n }, { 1.0, n, 1.0, n, 1.0, n },
			{ n, 1.0, n, 1.0, n, n }, { n, n, n, n, n, n } };

	private static final double[][] graph3 = { { n, 1.0, 1.0, 1.0, n, n }, { 1.0, n, 1.0, n, 1.0, n }, { 1.0, 1.0, n, 1.0, n, n }, { 1.0, n, 1.0, n, 1.0, n },
			{ n, 1.0, n, 1.0, n, n }, { n, n, n, n, n, n } };

	private static final double[][] graph4 = { { 0, 4, 2, n, n, n }, { 4, 0, 1, 5, n, n }, { 2, 1, 0, 8, 10, n }, { n, 5, 8, 0, 2, 6 }, { n, n, 10, 2, 0, 3 },
			{ n, n, n, 6, 3, 0 } };

	private static final double[][] graph5 = { { 0, 1, 4, n, n, n }, { 1, 0, 2, 15, n, n }, { 4, 2, 0, 10, 9, n }, { n, 15, 10, 0, 6, 6 }, { n, n, 9, 6, 0, -1 },
			{ n, n, n, 6, n, 0 } };
	
	public static final double[][] yenGraph = { 
			{ 0, 25, 27, 23, n }, 
			{ 25, 0, n, n, 25 }, 
			{ 27, n, 0, n, 23}, 
			{ 23, n, n, 0, 27 }, 
			{ n, 25, 23, 27, n } };

	public static final Matrix[] graphs = { Matrix.from2DArray(graph1), Matrix.from2DArray(graph2), Matrix.from2DArray(graph3), Matrix.from2DArray(graph4),
			Matrix.from2DArray(graph5) };

	public static final int[] rootNodes = { 0, 1, 1, 0, 3 };

	public static String format(Matrix adjMat) {
		StringBuilder builder = new StringBuilder();
		MatrixIterator iter = adjMat.iterator();
		for (int i = 0; i < adjMat.rows(); ++i) {
			for (int j = 0; j < adjMat.columns(); ++j) {
				double value = iter.next();
				if (value == n) {
					builder.append("NaN ");
				} else {
					builder.append(value);
				}
				builder.append("\t\t\t");
			}
			builder.append("\n");
		}
		return builder.toString();
	}

	public static String format(Vector adjVec) {
		StringBuilder builder = new StringBuilder();
		VectorIterator iter = adjVec.iterator();
		for (int i = 0; i < adjVec.length(); ++i) {
			double value = iter.next();
			if (value == n) {
				builder.append("NaN");
			} else {
				builder.append(value);
			}
			builder.append("\t\t\t");
		}
		builder.append("\n");
		return builder.toString();
	}
}
