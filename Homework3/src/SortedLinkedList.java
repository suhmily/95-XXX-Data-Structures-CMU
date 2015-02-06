
import static java.util.concurrent.ThreadLocalRandom.current;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * @andrewId: sjaiswal
 * @author Shubham Jaiswal
 */
class SortedLinkedList implements MyListInterface {

    private Node<String> head;

    public SortedLinkedList() {
    }

    public SortedLinkedList(String[] unsorted) {
        if (unsorted.length > 0) {
            //Adds one woed at a time from a String array
            for (String word : unsorted) {
                if (word != null) {
                    add(word);
                }
            }
        }
    }

    @Override
    public void add(String value) {
        Node<String> current = head;
        //Checks if Linked List is empty
        if (current != null) {
            Node<String> addAfter = current;
            //If value is smaller than head 
            if (value.compareTo(current.data) < 0) {
                head = new Node<>(value, current);
            } else {
                //Call recursive function to find location where we nned to add
                if (current.next != null) {
                    addAfter = insertAfter(value, current, current.next);
                }
                if (addAfter.data.compareTo(value) == 0) {

                } else {
                    Node<String> storeNext = addAfter.next;
                    addAfter.next = new Node<>(value, storeNext);
                }
            }
        } else {
            head = new Node<>(value, null);
        }
    }

    private Node<String> insertAfter(String value, Node<String> current, Node<String> ahead) {
        if (ahead == null) {
            return current;
        } else if (value.compareTo(ahead.data) >= 0) {
            return insertAfter(value, current.next, ahead.next);
        } else {
            return current;
        }
    }

    @Override
    public int size() {
        int count = 0;
        if (head != null) {
            count = sizeRecursive(head, count);
        }
        return count;
    }

    //Find size of Linked List using recursin
    private int sizeRecursive(Node<String> current, int count) {
        if (current == null) {
            return count;
        }
        return sizeRecursive(current.next, count + 1);
    }

    @Override
    public void display() {
        Node<String> current = head;
        displayRecursive(current);
        System.out.println();

    }

    //Display words of Linked list
    private void displayRecursive(Node<String> current) {
        if (current != null) {
            System.out.print(current.data + " ");
            displayRecursive(current.next);
        }

    }

    @Override
    public boolean contains(String key) {
        Node<String> current = head;
        Boolean bool;
        bool = containsRecursive(current, key);
        return bool;
    }

    //Find the position of string in the Linked List
    private boolean containsRecursive(Node<String> current, String key) {
        if (current == null) {
            return false;
        } else if (current.data.compareTo(key) == 0) {
            return true;
        } else {
            return containsRecursive(current.next, key);
        }
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public String removeFirst() {
        Node<String> current = head;
        if (current == null) {
            return null;
        } else {
            head = current.next;
            return null;
        }
    }

    @Override
    public String removeAt(int index) {
        Node<String> current = head;
        if (index == 0) {
            removeFirst();
        } else if (index > 0) {
            removeAtRecursive(current, index);
            return null;
        }
        return null;
    }

    //Remove string after reaching the index 
    private void removeAtRecursive(Node<String> current, int index) {
        if (index == 1) {
            current.next = current.next.next;
        } else {
            removeAtRecursive(current.next, --index);
        }
    }

    // static nested class for Node
    private static class Node<String> {

        private String data;
        private Node<String> next;

        public Node(String data, Node<String> next) {
            this.data = data;
            this.next = next;
        }
    }
}
