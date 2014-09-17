package Hard;


import java.util.ArrayList;
import java.util.HashMap;


/**
 * Given a string s and an array of smaller strings T, design a method to search
 * s for each small string in T.
 * 
 */
// O(n) space, O(logn) time
public class q8 {
	
	public static void main(String[] args) {
		q8 a = new q8();

		// TODO Auto-generated method stub
		SuffixTree st = a.new SuffixTree("carddddcar");
		System.out.println(st.search("c"));
		System.out.println(st.root.value);
		
	}


  /**
   * Return the start indices of all the strings in T found in s. If not found,
   * the index is -1.
   * 
   * @param s
   * @param T
   * @return
   */

  class SuffixTreeNode {
		HashMap<Character, SuffixTreeNode> children = new HashMap<Character, SuffixTreeNode>();
		
		char value;
		ArrayList<Integer> indexes = new ArrayList<Integer>();
		
		public SuffixTreeNode() {
		}
		
		public void insertString(String s, int index) {
			indexes.add(index);
			if (s != null && s.length() > 0) {
				value = s.charAt(0);
				SuffixTreeNode child = null;
				if (children.containsKey(value)) {
					child = children.get(value);
				}
				else {
					child = new SuffixTreeNode();
					children.put(value, child);
				}
				child.insertString(s.substring(1), index);
			}
		}

		public ArrayList<Integer> search(String s) {
			if (s == null || s.length() == 0) {
				return this.indexes;
			}
			else {
				char firstChar = s.charAt(0);
				if (children.containsKey(firstChar)) {
					return this.children.get(firstChar).search(s.substring(1));
				}
			}
			
			return null;
		}
	}

class SuffixTree {
	public SuffixTreeNode root = new SuffixTreeNode();
	
	public SuffixTree() {
		
	}
	
	public SuffixTree(String s) {
		for (int i = 0; i < s.length(); i++) {
			String suffix = s.substring(i);
			root.insertString(suffix, i);
		}
	}
	
	public ArrayList<Integer> search(String s) {
		return root.search(s);
	}
}


}