package CompressString2;
import arraylistdemo.Stopwatch;

/**********************************************************
 * 
 * 95-772 Data Structures for Application Programmers 
 * Lab 1 ArrayList time comparison and String manipulation
  * 
 * andrew id: sjaiswal
 * name: Shubham Jaiswal
 * 
 **********************************************************/

public class CompressString2 {

	public static void main(String[] args) {
		String str = "aabbccaabbccaabbccaabbccbbbaaabbbcccaaabbbcccaaabbbcccaaabbbccaaabbbcccaaabbbbccccaaaaabbbbbccccaaabbbcccaaabbbcccaaabbbcccaaabbbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcaabbccaabbccaabbccaabbccbbbaaabbbcccaaabbbcccaaabbbcccaaabbbccaaabbbcccaaabbbbccccaaaaabbbbbccccaaabbbcccaaabbbcccaaabbbcccaaabbbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcaabbccaabbccaabbccaabbccbbbaaabbbcccaaabbbcccaaabbbcccaaabbbccaaabbbcccaaabbbbccccaaaaabbbbbccccaaabbbcccaaabbbcccaaabbbcccaaabbbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcaabbccaabbccaabbccaabbccbbbaaabbbcccaaabbbcccaaabbbcccaaabbbccaaabbbcccaaabbbbccccaaaaabbbbbccccaaabbbcccaaabbbcccaaabbbcccaaabbbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcaabbccaabbccaabbccaabbccbbbaaabbbcccaaabbbcccaaabbbcccaaabbbccaaabbbcccaaabbbbccccaaaaabbbbbccccaaabbbcccaaabbbcccaaabbbcccaaabbbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcaabbccaabbccaabbccaabbccbbbaaabbbcccaaabbbcccaaabbbcccaaabbbccaaabbbcccaaabbbbccccaaaaabbbbbccccaaabbbcccaaabbbcccaaabbbcccaaabbbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcaabbccaabbccaabbccaabbccbbbaaabbbcccaaabbbcccaaabbbcccaaabbbccaaabbbcccaaabbbbccccaaaaabbbbbccccaaabbbcccaaabbbcccaaabbbcccaaabbbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcaabbccaabbccaabbccaabbccbbbaaabbbcccaaabbbcccaaabbbcccaaabbbccaaabbbcccaaabbbbccccaaaaabbbbbccccaaabbbcccaaabbbcccaaabbbcccaaabbbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcaabbccaabbccaabbccaabbccbbbaaabbbcccaaabbbcccaaabbbcccaaabbbccaaabbbcccaaabbbbccccaaaaabbbbbccccaaabbbcccaaabbbcccaaabbbcccaaabbbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaannncccaaabbbcccaaabbbcccaaabbbcccaaabbbaaabbbccc";
		Stopwatch timer1 = new Stopwatch();
		System.out.println(compress(str));
		System.out.println("running time: " + timer1.elapsedTime()
				+ " millisec");
	}

	/**
	 * method to compress a string
	 * 
	 * @param str
	 *            input string that should have at least two characters
	 * @return Compressed or original string depending on the size of the
	 *         compressed
	 */
	public static String compress(String str) {
		// initialize compressed stringbuffer
		StringBuffer compressed = new StringBuffer();
		char prev = str.charAt(0);
		int count = 1;
		for (int i = 1; i < str.length(); i++) {
			char curr = str.charAt(i);
			if (curr == prev) { // in case curr is equal to prev
                            count++;                   
			} else { // in case of curr is not equal to prev
                            compressed = compressed.append(prev).append(Integer.toString(count));
                            prev = str.charAt(i);
                            count=1;
			}
		}
                compressed = compressed.append(prev).append(Integer.toString(count));
                // check length and return accordingly
		// return compressed StringBuffer as a string
		if (compressed.length() > str.length())
                    
			return str;
		else
			return compressed.toString();
	}

}