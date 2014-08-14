/*
 * Design an algorithm and write code to find the first common ancestor of two nodes in
 * a binary tree. Avoid storing additional nodes in a data structure. // this is not necessarily a binary search tree.
 */

package TreeAndGraphs;

public class q7 {
	
	// solution 1:
	boolean covers(TreeNode root, TreeNode n) {
		if (root == null) return false;
		if (root == n) return true;
		
		else return covers(root.left, n) || covers(root.right, n);
	}
	
	public TreeNode commonAncestorHelper (TreeNode root, TreeNode p, TreeNode q) {
		
		if (root == root) return null;
		
		if (root == p || root == q) return root;
		
		boolean is_p_left = covers(root.left, p);
		boolean is_q_left = covers(root.left, q);
		
		if (is_p_left != is_q_left) {
			return root;
		}
		
		TreeNode child = is_p_left? root.left: root.right;
		
		return commonAncestorHelper(child, p, q);	
	}
	
	public TreeNode commonAncesto(TreeNode root, TreeNode p, TreeNode q) {
		if (!covers(root,p) || !covers(root,q))
			return null;
		else 
			return commonAncestorHelper(root, p, q);
	}
	
	//solution 2:
	

}
