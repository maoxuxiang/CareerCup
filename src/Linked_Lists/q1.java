package Linked_Lists;

import com.sun.org.apache.xalan.internal.xsltc.runtime.Hashtable;

/*
 * Write code to remove duplicates from an unsorted linked list.
 * FOLLOW UP
 * how would you solve this problem if a temporary buffer is not allowed?
 */
public class q1 {
	public static void deleteDups(LinkedListNode n) {
		Hashtable table = new Hashtable();
		LinkListNode prev = null;
	    while (n != null) {
	    	if (table.containsKey(n.data)) {
	    		prev.next = n.next;
	    	} 
	    	else {
	    		table.put(n.data, true);
	    		prev = n;
	    	}
	    	n = n.next;
	    }
	}
	
	// Follow up, no buffer allowed
	
	public static void deleDups(LinkListNode head) {
		if (head == null) return;
		
		LinkListNode current = head;
		while (current != null) {
			LinkListNode runner = current;
			while (runner.next != null) {
				if(runner.next.data = current.data) {
					runner.next = runner.next.next;
				} 
				else {
					runner = runner.next;
				}
			}
			
			current = current.next;
			
		}
	}

}
