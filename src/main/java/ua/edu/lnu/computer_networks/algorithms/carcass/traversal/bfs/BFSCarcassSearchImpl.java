package ua.edu.lnu.computer_networks.algorithms.carcass.traversal.bfs;

import ua.edu.lnu.computer_networks.algorithms.carcass.traversal.TraversalCarcassSearch;

public class BFSCarcassSearchImpl extends TraversalCarcassSearch implements BFSCarcassSearch {

	@Override
	protected TravesalDequeue getTravesalDequeue() {
		return new TravesalDequeue() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			protected void pushTravesalNode(Integer value) {
				this.addLast(value);
			}

			@Override
			protected Integer nextTravesalNode() {
				return this.getFirst();
			}

			@Override
			protected Integer popTravesalNode() {
				return this.removeFirst();
			}

		};
	}
}
