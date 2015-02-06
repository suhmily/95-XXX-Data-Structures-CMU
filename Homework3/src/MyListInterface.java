/************************************************************
 * 
 * 95-772 Data Structures for Applications Programmers 
 * 
 * Homework 3 SortedLinkedList Implementation with Recursion 
 * 
 * Basic List interface
 * Do not change this interface
 * 
 ************************************************************/
public interface MyListInterface {

	/**
	 * Inserts a new String. No duplicates allowed and maintain the order
	 * 
	 * @param value
	 *            String to be added.
	 */
	void add(String value);

	/**
	 * Checks the size of the list
	 * 
	 * @return the size of the list
	 */
	int size();

	/**
	 * Displays the values of the list
	 */
	void display();

	/**
	 * Returns true if the key value is contained in the list
	 * 
	 * @param String
	 *            to be searched
	 * @return true if found, false if not found
	 */
	boolean contains(String key);

	/**
	 * Returns true is the list is empty
	 * 
	 * @return true if it is empty, false if it is not empty
	 */
	boolean isEmpty();

	/**
	 * Removes and returns the first node's String object of the list.
	 * 
	 * @return String object that is removed
	 */
	String removeFirst();

	/**
	 * Removes and returns String object at the index
	 * 
	 * @param index
	 *            index value to be removed
	 * @return String object that is removed
	 */
	String removeAt(int index);

}