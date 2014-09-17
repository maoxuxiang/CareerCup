package SortingAndSearching;

public class BinarySearch {
	
	private static int BinaySearch(int[] array, int left, int right, int aim) {
		int mid;
		while (left <= right) {
		    mid = (left + right)/2;
			
			if (array[mid] == aim) {
				return mid;
			}
			if (array[mid] > aim) {
				right = mid -1;
			}
			else {
				left = mid +1;
			}
		}
		
		return -1;
	}
	
	public static int BinaySearch(int[] array, int key) {
		return BinaySearch(array, 0, array.length-1, key);
	}

	public static void main(String[] args) {
		int[] array = {1,3,5,7,9,10,23,56,66,78,89};
		System.out.print(BinaySearch(array,66));
	}
}
