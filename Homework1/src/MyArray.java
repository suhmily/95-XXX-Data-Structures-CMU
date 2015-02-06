
import static java.lang.Boolean.TRUE;

/**
 * ***************************************************
 *
 * 95-772 Data Structures for Application Programmers Homework 1 My Array
 * implementation
 *
 *
 * @andrewID:sjaiswal
 * @author Shubham Jaiswal
 *
 *
 ****************************************************
 */
public class MyArray {

    private String[] data;
    private static int count = 0;

    //Default Constructor
    MyArray() {
        data = new String[10];
    }

    //Parameterized Constructor
    MyArray(int i) {
        data = new String[i];
    }

    //Add word to the string
    //TIME COMPLEXITY O(n)
    void add(String word) {
        if (word.matches(("[a-z]+"))) {
            if (data.length == count) {
                String[] newdata = new String[(data.length * 2) + 1];
                //System.out.println("New Size: " + newdata.length);
                for (int i = 0; i < count; i++) {
                    newdata[i] = data[i];
                }
                data = newdata;
                //System.out.println("New Size: "+data.length);
            }
            //System.out.print(count+word+" ");
            data[count++] = word;
        }
    }

    //Search for a word in the string
    //TIME COMPLEXITY O(n)
    boolean search(String key) {
        for (int i = 0; i < count; i++) {
            //System.out.println(i+" "+data[0]);
            if (data[i].equals(key)) {
                return true;
            }
        }
        return false;
    }

    //Current number of words in the string
    //TIME COMPLEXITY O(1)
    int size() {
        return count;
    }

    //Lenght of entire String Array
    //TIME COMPLEXITY O(1)
    int getCapacity() {
        return data.length;
    }

    //Display contet of the string
    //TIME COMPLEXITY O(n)
    void display() {
        for (int i = 0; i < count; i++) {
            System.out.print(data[i] + " ");
        }
    }

    //Remove Duplicates from the string array
    //TIME COMPLEXITY O(n^2)
    void removeDups() {
        int newcount = 0;
        System.out.println(count);
        //Deletes Elements which are repeated 
        for (int i = 0; i < count; i++) {
            for (int j = i + 1; j < count; j++) {
                if (data[j].equals(data[i])) {
                    data[j] = "";
                }
            }
        }
        //Fills the emoty spaces created due to deleteion of repeated elements
        for (int i = 0; i < count; i++) {
            if (!data[i].equals("")) {
                data[newcount] = data[i];
                newcount++;
            }
        }
        count = newcount;
    }

}



//Reference:http://stackoverflow.com/questions/5238491/check-if-string-contains-only-letters
