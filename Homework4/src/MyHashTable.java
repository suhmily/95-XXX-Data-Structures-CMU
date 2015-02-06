
import static java.lang.Math.pow;
import java.math.BigInteger;

//Hash Table
/**
 * *******************************************************
 *
 * 95-772 Data Structures for Application Programmers
 *
 * Homework 4 HashTable Implementation
 *
 * Andrew id: sjaiswal Name:Shubham Jaiswal
 *
 ********************************************************
 */
public class MyHashTable implements MyHTInterface {

    private DataItem[] hashArray;
    private static final int DEFAULT_CAPACITY = 15;
    private int numOfItems;
    private int tableLength;
    private DataItem deletedItem;
    private int noOfCollisions;

    private static class DataItem {
        private String data;
        private int frequency;

        public DataItem(String data) {
            this.data = data;
            frequency = 0;
        }

        private void increaseFrequency() {
            frequency++;
        }

    }

    // TODO implement constructor with no initial capacity
    public MyHashTable() {
        this(DEFAULT_CAPACITY);
    }

    // TODO implement constructor with initial capacity
    public MyHashTable(int initialCapacity) {
        if (initialCapacity > 0) {
            hashArray = new DataItem[initialCapacity];
            tableLength = initialCapacity;
        } else {
            hashArray = new DataItem[DEFAULT_CAPACITY];
            tableLength = DEFAULT_CAPACITY;
        }
        noOfCollisions = 0;
        numOfItems = 0;
        deletedItem = new DataItem("-1");
    }

    /**
     * Inserts a new String value (word). Frequency of each word be stored too.
     *
     * @param value String value to be added.
     */
    @Override
    public void insert(String value) {
        // TODO Auto-generated method stub

        int hashValue = hashFunc(value);
        int actualHashValue=hashValue;
        DataItem e = new DataItem(value);
        int collisionFlag=0;
        //Find an empty space in the hash Array 
        while (hashArray[hashValue] != deletedItem && hashArray[hashValue] != null) {
            //System.out.println(hashArray[hashValue].data);
            if(hashArray[hashValue].data.equals(value)) {
                System.out.println("we have reached");
                hashArray[hashValue].increaseFrequency();
                noOfCollisions++;
                return;
            }
      
            hashValue = hashValue + 1;
            hashValue = hashValue % numOfItems;
            
        }
        if(actualHashValue!=hashValue){
            noOfCollisions++;
        }
        
        hashArray[hashValue] = e;
        hashArray[hashValue].increaseFrequency();
        numOfItems++;
        double laodFactor = numOfItems / hashArray.length;
        if (laodFactor > .75) {
            rehash();
        }
    }

    /**
     * Returns the size, number of items, of the hashTable
     *
     * @return the number of items in the table.
     */
    @Override
    public int size() {
        // TODO Auto-generated method stub
        return numOfItems;
    }

    /**
     * Displays the values of the table If an index is empty, it shows ** If
     * previously existed dataitem is deleted, then it should show #DEL#
     */
    @Override
    public void display() {
        // TODO Auto-generated method stub
        for (int i = 0; i < hashArray.length; i++) {
            if (hashArray[i] == null) {
                System.out.print("** ");
            } else if (hashArray[i] == deletedItem) {
                System.out.print("#DEL# ");
            } else {
                System.out.print("[" + hashArray[i].data + ", " + hashArray[i].frequency + "]");
            }
        }
        System.out.println("");
    }

    /**
     * Returns true if value is contained in the table
     *
     * @param key String key value to be searched
     * @return true if found, false if not found.
     */
    @Override
    public boolean contains(String key) {
        // TODO Auto-generated method stub
        int hashValue = hashFunc(key);
        while (hashArray[hashValue] != null && hashArray[hashValue] != deletedItem) {
            if (hashArray[hashValue].data.equals(key)) {
                return true;
            }
            hashValue = hashValue + 1;
            hashValue = hashValue % numOfItems;
        }
        return false;
    }

    /**
     * Returns the number of collisions in relation to insert and rehash.
     *
     * When rehashing process happens, the number of collisions should be
     * properly updated.
     *
     * The definition of collision is "two different keys map to the same hash
     * value." Be careful with the situation where you could over count. Try to
     * think as if you are using separate chaining! "How would you count the
     * number of collisions?"
     *
     * @return number of collisions
     */
    @Override
    public int numOfCollisions() {
        // TODO Auto-generated method stub
        return noOfCollisions;
    }

