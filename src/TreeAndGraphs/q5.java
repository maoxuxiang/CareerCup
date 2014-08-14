/*
 * Implement a function to check if a binary tree is a binary search tree.
 */

package TreeAndGraphs;

public class q5 {
	
	public static Integer last_printed = null;
	public static boolean checkBST(TreeNode root) {
		if (root == null) return true;
		
		if(!checkBST(root.left)) return false;
		
		if (last_printed != null && last_printed<=root.data)
			return true;
		last_printed = root.data;
		
		if(!checkBST(root.right)) return false;
		
		return true;
	}

	
	//solution 2:
	boolean checkBST(TreeNode n) {
		return checkBST(n, INT_MIN, INT_MAX);
	}
	
	boolean checkBST(TreeNode n, int min, int max) {
		if (n == null) return true;
		
		if (min <= n.data < max)
			return checkBST(n.left, min, n.data) &&
					checkBST(n.right, n.data, max);
		
		return false;
	}
	
}
