/*********************************************************
 * 
 * 95-772 Data Structures for Application Programmers
 * 
 * Lab 5 Comparing MergeSort with QuickSort
 * 
 * A very simple implementation 
 * of slightly improved version of quick sort
 * 
 *********************************************************/

import java.util.*;

public class QuickSortImproved {
	private static final int SIZE = 100000;
	private static Random rand = new Random();

	public static void main(String[] args) {
		int[] array = new int[SIZE];

		for (int i = 0; i < SIZE; i++) array[i] = rand.nextInt();

		// reversely ordered
		// for (int i = 0; i < SIZE; i++) array[i] = SIZE - i;
		 
		Stopwatch timer = new Stopwatch();
		quickSort(array);
		System.out.println("Time taken to sort " + SIZE
				+ " elements (Quick Sort Improved) : " + timer.elapsedTime()
				+ " milliseconds");

		// to make sure sorting works.
		// add "-ea" vm argument
		assert isSorted(array);
	}

	public static void quickSort(int[] array) {
		recQuickSort(array, 0, array.length - 1);
	}

	private static void recQuickSort(int[] array, int left, int right) {
		int leftPointer = left;
		int rightPointer = right;

		// Get the pivot value from the middle of the list
		int pivot = array[left + (right - left) / 2];

		// inner loops are simpler
		while (leftPointer <= rightPointer) {
			while (array[leftPointer] < pivot)
				leftPointer++;
			while (array[rightPointer] > pivot)
				rightPointer--;
			if (leftPointer <= rightPointer) {
				swap(array, leftPointer, rightPointer);
				leftPointer++;
				rightPointer--;
			}
		}

		// Recursion
		if (left < rightPointer)
			recQuickSort(array, left, rightPointer);
		if (leftPointer < right)
			recQuickSort(array, leftPointer, right);
	}

	// private helper method to swap two values in an array
	private static void swap(int[] arr, int dex1, int dex2) {
		int temp = arr[dex1];
		arr[dex1] = arr[dex2];
		arr[dex2] = temp;
	}

	/**********************************************************
	 * Check if array is sorted. A simple debugging tool
	 **********************************************************/
	private static boolean isSorted(int[] array) {
		return isSorted(array, 0, array.length - 1);
	}

	private static boolean isSorted(int[] array, int lo, int hi) {
		for (int i = lo + 1; i <= hi; i++)
			if (array[i] < array[i - 1])
				return false;
		return true;
	}

}