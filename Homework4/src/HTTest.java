/***************************************************************
 * 
 * 95-772 Data Structures for Application Programmers
 * This is only to help you perform a few simple test cases.
 * 
 * THERE IS A LOT MORE TO THINK ABOUT!
 * Please test extensively on your own!
 * 
 ***************************************************************/

import java.io.*;

public class HTTest {

	public static void main(String[] args) throws IOException, Exception {
		int size;
		System.out.print("Enter size of hash table (bigger than 0): ");
		size = getInt();
		MyHashTable theHashTable;
		if (size == 0)
			theHashTable = new MyHashTable();
		else
			theHashTable = new MyHashTable(size);

		theHashTable.insert("increase");
		theHashTable.insert("creeping");
		theHashTable.insert("everything");
		theHashTable.insert("ourselves");
		theHashTable.insert("himself");
		theHashTable.insert("finished");
		theHashTable.insert("seventh");
		theHashTable.insert("learned");
		theHashTable.insert("learned");
		theHashTable.insert("creeping");
		theHashTable.insert("receive");

		System.out.println("");
		System.out.println("Number of collisions: "
				+ theHashTable.numOfCollisions());
		System.out.println("Number of items: " + theHashTable.size());
		System.out.println("");
		theHashTable.display();

		if (theHashTable.contains("finished")) {
			System.out.println("Found: 'finished'");
		} else
			System.out.println("Cannot find: 'finished'");
		System.out.println("");

		System.out.println("Hash value of 'increase': "
				+ theHashTable.hashValue("increase"));
		System.out.println("Hash value of 'creeping': "
				+ theHashTable.hashValue("creeping"));
		System.out.println("Hash value of 'everything': "
				+ theHashTable.hashValue("everything"));
		System.out.println("Hash value of 'ourselves': "
				+ theHashTable.hashValue("ourselves"));
		System.out.println("Hash value of 'himself': "
				+ theHashTable.hashValue("himself"));
		System.out.println("Hash value of 'finished': "
				+ theHashTable.hashValue("finished"));
		System.out.println("Hash value of 'seventh': "
				+ theHashTable.hashValue("seventh"));
		System.out.println("Hash value of 'learned': "
				+ theHashTable.hashValue("learned"));
		System.out.println("Hash value of 'receive': "
				+ theHashTable.hashValue("receive"));

		theHashTable.remove("seventh");
		System.out.println("Number of items: " + theHashTable.size());
		System.out.println("Frequency of 'learned': "
				+ theHashTable.showFrequency("learned"));
		System.out.println("Frequency of 'Learned': "
				+ theHashTable.showFrequency("Learned"));

		System.out.println("");
		theHashTable.display();
	}

	public static String getString() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}

	public static int getInt() throws IOException {
		String s = getString();
		return Integer.parseInt(s);
	}

}

/*
 * Expected result (with the initial size of 0)
 * 
 * Rehashing 6 items, new size is 23
 * 
 * Number of collisions: 3 
 * Number of items: 9
 * 
 * Table: ** ** ** ** ** ** ** ** ** [increase, 1] [creeping, 2] ** ** ** [seventh, 1] [everything, 1] [ourselves, 1] [learned, 2] [himself, 1] [finished, 1] [receive, 1] ** ** 
 * Found: 'finished'
 * 
 * Hash value of 'increase': 9 
 * Hash value of 'creeping': 9 
 * Hash value of 'everything': 15 
 * Hash value of 'ourselves': 16 
 * Hash value of 'himself': 18
 * Hash value of 'finished': 19 
 * Hash value of 'seventh': 14 
 * Hash value of 'learned': 15 
 * Hash value of 'receive': 18 
 * Number of items: 8 
 * Frequency of 'learned': 2 
 * Frequency of 'Learned': 0
 * 
 * Table: ** ** ** ** ** ** ** ** ** [increase, 1] [creeping, 2] ** ** ** #DEL# [everything, 1] [ourselves, 1] [learned, 2] [himself, 1] [finished, 1] [receive, 1] ** **
 */

/*
 * Expected result (with the initial size of 3)
 * 
 * Rehashing 2 items, new size is 7 
 * Rehashing 4 items, new size is 17 
 * Rehashing 9 items, new size is 37
 * 
 * Number of collisions: 1 
 * Number of items: 9
 * 
 * Table: ** ** ** [finished, 1] ** ** [receive, 1] [learned, 2] ** ** [increase, 1] ** [himself, 1] ** ** ** ** [seventh, 1] ** ** ** ** ** ** [ourselves, 1] ** ** ** ** ** [creeping, 2] [everything, 1] ** ** ** ** **
 * Found: 'finished'
 * 
 * Hash value of 'increase': 10 
 * Hash value of 'creeping': 30 
 * Hash value of 'everything': 30 
 * Hash value of 'ourselves': 24 
 * Hash value of 'himself': 12
 * Hash value of 'finished': 3 
 * Hash value of 'seventh': 17 
 * Hash value of 'learned': 7 
 * Hash value of 'receive': 6 
 * Number of items: 8 
 * Frequency of 'learned': 2 
 * Frequency of 'Learned': 0
 * 
 * Table: ** ** ** [finished, 1] ** ** [receive, 1] [learned, 2] ** ** [increase, 1] ** [himself, 1] ** ** ** ** #DEL# ** ** ** ** ** ** [ourselves, 1] ** ** ** ** ** [creeping, 2] [everything, 1] ** ** ** ** **
 */

/*
 * Expected result (with the initial size of 40)
 * 
 * Number of collisions: 1 
 * Number of items: 9
 * 
 * Table: [himself, 1] ** ** [learned, 2] ** ** ** ** ** ** ** ** ** ** ** ** ** [seventh, 1] ** ** ** ** ** ** ** [creeping, 2] [ourselves, 1] ** ** ** ** ** ** ** [increase, 1] [finished, 1] [receive, 1] ** ** [everything, 1] 
 * Found: 'finished'
 * 
 * Hash value of 'increase': 34 
 * Hash value of 'creeping': 25 
 * Hash value of 'everything': 39 
 * Hash value of 'ourselves': 26 
 * Hash value of 'himself': 0
 * Hash value of 'finished': 34 
 * Hash value of 'seventh': 17 
 * Hash value of 'learned': 3 
 * Hash value of 'receive': 35 
 * Number of items: 8 
 * Frequency of 'learned': 2 
 * Frequency of 'Learned': 0
 * 
 * Table: [himself, 1] ** ** [learned, 2] ** ** ** ** ** ** ** ** ** ** ** ** ** #DEL# ** ** ** ** ** ** ** [creeping, 2] [ourselves, 1] ** ** ** ** ** ** ** [increase, 1] [finished, 1] [receive, 1] ** ** [everything, 1]
 */