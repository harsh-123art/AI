private Function < Node, Double > heuristic;

	public GBFS(Function < Node, Double > heuristic) {
	    this.heuristic = heuristic;
	}

	public Node search(Node start, Predicate < Node > endPredicate) {
	    //Check if the start node is the endPredicate
	    if (endPredicate.test(start))
	        return start;

	    //The queue containing all the nodes we have to search for
	    StablePriorityQueue < Double, Node > nodeQueue = new StablePriorityQueue < > ();
	    //Add the start node as the head. The priority does not matter since we remove it anyway.
	    nodeQueue.add(new Pair < > (heuristic.apply(start), start));
	    //Adjacent, definition from the handbook.pdf contain all neighbors.
	    //That means, that we would search in a node which we already searched for at another position.
	    //Because of the insertion and lookup time O(1) in both situations, we chose the HashSt.
	    HashSet < Node > checkedNodes = new HashSet < > ();
	    //Insert the start node into the hashset, since we are using it
	    checkedNodes.add(start);

	    //Repeat till we have no element in the queue left.
	    while (nodeQueue.size() > 0) {
	        Pair < Double, Node > currentNode = nodeQueue.remove();
	        if (endPredicate.test(currentNode.s))
	            return currentNode.s;
	        //Nothing found. Add all it's children
	        else currentNode.s.adjacent().stream() //Get the stream
	            .filter(node - > !checkedNodes.contains(node)) //Filter only the nodes we did not visit yet.
	            .forEach(node - > {
	                nodeQueue.add(new Pair < > (heuristic.apply(node), node)); //Add the node to the priority queue to search for the result.
	                checkedNodes.add(node); //Add the node to the hashset, so that we do not search for that again.
	            });
	    }

	    //We cant reach that state, but just in case return null.
	    return null;
	}
