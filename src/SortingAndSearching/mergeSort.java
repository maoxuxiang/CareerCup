package SortingAndSearching;

public class mergeSort {
	
	public static void mergeSort(Comparable[] a) {
		Comparable[] tmpArray = new Comparable[a.length];
		mergeSort(a, tmpArray, 0, a.length-1);
		
	}
	
	private static void mergeSort(Comparable[] a, Comparable[] tmpArray, int left, int right) {
		if (left < right) {
			
			int center = (left + right)/2;
			mergeSort(a, tmpArray, left, center);
			mergeSort(a, tmpArray, center+1, right);
			merge(a, tmpArray, left, center+1, right);
		}
	}
	
	private static void merge(Comparable[] a, Comparable[] tmpArray, int leftPos,int rightPos, int rightEnd) {
		int leftEnd = rightPos - 1;
		int temPos = leftPos;
		int numbleElements = rightPos - leftPos +1;
		//compare left and right element and copy the smaller one into tmpArray
		while (leftPos<=leftEnd && rightPos <= rightEnd) {
			if(a[leftPos].compareTo(a[rightPos]) <= 0) {
				tmpArray[temPos ++] = a[leftPos ++];
			} else {
				tmpArray[temPos ++] = a[rightPos ++];
			}
		}
		// copy the rest left element
		while (leftPos <= leftEnd) {
			tmpArray[temPos ++] = a[leftPos ++];
		}
		
		while (rightPos <= rightEnd) {
			tmpArray[temPos ++] = a[rightPos ++];
		}
		// copy tmpArray into the original array
		for (int i=0; i<numbleElements; i++, rightEnd--) {
			a[rightEnd] = tmpArray[rightEnd];
		}
	}
	
	public static void main(String[] args) {
		Integer[] array = {1,54,675,234,2346,79,450,954,22,6779,567};
		mergeSort(array);
		for (int i =0; i<array.length; i++) {
			System.out.println(array[i]);
		}
	
	}

}
