package MainDriver;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * ********************************************************
 *
 * 95-772 Data Structures for Application Programmers
 *
 * Homework 2 Solve Josephus problem with different data structures and compare
 * running time
 *
 * Andrew id: Name:
 *
 *********************************************************
 */
public class Josephus {

    /**
     * This method uses ArrayDeque data structure as Queue/Deque to find the
     * survivor's position.
     *
     * @param size Number of people in the circle that is bigger than 0.
     * @param rotation Elimination order in the circle. The value has to be
     * greater than 0.
     * @return The position value of the survivor.
     */
    public int playWithAD(int size, int rotation) {
        if (size > 1 && rotation>0) {
            ArrayDeque<Integer> a = new ArrayDeque<>();
            for (int i = 0; i < size; i++) {
                a.add(i + 1);
            }
            int rot;
            //Set no of rotations
            while (a.size() > 1) {
                if(rotation%a.size()==0){
                rot = a.size();
                }
                else{
                   rot=rotation%a.size();
                }
                //System.out.println("Move No of times=" + rotation + "%" + a.size() + "=" + rot);
                //Move elements in the Queue and remove the nth element from fro
                for (int i = 1; i < rot; i++) {
                    //System.out.println(Arrays.toString(a.toArray()));
                    a.add(a.remove());
                }
                a.remove();
            }
            return a.remove();
        } else if (size == 1 && rotation > 0) {
            return size;
        } else {
            throw new UnsupportedOperationException();
        }
        // TODO implement this
    }

    /**
     * This method uses LinkedList data structure as Queue/Deque to find the
     * survivor's position.
     *
     * @param size Number of people in the circle that is bigger than 0.
     * @param rotation Elimination order in the circle. The value has to be
     * greater than 0.
     * @return The position value of the survivor.
     */
    public int playWithLL(int size, int rotation) {
        if (size > 1 && rotation > 0) {
            LinkedList<Integer> a = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                a.addLast(i + 1);
            }
            int rot;
            //
            while (a.size() > 1) {
                if(rotation%a.size()==0){
                    rot = a.size();
                }
                else{
                    rot = rotation % (a.size());
                }
                for (int i = 1; i < rot; i++) {
                    a.addLast(a.removeFirst());
                }
                a.removeFirst();
            }
            return a.removeFirst();
        } else if (size == 1 && rotation > 0) {
            return size;
        } else {
            throw new UnsupportedOperationException();
        }
        // TODO implement this
    }

    /**
     * This method uses LinkedList data structure to find the survivor's
     * position. However, this does not use the LinkedList as Queue/Deque.
     * Instead, this method uses LinkedList as "Linked List."
     *
     * That means, it uses index value to find and remove a person to be
     * executed in the circle.
     *
     * @param size Number of people in the circle that is bigger than 0.
     * @param rotation Elimination order in the circle. The value has to be
     * greater than 0.
     * @return The position value of the survivor.
     */
    public int playWithLLAt(int size, int rotation) {
        //Check whether size and rotation are valid else return exception
        if (size > 1 && rotation > 0) {
            LinkedList<Integer> a = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                a.addLast(i + 1);
            }
            
            //Iterator to iterate through th linked list
            Iterator<Integer> x = a.listIterator();
            while (a.size() != 1) {
                //Iterate through list removing every nth(rotation) element in the list
                for(int i=0;i<rotation;i++){
                    //Point to starting point when Iterator reaches the end of list
                    if(!x.hasNext()){
                        x=a.iterator();
                    }
                    x.next();
                }
                x.remove();
            }
            //Return the last element left in linked list
            return a.remove();
        } else if (size == 1 && rotation > 0) {     
            return size;                                                    //If we have only one element in size     
        } else {                                    
            throw new UnsupportedOperationException();                      //Throw exception if wrong input
        }
        // TODO implement this
    }

}












/*
                System.out.println(Arrays.toString(a.toArray()));
                System.out.println("Current Size=" + a.size());
                System.out.println("Rotation==" + rotation);
                current = ((current) + rotation-index) % (a.size()+1);
                a.remove(current);*/
//Reference-http://www.tutorialspoint.com/java/util/linkedlist_listiterator.htm  
//http://crunchify.com/how-to-iterate-through-linkedlist-instance-in-java/