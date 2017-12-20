package ua.edu.lnu.computer_networks.algorithms.model;

public class Edge {

	private Integer a;

	private Integer b;

	public Integer getA() {
		return a;
	}

	public void setA(Integer a) {
		this.a = a;
	}

	public Integer getB() {
		return b;
	}

	public void setB(Integer b) {
		this.b = b;
	}

	public Edge(Integer a, Integer b) {
		super();
		this.a = a;
		this.b = b;
	}

	@Override
	public String toString() {
		return "(" + (a + 1) + ", " + (b + 1) + ")";
	}

	@Override
	public int hashCode() {
		return a * b;
	}

	@Override
	public boolean equals(Object other){
		if (other == null) return false;
		if (other == this) return true;
		if (!(other instanceof Edge))return false;
		Edge edge = (Edge)other;
		return a == edge.a && b == edge.b;
	}
}
