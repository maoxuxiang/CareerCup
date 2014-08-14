package Linked_Lists;

public class reverseList {
	
	class Node {  
	    //变量  
	    private int record;  
	    //指向下一个对象  
	    private Node nextNode;  
	  
	    public Node(int record) {  
	        super();  
	        this.record = record;  
	    }  
	    public int getRecord() {  
	        return record;  
	    }  
	    public void setRecord(int record) {  
	        this.record = record;  
	    }  
	    public Node getNextNode() {  
	        return nextNode;  
	    }  
	    public void setNextNode(Node nextNode) {  
	        this.nextNode = nextNode;  
	    }  
	}  
	
	// recurse
	public static Node reverse(Node head) {
		if (head == null || head.getNextNode() == null) {
			return head;
		}
		
		Node next = reverse(head.getNextNode());
		head.getNextNode().setNextNode(head);
		head.setNextNode(null);
		
		return next;
	} 
	
	// iteration 
	public static Node reverse2(Node head) {
		if (head == null) {
			return head;
		}
		
		Node pre = head;
		Node cur = head.getNextNode();
		Node next;
		
		while (cur != null) {
			next = cur.getNextNode();
			cur.setNextNode(pre);
			pre = cur;
			cur = next;
		}
		
		head.setNextNode(null);
		head = pre;
		
		return head;
	}
}
