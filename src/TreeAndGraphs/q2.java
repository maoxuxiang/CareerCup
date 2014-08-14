/*
 * Give a directed graph, design an algorithm to find out whether there is a route between two nodes.
 */

package TreeAndGraphs;

import java.util.LinkedList;

import org.w3c.dom.Node;

import com.sun.corba.se.impl.orbutil.graph.Graph;




public class q2 {
	
	public enum State {
		unvisited, visiting, visited;
	}
	
	public static boolean search(Graph g, Node start, Node end) {
		LinkedList<Node> q = new LinkedList<Node>();
		
		for (Node u : g.getNodes()) {
			u.state = State.unvisited;
		}
		
	    start.state = State.visiting;
	    q.add(start);
	    Node u;
	    
	    while (!q.isEmpty()) {
	    	u = q.removeFirst();
	    	if (u != null) {
	    		for (Node v : u.getAdjacent()) {
	    			if(v.state == State.unvisited) {
	    				if (v == end)
	    					return true;
	    				else {
	    					v.state = State.visiting;
	    					q.add(v);
	    				}
	    			}
	    		}
	    		u.state = State.visited;
	    	}
	    	
	    }
		
		return false;
	}

}
