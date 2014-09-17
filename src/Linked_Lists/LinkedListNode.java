package Linked_Lists;

public class LinkedListNode {
	
	int data;
	LinkedListNode next;
	
	LinkedListNode(int value) {
		this.data = value;
		this.next = null;
	}
	LinkedListNode() {
		this.data = (Integer) null;
		this.next = null;
	}
	public void setNext(LinkedListNode more) {
		this.next = more;
		
	}

}
