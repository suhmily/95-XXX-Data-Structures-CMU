/*********************************************************
 * 
 * 95-772 Data Structures for Application Programmers
 * Lab 3 Simple Sorting and Stability 
 * 
 * Comparison of Selection sort and Insertion sort 
 * Employee class
 * 
 *********************************************************/

public class Employee {
	private String firstName;
	private String lastName;
	private int zipCode;

	public Employee(String firstName, String lastName, int zipCode) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.zipCode = zipCode;
	}

	public String getLastName() {
		return lastName;
	}

	public int getZipCode() {
		return zipCode;
	}

	public String toString() {
		return lastName + ", " + firstName + ", " + zipCode;
	}
}