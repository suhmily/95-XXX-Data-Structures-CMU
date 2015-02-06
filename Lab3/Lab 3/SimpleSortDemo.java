/***********************************************************
 * 
 * 95-772 Data Structures for Application Programmers
 * Lab 3 Simple Sorting Performance Comparison
 * 
 * O(n^2) : Bubble Sort, Selection Sort, and Insertion Sort 
 * 
 ***********************************************************/
import java.util.*;

public class SimpleSortDemo {
	private static final int SIZE = 10000;
	private static Random rand = new Random();

	public static void main(String[] args) {
		// create three int arrays
		int[] a = new int[SIZE];
		int[] b = new int[SIZE];
		int[] c = new int[SIZE];

		// Case 1: put random numbers into array a
		for (int i = 0; i < SIZE; i++) a[i] = rand.nextInt();	
		
		// Case 2: put reversely ordered values into array a
		//for(int i = 0; i<SIZE; i++) a[i] = SIZE-i;

		// Case 3: put ordered values into array a
		//for(int i = 0; i<SIZE; i++) a[i] = i; 

		// copy all of the values from a to b and c arrays
		System.arraycopy(a, 0, b, 0, a.length);
		System.arraycopy(a, 0, c, 0, a.length);

		// check the running time for bubble sort
		Stopwatch timer1 = new Stopwatch();
		bubbleSort(a);
		System.out.println("Time for bubble sort: " + timer1.elapsedTime()
				+ " millisec");

		// check the running time for selection sort
		Stopwatch timer2 = new Stopwatch();
		selectionSort(b);
		System.out.println("Time for selection sort: " + timer2.elapsedTime()
				+ " millisec");

		// check the running time for insertion sort
		Stopwatch timer3 = new Stopwatch();
		insertionSort(c);
		System.out.println("Time for insertion sort: " + timer3.elapsedTime()
				+ " millisec");

	}
	
	/*
	 * O(n^2) simple but slow
	 * focus on the largest value
	 */
	public static void bubbleSort(int[] data) {
		// move backward from the last index to 1
		for (int out = data.length - 1; out >= 1; out--) {
			// move forward from 0 to the right
			// BUBBLE up the largest value to the right
			for (int in = 0; in < data.length-1; in++) {
				if (data[in] > data[in + 1])
					swap(data, in, in + 1);
			}
		}
	}

	/*
	 * O(n^2) faster than bubble sort because swap only happens in the outer loop
	 * focus on the smallest value
	 */
	public static void selectionSort(int[] data) {
		int min; // set min variable for tmp min value
		// move forward to right to SELECT the minimum value
		for (int out = 0; out < data.length - 1; out++) {
			min = out; // set initial min index to be out
			// move forward to right from out+1 to the end
			for (int in = out + 1; in < data.length; in++) {
				// if data is smaller than current min value
				if (data[in] < data[min]) 
					min = in; // set a new min index
			}
			// swap min value with the first one as we move forward to the right
			// swapping is happening in the outer loop!!
			if(out != min)
				swap(data, out, min);
		}
	}

	/*
	 * O(n^2) fastest among the three but sensitive to the input values
	 * 1. less number of comparisons on average
	 * 2. uses shifting instead of swapping
	 */
	public static void insertionSort(int[] data) {
		// start from 1 till the last index
		for (int out = 1; out < data.length; out++) {
			int tmp = data[out]; // save the first value as tmp
			int in = out; // initial in variable index
			// move backward till it finds the location to insert
			// not necessarily go back all the way to the 0th index
			while (in > 0 && data[in - 1] >= tmp) {
				// shift to right to make a room
				data[in] = data[in - 1];
				in--;
			}
			// finally INSERT the tmp value to the right position
			data[in] = tmp;
		}
	}

	// swap helper method
	private static void swap(int[] array, int one, int two) {
		int tmp = array[one];
		array[one] = array[two];
		array[two] = tmp;
	}

}