/*
 * Write a algorithm to find the 'next' node (i.e. in-order successor) of a given node in a binary
 * search tree. you may assume that each mode has a link to its parent.
 */

package TreeAndGraphs;

public class q6 {
	
	public TreeNode inorderSucc (TreeNode n) {
		if (n == null) return null;
		
		if (n.right != null) 
			return LeftMostChild (n.right);
		else {
			TreeNode p = n;
			TreeNode x = p.parent;
			
			while (x != null && x.left != p) {
				p = x;
				x = x. parent;
			}
			
			return x;
		}
	}
	
	public TreeNode LeftMostChild (TreeNode n) {
		if (n == null)
			return null;
		else
			while (n.left != null) {
				n = n.left;
			}
		return n;
	}

}