    /**
     * Returns the hash value of a String
     *
     * @param value value for which the hash value should be calculated
     * @return int hash value of a String.
     */
    @Override
    public int hashValue(String value) {
        // TODO Auto-generated method stub
        BigInteger hashValue = new BigInteger("0");
        for (int i = 0; i < value.length(); i++) {
            int charValue = value.charAt(i) - 96;
            BigInteger charValueB = new BigInteger(Integer.toString(charValue));
            int pow = (value.length() - i - 1);
            BigInteger base = new BigInteger("27");
            hashValue = hashValue.add((base.pow(pow)).multiply(charValueB));
        }
        //System.out.println("String=" + value);
        //System.out.println("Absolute Value=" + hashValue);
        //System.out.println("Hash Value="+hashValue.mod(new BigInteger(Integer.toString(tableLength))));
        return hashValue.mod(new BigInteger(Integer.toString(tableLength))).intValue();
    }

    /**
     * Returns the frequency of a key String
     *
     * @param key key string value to find its frequency
     * @return frequency value if found. If not found, return 0
     */
    @Override
    public int showFrequency(String key) {
		// TODO Auto-generated method stub

        int hashValue = hashFunc(key);
        while (hashArray[hashValue] != null && hashArray[hashValue] != deletedItem) {
            if (hashArray[hashValue].data.equals(key)) {
                return hashArray[hashValue].frequency;
            }
            hashValue = hashValue + 1;
            hashValue = hashValue % numOfItems;
        }
        return 0;
    }

    /**
     * Removes and returns removed value
     *
     * @param value String value to be removed
     * @return value that is removed
     */
    @Override
    public String remove(String key) {
        // TODO Auto-generated method stub
        int hashValue = hashFunc(key);
        //Find an key in the hash Array 
        while (hashArray[hashValue] != deletedItem && hashArray[hashValue] != null) {

            if (key.equals(hashArray[hashValue].data)) {

                hashArray[hashValue].frequency--;
                if (hashArray[hashValue].frequency == 0) {
                    hashArray[hashValue] = deletedItem;
                }
                return key;
            }

            hashValue = hashValue + 1;
            hashValue = hashValue % numOfItems;
            noOfCollisions++;
        }
        return null;
    }

    /*
     * Instead of using String's hashCode, you are to implement your own here,
     * taking the table length into your account.
     * 
     * In other words, you are to combine the following two steps into one step here. 
     * 1. converting Object into integer value 
     * 2. compress into the table using modular hashing
     * 
     * Helper method to hash a string for English lowercase alphabet and blank,
     * we have 27 total. 
     * 
     * For example, "cats" : 3*27^3 + 1*27^2 + 20*27^1 + 19*27^0 = 60,337
     * 
     * But, to make the hash process faster, Horner's method should be applied
     * as follows; 
     * 
     * var4*n^4 + var3*n^3 + var2*n^2 + var1*n^1 + var0*n^0 
     * can be rewritten as 
     * (((var4*n + var3)*n + var2)*n + var1)*n + var0
     * 
     * Note: You must use 27 for this homework. However, if you have time, I
     * would encourage you to try with other constant values other than 27. And
     * compare the results but it is not required.
     */
    private int hashFunc(String input) {
		// TODO implement this
		/*if(input.length()==1){
         return input.charAt(input.length()-1);
         }
         else{
         return (input.charAt(0)-96)*(input.length()-1) + hashFunc(input.substring(1,input.length()-1)); 
         }*/
        return hashValue(input);
    }

    // doubles array length and rehash items whenever the load factor is reached
    private void rehash() {
		// TODO implement this
        int oldTableLength=tableLength;
        tableLength=tableLength*2-1;
        BigInteger prime = new BigInteger("" + tableLength);
	prime = prime.nextProbablePrime();
	tableLength = prime.intValue();
        
        System.out.println("Rehashing " + numOfItems + " items, new size is "
		+ tableLength);
        
        // resetting no. of items and no. of collisions
	noOfCollisions= 0;
	numOfItems = 0;
        
         
	DataItem[] tempHashArray = hashArray;
	hashArray = new DataItem[tableLength];
        for(int i=0;i<oldTableLength;i++){
            while(tempHashArray[i].frequency!=0){
                tempHashArray[i].frequency--;
                this.insert(tempHashArray[i].data);
            }
        }
        
    }

}
