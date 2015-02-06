/*****************************************************
 * 
 * 95-772 Data Structures for Application Programmers 
 * Lab 2 LinkedList Operation Implementation
 * 
 * Singly Linked List 
 * 
 *****************************************************/

public class MainDriver {

	public static void main(String[] args) {
		LinkedListLab<String> theList = new LinkedListLab<String>();
		theList.insert("data");
		theList.insert("strutures");
		theList.insert("rock");
		theList.insert("the");
		theList.insert("world");
		theList.insert("way");
		theList.insert("to");
		theList.insert("go");
		theList.insert("dude");

		System.out.println(theList);

		// should print null
    		System.out.println(theList.kthToLast(-1));

		// should print null
		System.out.println(theList.kthToLast(0));

		// should print "dude"
		System.out.println(theList.kthToLast(1));

		// should print "go"
		System.out.println(theList.kthToLast(2));

		// should print "to"
		System.out.println(theList.kthToLast(3));

		// should print data
		System.out.println(theList.kthToLast(9));

		// should print null
		System.out.println(theList.kthToLast(10));
	}

}