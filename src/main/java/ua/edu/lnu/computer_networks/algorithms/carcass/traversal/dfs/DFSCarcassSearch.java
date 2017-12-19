package ua.edu.lnu.computer_networks.algorithms.carcass.traversal.dfs;

import org.la4j.Matrix;
import org.la4j.Vector;

import ua.edu.lnu.computer_networks.algorithms.carcass.traversal.TraversalCarcassSearch;
import ua.edu.lnu.computer_networks.algorithms.carcass.traversal.TraversalCarcassSearchResult;
import ua.edu.lnu.computer_networks.algorithms.model.SimpleGraphUtils;

public class DFSCarcassSearch extends TraversalCarcassSearch {

	public DFSCarcassSearch(SimpleGraphUtils graphUtils) {
		super(graphUtils);
	}

	@Override
	public TraversalCarcassSearchResult findCarcass(int root, Matrix adjMat) throws IllegalArgumentException {
		checkArgs(root, adjMat);
		Matrix carcass = Matrix.constant(adjMat.rows(), adjMat.columns(), graphUtils.getMaxWeight());
		Vector traversalSeq = Vector.constant(adjMat.rows(), -1.0);
		Integer traversalId = 0;
		TravesalDequeue traversalDequeue = getTravesalDequeue();
		boolean[] wasProcessed = new boolean[adjMat.columns()];
		traversalDequeue.pushTravesalNode(root);
		wasProcessed[root] = true;
		traversalSeq.set(root, traversalId++);
		do {
			int head = traversalDequeue.nextTravesalNode();
			wasProcessed[head] = true;
			boolean flag = true;
			Vector nodeAdjacency = Vector.constant(adjMat.rows(), graphUtils.getMaxWeight());
			for (int j = 0; j < wasProcessed.length; ++j) {
				if (wasProcessed[j]) {
					nodeAdjacency.set(j, graphUtils.getMaxWeight());
				} else {
					if (adjMat.get(head, j) != graphUtils.getMaxWeight()) {
						traversalDequeue.pushTravesalNode(j);
						traversalSeq.set(j, traversalId++);
						nodeAdjacency.set(j, adjMat.get(head, j));
						flag = false;
						break;
					}
				}
			}
			if (flag) {
				traversalDequeue.popTravesalNode();
			} else {
				nodeAdjacency.set(head, adjMat.get(head, head));
				carcass.setRow(head, nodeAdjacency);
			}
		} while (!traversalDequeue.isEmpty());
		return new TraversalCarcassSearchResult(graphUtils.buildGraph(carcass), traversalSeq);
	}

	@Override
	protected TravesalDequeue getTravesalDequeue() {
		return new TravesalDequeue() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void pushTravesalNode(Integer value) {
				this.addLast(value);
			}

			@Override
			public Integer nextTravesalNode() {
				return this.getLast();
			}

			@Override
			public Integer popTravesalNode() {
				return this.removeLast();
			}

		};
	}

}
