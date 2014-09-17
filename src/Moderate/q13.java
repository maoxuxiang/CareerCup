package Moderate;
/**
 * Consider a simple node-like data structure called BiNode, which has pointers
 * to two other nodes.
 * 
 * The data structure BiNode could be used to represent both a binary tree (were
 * first is the left node and second is the right node) or a doubly linked list
 * (where first is the previous node and second is the next node). Implement a
 * method to convert a binary search tree (implemented with BiNode) into a
 * doubly linked list in place.
 * 
 */
public class q13 {

	public static class BiNode {
		int value;
		BiNode first;
		BiNode second;
		
		public BiNode(int value) {
			this.value = value;
		}
	}
	
	public static BiNode flatten(BiNode root) {
		if (root == null) {
			return null;
		}
		
		BiNode node1 = flatten(root.first);
		BiNode node2 = flatten(root.second);
		
		if (node1 != null) {
			node1.first = null;
			BiNode tail = getTail(node1);
			tail.second = root;
			root.first = tail;
		}
		
		if (node2 != null) {
			root.second = node2;
			node2.first = root;
		}
		
		return node1 == null ? root: node1;
	}
	
	private static BiNode getTail(BiNode node) {
		if (node == null) {
			return null;
		}
		
		BiNode cur = node;
		while (cur.second != null) {
			cur = cur.second;
		}
		
		return cur;
	}
	
}
