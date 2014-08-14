/*
 * hanoi
 */

package StacksAndQueues;

import java.util.LinkedList;



public class q4 {
	
	public static void moveDisks(Tower from, Tower destination, Tower buffer, int n) {
		
		if(n == 0) {
			return;
		}
		
		if (n == 1) {
			from.moveTo(destination);
		}
		
		else {
			moveDisks(from, buffer, destination, n-1);
			from.moveTo(destination);
			moveDisks(buffer, destination, from, n-1);
		}
		
	}
	
	class Tower {
		private LinkedList<Integer> tower;
		
		public Tower() {
			this.tower = new LinkedList<Integer>();
		}
		
		public boolean add(int disk) {
			if(tower.isEmpty() || tower.peek() > disk) {
				tower.push(disk);
				return true;
			}
			return false;
		}
		
		public boolean moveTo(Tower destination) {
			
			if (tower.isEmpty()) 
				return false;
			return destination.add(tower.pop());
		}
		
		public String toString() {
			return tower.toString();
		}
	}

}
