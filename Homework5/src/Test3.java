/*******************************************************
 * 
 * 95-772 Data Structures for Application Programmers
 * 
 * Homework 5 Document Similarity
 * Acceptance Test (case 3)
 *
 * DO NOT MODIFY THIS CLASS!
 * 
 *******************************************************/

import java.io.*;

public class Test3 {

	public static void main(String[] args) throws IOException {
		Similarity file1 = new Similarity(new File("childrensbible.txt"));
		System.out.println(file1.numberOfLines() + " lines.");
		System.out.println(file1.numOfWords() + " words.");
		System.out.println(file1.numOfWordsNoDups() + " distinct words.");
		System.out.println(file1.euclideanNorm() + " Euclidean norm.\n");

		Similarity file2 = new Similarity(new File("kjv.txt"));
		System.out.println(file2.numberOfLines() + " lines.");
		System.out.println(file2.numOfWords() + " words.");
		System.out.println(file2.numOfWordsNoDups() + " distinct words.");
		System.out.println(file2.euclideanNorm() + " Euclidean norm.\n");

		System.out.println(file1.dotProduct(file2.getMap()) + " dot product.");
		System.out.println(file1.distance(file2.getMap()) + " distance.");

	}

}

/*
 * EXPECTED OUTPUT 
 * 1343 lines. 
 * 9398 words. 
 * 1425 distinct words.
 * 1126.465267995423 Euclidean norm.
 * 
 * 100222 lines. 
 * 794914 words. 
 * 12892 distinct words. 
 * 100816.66166859523 Euclidean norm.
 * 
 * 1.0691544E8 dot product. 
 * 0.3439354904679285 distance.
 */