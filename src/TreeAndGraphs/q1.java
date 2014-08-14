/*
 * 
 *Implement a function to check if a tree is balanced   For the purposes of this question, 
 *a balanced tree is defined to be a tree such that no two leaf nodes differ in distance 
 *from the root by more than one
 */
                                                                
package TreeAndGraphs;

public class q1 {

	//solution 1, O(N*logN)time
	public static int getHeight(TreeNode root) {
		if (root == null) 
			return 0;
		else 
			return Math.max(getHeight(root.left), getHeight(root.right))+1;
	}
	
	public static boolean isBalanced(TreeNode root) {
		if (root == null) 
			return true;
		int lh = getHeight(root.left);
		int rh = getHeight(root.right);
		
		int diff = Math.abs(lh - rh);
		if (diff > 1)
			return false;
		else
			return isBalanced(root.left) && isBalanced(root.right);
	}
	
	//solution 2
	public static int getHeight2(TreeNode root) {
		if (root == null)
			return 0;
		int lh = getHeight2(root.left);
		if (lh == -1)
			return -1;
		
		int rh = getHeight2(root.right);
		if (rh == -1)
			return -1;
		
		if (Math.abs(getHeight2(root.left) - getHeight(root.right)) > 1) 
			return -1;
		else
			return Math.max(getHeight2(root.left), getHeight2(root.right))+1;
	}
	
	public static boolean isBalanced2(TreeNode root) {
		if (getHeight2(root) == -1)
			return false;
		else
			return true;
	}

}
