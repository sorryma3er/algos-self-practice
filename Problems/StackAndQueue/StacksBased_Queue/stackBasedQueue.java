package StackAndQueue.StacksBased_Queue;

import java.util.*;

public class stackBasedQueue {
    public static void main(String[] args) {
        // ---------------------- Test Case 1 ----------------------
        // Basic enqueue/dequeue order
        MyQueue q1 = new MyQueue();
        q1.push(1);
        q1.push(2);
        q1.push(3);

        System.out.println("Test 1:");
        System.out.println("  peek   = " + q1.peek() + " (expect 1)");
        System.out.println("  pop    = " + q1.pop()  + " (expect 1)");
        System.out.println("  pop    = " + q1.pop()  + " (expect 2)");
        System.out.println("  peek   = " + q1.peek() + " (expect 3)");
        System.out.println("  empty? = " + q1.empty() + " (expect false)");
        System.out.println("-----------------------------------");

        // ---------------------- Test Case 2 ----------------------
        // Interleave operations: push after pop
        MyQueue q2 = new MyQueue();
        q2.push(10);
        q2.push(20);
        System.out.println("Test 2:");
        System.out.println("  pop    = " + q2.pop()  + " (expect 10)");
        q2.push(30);
        System.out.println("  peek   = " + q2.peek() + " (expect 20)");
        System.out.println("  pop    = " + q2.pop()  + " (expect 20)");
        System.out.println("  pop    = " + q2.pop()  + " (expect 30)");
        System.out.println("  empty? = " + q2.empty() + " (expect true)");
        System.out.println("-----------------------------------");

        // ---------------------- Test Case 3 ----------------------
        // Single element behavior
        MyQueue q3 = new MyQueue();
        q3.push(99);
        System.out.println("Test 3:");
        System.out.println("  peek   = " + q3.peek() + " (expect 99)");
        System.out.println("  pop    = " + q3.pop()  + " (expect 99)");
        System.out.println("  empty? = " + q3.empty() + " (expect true)");
        System.out.println("-----------------------------------");
    }
}

class MyQueue {

    Deque<Integer> inStack, outStack;

    public MyQueue() {
        inStack = new ArrayDeque<>();
        outStack = new ArrayDeque<>();
    }
    
    public void push(int x) {
        if (!outStack.isEmpty()){
            Deque<Integer> temp = new ArrayDeque<>();
            while (!outStack.isEmpty()) temp.push(outStack.pop());
            inStack = temp;
        }
        inStack.push(x);
    }
    
    public int pop() {
        while (!inStack.isEmpty()) outStack.push(inStack.pop());
        
        return outStack.pop();
    }
    
    public int peek() {
        while (!inStack.isEmpty()) outStack.push(inStack.pop());
        
        return outStack.peek();
    }
    
    public boolean empty() {
        while (!inStack.isEmpty()) outStack.push(inStack.pop());
        
        return outStack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
