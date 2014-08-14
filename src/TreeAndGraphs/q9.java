/*
 * You are given a binary tree in which each node contains a value. Design an algorithm to print all paths which sum to a given value.
 * The path does not need to start or end at the root or a leaf.
 */

package TreeAndGraphs;

public class q9 {
	
	public void findSum(TreeNode node, int sum, int[] path, int level) {
		if (node == null) return;
		
		path[level] = node.data;
		
		int t = 0;
		for (int i = level; i>=0; i--) {
			t += path[i];
			if(t == sum) {
				print(path, i, level);
			}
		}
		
		findSum(node.left, sum, path, level+!);
		findSum(node.right, sum, path, level +1);
		
		path[level] = Integer.MIN_VALUE;
	}
	
	public void findSum (TreeNode node, int sum) {
		int depth = depth(node);
		int[] path = new int[depth];
		
		findSum (node, sum, path, 0);
	}
	
	void print (int[] path, int start, int end) {
		for (int i = start; i<= end; i++) {
			System.out.print(path[i] + " ");
		}
		System.out.println();
	}
	
	int depth (TreeNode node) {
		if (node == null) return 0;
		else 
			return 1 + Math.max(depth(node.left), depth(node.right));  
	}

}
