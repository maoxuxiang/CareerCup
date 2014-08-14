package Linked_Lists;

/*
 * Write code to partition a linked list around a value x, such that all nodes less than x 
 * come before all nodes greader than or equal to x.
 */
public class q4 {
	
	public LinkedListNode partition(LinkedListNode node, int x) {
		LinkedListNode beforeStart = null;
		LinkedListNode beforeEnd = null;
		LinkedListNode afterStart = null;
		LinkedListNode afterEnd = null;
		
		while (node != null) {
			LinkedListNode next = node.next;
			node.next = null;
			if (node.data < x) {
				if (beforeStart == null) {
					beforeStart = node;
					beforeEnd = beforeStart;
				}
				else {
					beforeEnd.next = node;
					beforeEnd = node;
				}
			}
			else {
				if (afterStart = null) {
					afterStart = node;
					afterEnd = afterStart;
				}
				else {
					afterEnd.next = node;
					afterEnd = node;
				}
			}
			
			node = next;
		}
		
		if (beforeStart == null) 
			return afterStart;
		
		beforeEnd.next = afterStart;
		return beforeStart;
		
	}
	
	public LinkedListNode partition2(LinkedListNode node, int x) {
		LinkedListNode beforeStart = null;
		LinkedListNode afterStart = null;
		
		while (node != null) {
			LinkedListNode next = node.next;
			if (node.data < x) {
					node.next = beforeStart;
					beforeStart = node;
			}
			else {
				node.next = afterStart;
				afterStart = node;
			}
			node = next;
		}
		
		if (beforeStart == null) 
			return afterStart;
		
		LinkedListNode head = beforeStart;
		if (beforeStart.next != null) {
			beforeStart = beforeStart.next;
		}
		beforeStart.next = afterStart;
		return head;
			
	}
	

	

}
