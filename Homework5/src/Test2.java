/*******************************************************
 * 
 * 95-772 Data Structures for Application Programmers
 * 
 * Homework 5 Document Similarity
 * Acceptance Test (case 2)
 *
 * DO NOT MODIFY THIS CLASS!
 * 
 *******************************************************/

import java.io.*;

public class Test2 {

	public static void main(String[] args) throws IOException {
		Similarity file1 = new Similarity(
				new File("benhur.txt"));
		System.out.println(file1.numberOfLines() + " lines.");
		System.out.println(file1.numOfWords() + " words.");
		System.out.println(file1.numOfWordsNoDups() + " distinct words.");
		System.out.println(file1.euclideanNorm() + " Euclidean norm.\n");
                
		Similarity file2 = new Similarity(new File(
				"lifeofjesus.txt"));
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
 * 24777 lines. 
 * 204407 words. 
 * 12311 distinct words.
 * 23350.40057472248 Euclidean norm.
 * 
 * 13598 lines. 
 * 116847 words. 
 * 9876 distinct words. 
 * 13773.146735586606 Euclidean norm.
 * 
 * 3.07726162E8 dot product. 
 * 0.29488804370733035 distance.
 */
