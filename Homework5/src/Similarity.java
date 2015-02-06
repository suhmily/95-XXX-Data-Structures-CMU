
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Shubham
 * @CMUID sjaiswal
 */
public class Similarity {

    private int numOfWords = 0;
    private int numOfWordsNoDups = 0;
    HashMap x = new HashMap();
    double euclidean;
    int numOfLines = 0;
    double dotProduct = 0;

    Similarity(String text) {
        String[] words = text.split(" ");
        for (String word : words) {
            String temp = word.toLowerCase();
            int a = 1;
            //Create akey value pair if word not present in hash map
            if (!x.containsKey(temp)) {
                x.put(temp, a);
                numOfWordsNoDups++;
                numOfWords++;
            } //Increase counter if word is present aready
            else {
                a = (int) x.get(temp);
                x.put(temp, ++a);
                numOfWords++;
            }
        }
        calculate();
        /*
         // Get a set of the entries
         Set set = x.entrySet();
         // Get an iterator
         Iterator i = set.iterator();
         // Display elements
         while (i.hasNext()) {
         Map.Entry me = (Map.Entry) i.next();
         System.out.print(me.getKey() + ": ");
         DataItem a = (DataItem) me.getValue();
         System.out.print(" Value: " + a.getData());
         System.out.println(" Freq: " + a.getFrequency());
         }
         System.out.println("HashMap: ");*/
    }

    Similarity(File f) throws IOException {
        try (Scanner scanner = new Scanner(f, "latin1")) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                numOfLines++;
                String[] words = line.split("\\W");
                for (String word : words) {
                    String temp = word.toLowerCase().trim();
                    if (!temp.equals("") && temp.matches("[a-zA-Z]+")) {
                        int a = 1;
                        //Create akey value pair if word not present in hash map 
                        if (!x.containsKey(temp)) {
                            x.put(temp, a);
                            numOfWordsNoDups++;
                            numOfWords++;
                        } //Increase counter if word is present aready
                        else {
                            a = (int) x.get(temp);
                            x.put(temp, ++a);
                            numOfWords++;
                        }
                    }
                }
            }
        }
        calculate();
    }

    void calculate() {
        // Get a set of the entries
        Set set = x.entrySet();
        // Get an iterator
        Iterator i = set.iterator();
        double euclidean = 0;
        // Display element and calculate dot product
        while (i.hasNext()) {
            Map.Entry me = (Map.Entry) i.next();
            //System.out.print(me.getKey() + ": ");
            int a = (int) me.getValue();
            //System.out.println( a);
            euclidean = euclidean + (a * a);
        }
        euclidean = Math.sqrt(euclidean);
        this.euclidean = euclidean;
        System.out.println("HashMap: ");

    }

    double euciledianCalculate(HashMap a) {
        // Get a set of the entries
        Set set = a.entrySet();
        // Get an iterator
        Iterator i = set.iterator();
        double euclidean = 0;
        // Display element
        while (i.hasNext()) {
            Map.Entry me = (Map.Entry) i.next();
            //System.out.print(me.getKey() + ": ");
            int s = (int) me.getValue();
            //System.out.println( s);
            euclidean = euclidean + (s * s);
        }
        euclidean = Math.sqrt(euclidean);
        return euclidean;
    }

    int numOfWords() {
        return numOfWords;
    }

    int numOfWordsNoDups() {
        return numOfWordsNoDups;
    }

    double euclideanNorm() {
        return euclidean;
    }

    int numberOfLines() {
        return numOfLines;
    }

    HashMap getMap() {
        return x;
    }

    double dotProduct(HashMap b) {
        // Get a set of the entries
        Set set = x.entrySet();
        // Get an iterator to iterate through hash map
        Iterator i = set.iterator();
        double dotProduct = 0;
        // Find the word require and calculate dot product

        while (i.hasNext()) {
            Map.Entry me = (Map.Entry) i.next();
            if ((b.containsKey(me.getKey()))) {
                int freq1 = (int) me.getValue();
                int freq2 = (int) b.get(me.getKey());
                //System.out.println("freq1"+freq1);    
                //System.out.println("freq1"+freq2);
                dotProduct = dotProduct + freq1 * freq2;
                //System.out.println("Dot"+dotProduct);
                //System.out.print(" Value: " + a);
            }

        }
        return dotProduct;
    }

    Double distance(HashMap b) {
        Double distance;
        //System.out.println(this.dotProduct(b));
        //        System.out.println(this.euclidean);
        //               System.out.println(euciledianCalculate(b));
        distance = Math.acos((this.dotProduct(b)) / (this.euclidean * euciledianCalculate(b)));

        return distance;

    }

}











//http://www.tutorialspoint.com/java/java_hashmap_class.htm -Reference
