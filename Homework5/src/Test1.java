/*******************************************************
 * 
 * 95-772 Data Structures for Application Programmers 
 * 
 * Homework 5 Document Similarity
 * Acceptance Test (case 1)
 * 
 * No need to worry about number of lines for this case. 
 * 
 * DO NOT MODIFY THIS CLASS!
 * 
 *******************************************************/

public class Test1 {

	public static void main(String[] args) {
		Similarity text1 = new Similarity(
				"hello there nice to meet you you look nice");
		System.out.println(text1.numOfWords() + " words.");
		System.out.println(text1.numOfWordsNoDups() + " distinct words");
	
                System.out.println(text1.euclideanNorm() + " Euclidean norm.\n");
                
		Similarity text2 = new Similarity(
				"time to say hello nice seeing you should meet again");
		System.out.println(text2.numOfWords() + " words.");
		System.out.println(text2.numOfWordsNoDups() + " distinct words.");
		System.out.println(text2.euclideanNorm() + " Euclidean norm.\n");

		System.out.println(text1.dotProduct(text2.getMap()) + " dot product.");
		System.out.println(text1.distance(text2.getMap()) + " distance.");
	}

}

/*
 * EXPECTED OUTPUT 
 * 9 words. 
 * 7 distinct words 
 * 3.605551275463989 Euclidean norm.
 * 
 * 10 words. 
 * 10 distinct words. 
 * 3.1622776601683795 Euclidean norm.
 * 
 * 7.0 dot product. 
 * 0.9097531579442097 distance.
 */
