package ua.edu.lnu.computer_networks.algorithms.model;

public class Vertex implements Comparable<Vertex> {

	protected int id;

	protected boolean reflexive;

	public Vertex(int id, boolean reflexive) {
		super();
		this.id = id;
		this.reflexive = reflexive;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isReflexive() {
		return reflexive;
	}

	public void setReflexive(boolean reflexive) {
		this.reflexive = reflexive;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Vertex other = (Vertex) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Node [id=" + id + ", reflexive=" + reflexive + "]";
	}

	@Override
	public int compareTo(Vertex o) {
		return Integer.compare(id, o.id);
	}
}
