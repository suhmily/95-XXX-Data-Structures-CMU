
/**
 * ***************************************************
 *
 * 95-772 Data Structures for Application Programmers Lab 2 LinkedList Operation
 * Implementation
 *
 * Singly Linked List
 *
 * andrew id:sjaiswal 
 * name:Shubham Jaiswal
 *
 ****************************************************
 */

import java.util.*;

public class LinkedListLab<AnyType> implements Iterable<AnyType> {

    private Node<AnyType> head;

    public LinkedListLab() {
        head = null;
    }

    public void insert(AnyType dataItem) {
        if (head == null) {
            head = new Node<AnyType>(dataItem, head);
        } else {
            Node<AnyType> tmp = head;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = new Node<AnyType>(dataItem, null);
        }
    }

    /**
     * Find object that is kth to the last node of linkedlist
     *
     * @param k kth position from the last. 1 means the last node
     * @return Object that is located at kth from the last
     */
    public AnyType kthToLast(int k) {
        // TODO implement this method		
        int count = 0;
        Node<AnyType> tmp = head;
        while (tmp != null) {
            tmp = tmp.next;
            count++;
        }
        tmp = head;
        if (k > 0 && k <= count) {
            for (int i = 0; i < count - k; i++) {
                tmp = tmp.next;
            }
            return tmp.data;
        } else {
            return null;
        }
    }

    /**
     * Returns a string representation
     *
     * @return 
     */
    @Override
    public String toString() {
        StringBuffer result = new StringBuffer();
        for (Object x : this) {
            result.append(x + " ");
        }

        return result.toString();
    }

    /**
     * *****************************************************
     *
     * The Iterator class
     *
     * @return 
	 *******************************************************
     */
    @Override
    public Iterator<AnyType> iterator() {
        return new LinkedListLabIterator();
    }

    private class LinkedListLabIterator implements Iterator<AnyType> {

        private Node<AnyType> nextNode;

        public LinkedListLabIterator() {
            nextNode = head;
        }

        @Override
        public boolean hasNext() {
            return nextNode != null;
        }

        @Override
        public AnyType next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            AnyType result = nextNode.data;
            nextNode = nextNode.next;
            return result;
        }

        // not supporting remove()
        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /**
     * ****************************************************
     *
     * Node (static nested class)
     *
     *****************************************************
     */
    private static class Node<AnyType> {

        private AnyType data;
        private Node<AnyType> next;

        public Node(AnyType data, Node<AnyType> next) {
            this.data = data;
            this.next = next;
        }
    }

}
