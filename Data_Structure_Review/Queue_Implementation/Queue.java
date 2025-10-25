package Queue_Implementation;

import java.util.ArrayDeque;
import java.util.Deque;

public class Queue {
    public static void main(String[] args){

        // Init
        Deque<Integer> que = new ArrayDeque<>();

        // Push elt into the queue; append at the tail;
        que.addLast(1);
        que.addLast(3);
        que.addLast(2);
        que.addLast(5);
        que.addLast(4);

        // Accessing the first elt in the queue; 
        int head = que.peekFirst(); // safe peek; return null when empty; 
        head = que.getFirst(); // use when expect non-empty; and wants an error when empty --- Throws NoSuchElementException

        // first elt in the queue goes out from queue --- pop operation
        int pop = que.removeFirst(); // use when expect non-empty; and wants an error when empty --- Throws NoSuchElementException
        pop = que.pollFirst(); // safe pop; return null when empty; 

        // Get the size of the queue
        int size = que.size();

        // Emptyness check
        Boolean isEmpty = que.isEmpty();

        System.out.println("head = " + head);
        System.out.println("pop  = " + pop);
        System.out.println("size = " + size);
        System.out.println("isEmpty = " + isEmpty);
        System.out.println("queue = " + que); // prints remaining elements in order
    }
}
