/**************************************************************
 * 
 * 95-772 Data Structures for Application Programmers
 * 
 * Lab 7 Heaps and Java PriorityQueue class
 * 
 * Find median of integers using Heaps (maxHeap and minHeap)
 * 
 * Andrew ID: 
 * Name:
 * 
 **************************************************************/

import java.util.*;

public class FindMedian {
	private static PriorityQueue<Integer> maxHeap, minHeap;

	public static void main(String[] args) {

		Comparator<Integer> revCmp = new Comparator<Integer>() {
			@Override
			public int compare(Integer left, Integer right) {
				return right.compareTo(left);
			}
		};

		// Or you can use Collections' reverseOrder method as follows.
		// Comparator<Integer> revCmp = Collections.reverseOrder();

		maxHeap = new PriorityQueue<Integer>(20, revCmp);
		minHeap = new PriorityQueue<Integer>(20);

		addNumber(6);
		addNumber(4);
		addNumber(3);
		addNumber(10);
		addNumber(12);
		System.out.println(minHeap);
		System.out.println(maxHeap);
		System.out.println(getMedian());

		addNumber(5);
		System.out.println(minHeap);
		System.out.println(maxHeap);
		System.out.println(getMedian());

		addNumber(7);
		addNumber(8);
		System.out.println(minHeap);
		System.out.println(maxHeap);
		System.out.println(getMedian());
	}

	/*
	 * Note: it maintains a condition that maxHeap.size() >= minHeap.size()
	 */
	public static void addNumber(int value) {
		if(maxHeap.size()==minHeap.size())
                {
                    if(minHeap.peek()!=null && value > minHeap.peek())
                    {
                        maxHeap.offer(minHeap.remove());
                        minHeap.offer(value);
                    }
                    else
                    {
                        maxHeap.offer(value);
                    }
                }
                else
                {
                    if(value<maxHeap.peek())
                    {
                        minHeap.offer(maxHeap.remove());
                        maxHeap.offer(value);
                    }
                    else
                        minHeap.offer(value);
                }
	}

	/*
	 * If maxHeap and minHeap are of different sizes, 
	 * then maxHeap must have one extra element.
	 */
	public static double getMedian() {
		if(maxHeap.isEmpty())
                {
                    return -1;
                }
                if(maxHeap.size()==minHeap.size())
                {
                    return (double)(minHeap.peek() + maxHeap.peek())/2;
                }
                else
                    return maxHeap.peek();
	}
}