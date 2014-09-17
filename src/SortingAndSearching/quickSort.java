package SortingAndSearching;

public class quickSort {
	
	public static void quickSort(int[] a) {
		int left = 0;
		int right = a.length - 1;
		quickSort(a, left, right);
	}
	
	private static void quickSort(int[] a, int left, int right) {
		 // If both cursor scanned the complete array, quicksort exits
		if (left >= right) {
			return;
		}
		
		// Pivot using median of 3 approach
		int pivot = getMedian(a, left, right);
		int partition = partition(a, left, right, pivot);
		
		quickSort(a, 0, partition -1);
		quickSort(a, partition+1, right);
	}
	
	  // This method is used to partition the given array and returns the integer which points to the sorted pivot index
	private static int partition(int[] a, int left, int right, int pivot) {
		int leftCursor = left -1;
		int rightCursor = right;
		
		while (leftCursor < rightCursor) {
			while (a[++leftCursor] < pivot);
			while (a[--rightCursor] > pivot && rightCursor > 0);
			if (leftCursor < rightCursor) {
				swap(a, leftCursor, rightCursor);
			} else {
				break;
			}
		}
		
		swap(a, leftCursor, right);
		return leftCursor;
	}
	
	private static void swap(int[] a, int x, int y) {
		int tmp = a[x];
		a[x] = a[y];
		a[y] = tmp;
	}

	private static int getMedian(int[] a, int left, int right) {
		int center = (left + right) / 2;
		
		if (a[left]> a[center]) {
			swap(a, left, center);
		}
		if (a[left]> a[right]) {
			swap(a, left, right);
		}
		if  (a[center] > a[right]) {
			swap(a, center, right);
		}
		
		swap(a, center, right);
		return a[right];
	}
	
	public static void main(String[] args) {
		int[] array = {1,54,675,234,2346,79,450,954,22,6779,567};
		quickSort(array);
		for (int i =0; i<array.length; i++) {
			System.out.println(array[i] + "d");
		}
	
	}

}
