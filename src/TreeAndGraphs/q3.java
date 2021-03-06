/*
 * Given a sorted (increasing order) array, write an algorithm to create a binary tree with 
 * minimal height
 */

package TreeAndGraphs;

public class q3 {
	
	TreeNode createMinimalBST (int[] arr, int start, int terminal) {
		if(terminal < start)
			return null;
		
		int mid = (start + terminal) / 2;
		TreeNode n = new TreeNode(arr[mid]);
		n.left = createMinimalBST(arr, start, mid-1);
		n.right = createMinimalBST(arr, mid+1, terminal);
		return n;
	}
	
	TreeNode createMinimalBST(int[] array) {
		return (array, 0, array.length-1);
	}

}
