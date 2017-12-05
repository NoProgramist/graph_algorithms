package ua.edu.lnu.computer_networks.utils;

public class GraphUtils {

	public final double InfinityWeight;

	public GraphUtils() {
		this(Double.MAX_VALUE / 2);
	}

	public GraphUtils(double infinityWeight) {
		super();
		InfinityWeight = infinityWeight;
	}

}
