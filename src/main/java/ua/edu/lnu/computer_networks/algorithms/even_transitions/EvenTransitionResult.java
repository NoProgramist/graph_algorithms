package ua.edu.lnu.computer_networks.algorithms.even_transitions;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.la4j.Matrix;

import ua.edu.lnu.computer_networks.algorithms.model.Edge;

public class EvenTransitionResult {
	
	private Collection<Edge> Et;
	
	private Map<Integer, Integer> nextOptimalVertex;
	
	private Matrix ws;
	
	private Matrix wt;

	public Collection<Edge> getEt() {
		return Et;
	}

	public void setEt(Collection<Edge> et) {
		Et = et;
	}
	public EvenTransitionResult() {
		Et = new HashSet<>();
		nextOptimalVertex = new HashMap<>();
	}

	public Matrix getWs() {
		return ws;
	}

	public void setWs(Matrix ws) {
		this.ws = ws;
	}

	public Matrix getWt() {
		return wt;
	}

	public void setWt(Matrix wt) {
		this.wt = wt;
	}

	public Map<Integer, Integer> getNextOptimalVertex() {
		return nextOptimalVertex;
	}

	public void setNextOptimalVertex(Map<Integer, Integer> nextAddVertex) {
		this.nextOptimalVertex = nextAddVertex;
	}
	
	
	public boolean EtContains(int a, int b) {
		Edge e = new Edge(a, b);
		Edge re = new Edge(b, a);
		return Et.contains(e) || Et.contains(re);
	}
}
