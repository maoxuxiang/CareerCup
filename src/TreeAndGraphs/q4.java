/*
 * Given a binary search tree, design an algorithm which creates a linked list of all the 
 * nodes at each depth (i e , if you have a tree with depth D, you¡¯ll have D linked lists)
 */

package TreeAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.tree.TreeNode;

public class q4 {
	
	void createLevelLinkedList(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level) {
		if (root == null) {
			return;
		}
		
		LinkedList<TreeNode> list = null;
		if (lists.size() == level) {
			list = new LinkedList<TreeNode>();
			lists.add(list);
		}
		else {
			list = lists.get(level);
		}
		
		list.add(root);
		createLevelLinkedList(root.left, lists, level+1);
		createLevelLinkedList(root.right, lists, level+1);
	}
	 
	ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
		ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
		createLevelLinkedList(root, lists, 0);
		return lists;
	}

	//solution2:
	
	ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
		ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
		if (root == null)
			return null;
		LinkedList<TreeNode> current = new LinkedList<TreeNode>();
		current.add(root);
		
		while (current.size()>0) {
			result.add(current);
			LinkedList<TreeNode> parents = current;
			current = new LinkedList<TreeNode>();
			
			for (TreeNode parent : parents) {
				if (parent.left != null) {
					current.add(parent.left);
				}
				else if (parent.right != null) {
					current.add(parent.right);
				}
			}
		}
		return result;
	}
	
}
