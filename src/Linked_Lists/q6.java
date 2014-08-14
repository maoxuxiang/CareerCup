package Linked_Lists;

/*
 * Given a circular linked list, implement an algorithm which returns that node ata the begainning of the loop.
 */

public class q6 {
	
	LinkedListNode FindBeginning (LinkedListNode head) {
		LinkedListNode slow = head;
		LinkedListNode fast = head;
		
		if (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				break;
			}
		}
		
		if (fast == null || fast.next == null) {
			return null;
		}
		
		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		
		return slow;
		
	}

}
