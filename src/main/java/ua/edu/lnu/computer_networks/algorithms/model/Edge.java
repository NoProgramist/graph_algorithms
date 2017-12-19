package ua.edu.lnu.computer_networks.algorithms.model;

public class Edge implements Comparable<Edge> {

	protected int source;

	protected int target;

	protected boolean left;

	protected boolean right;

	protected double weight;

	public Edge(int source, int target, boolean left, boolean right, double weight) {
		super();
		this.source = source;
		this.target = target;
		this.left = left;
		this.right = right;
		this.weight = weight;
	}

	public int getSource() {
		return source;
	}

	public void setSource(int source) {
		this.source = source;
	}

	public int getTarget() {
		return target;
	}

	public void setTarget(int target) {
		this.target = target;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public boolean isBiDirectional() {
		return this.left && this.right;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + source;
		result = prime * result + target;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Edge other = (Edge) obj;
		if (source != other.source)
			return false;
		if (target != other.target)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Edge [source=" + source + ", target=" + target + ", weight=" + weight + "]";
	}

	@Override
	public int compareTo(Edge o) {
		int sourceCompare = Integer.compare(source, o.source);
		return sourceCompare != 0 ? sourceCompare : Integer.compare(target, o.target);
	}

}
