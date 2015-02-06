
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
 */
public class Similarity1 {
    private int numOfWords=0;
    private int numOfWordsNoDups=0;
    HashMap x = new HashMap();
    double euclidean;
    int numOfLines=0;
    
    Similarity(String text) {    
        String[] words = text.split(" ");
        for (String word : words) {
            String temp = word.toLowerCase();
            if (!x.containsKey(temp)) {
                x.put(temp, new DataItem(temp));
                numOfWordsNoDups++;
            }
            DataItem a = (DataItem) x.get(temp);
            a.increaseFrequency();
            numOfWords++;
            System.out.println("hua");

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
                    if(!temp.equals("")){
                    if (!x.containsKey(temp)) {
                        x.put(temp, new DataItem(temp));
                        
                    }
                    DataItem a = (DataItem) x.get(temp);
                    a.increaseFrequency();
                    }
                }
            }
        }
        calculate();
    }

    void calculate(){
        // Get a set of the entries
        Set set = x.entrySet();
        // Get an iterator
        Iterator i = set.iterator();
        int numOfWords=0,numOfWordsNoDups=0;
        double euclidean=0;
        // Display element
        while (i.hasNext()) {
            Map.Entry me = (Map.Entry) i.next();
            System.out.print(me.getKey() + ": ");
            DataItem a = (DataItem) me.getValue();
            System.out.print(" Value: " + a.getData());
            numOfWordsNoDups=numOfWordsNoDups+1;
            System.out.println(" Freq: " + a.getFrequency());
            numOfWords=numOfWords+ a.getFrequency();
            euclidean=euclidean+(a.getFrequency()*a.getFrequency());
        }
        euclidean=Math.sqrt(euclidean);
        this.euclidean=euclidean;
        System.out.println("HashMap: ");
        this.numOfWords=numOfWords;
        this.numOfWordsNoDups=numOfWordsNoDups;
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

    Similarity getMap() {
        return null;
    }

    String dotProduct(Similarity b) {
        return null;
    }

    String distance(Similarity map) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static class DataItem {

        private String data;
        private int frequency;

        public DataItem(String data) {
            this.data = data;
            frequency = 0;
        }

        private String getData() {
            return data;
        }

        private int getFrequency() {
            return frequency;
        }

        private void increaseFrequency() {
            frequency++;
        }

    }
}











//http://www.tutorialspoint.com/java/java_hashmap_class.htm -Reference