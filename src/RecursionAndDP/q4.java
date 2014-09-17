package RecursionAndDP;

import java.util.ArrayList;

/**
 * Write a method to return all subsets of a set.
 * 
 */ 
// O(2^n) space, O(2^n) time
public class q4 {
	
	public static void main (String[] args) {
		ArrayList<Integer> set = new ArrayList<Integer>();
		set.add(1);
		set.add(2);
		set.add(3);
		ArrayList<ArrayList<Integer>> allSubsets = getSubsets(set,0);
		
		for (int i =0; i<allSubsets.size(); i++) {
			System.out.print(allSubsets.get(i) + " ");
		}
		System.out.print(allSubsets.size());
	}
	
	static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {
		
		ArrayList<ArrayList<Integer>> allSubsets;
		if(index == set.size()) {
			allSubsets = new ArrayList<ArrayList<Integer>>();
			allSubsets.add(new ArrayList<Integer>());
		}
		else {
			allSubsets = getSubsets(set, index +1);
			int item = set.get(index);
			ArrayList<ArrayList<Integer>> moreSubsets = new ArrayList<ArrayList<Integer>>();
			for (ArrayList<Integer> s : allSubsets) {
				ArrayList<Integer> newSubset = new ArrayList<Integer>();
				newSubset.addAll(s);
				newSubset.add(item);
				moreSubsets.add(newSubset);
			}
			allSubsets.addAll(moreSubsets);
		}
		
		return allSubsets;
	}
	
	 // Solution 2
	static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set) {
		ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<ArrayList<Integer>>();
		int n = set.size();
		int number = 1<<n;
		for (int i=0; i<number; i++) {
			ArrayList<Integer> subSet = convertInt(set, i);
			allSubsets.add(subSet);
		}
		return allSubsets;
	}
	
	static ArrayList<Integer> convertInt(ArrayList<Integer> set, int n) {
		ArrayList<Integer> subset = new ArrayList<Integer>();
		int index = 0;
		for(int i = n; i >0; i = i>>1) {
			if((i&1) == 1) {
				subset.add(set.get(index));
			}
			index++;
		}
		return subset;
	}
	

}
