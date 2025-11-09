package Queue_Implementation;

import java.util.NoSuchElementException;

/*
 * 	•	A static method belongs to the class itself, not any particular object.
	  •	A non-static (instance) method operates on the specific instance’s data (its fields like head, tail, size).
 */

public class LinkedListQueue {

  // private static inner class --- ListNode
  private static class ListNode {
    private int val;
    private ListNode next;

    // constructor
    public ListNode(int val){
        this.val = val;
        this.next = null;
    }
  }

  private ListNode head;
  private ListNode tail;
  private int size;

  // constructor of LinkedListQueue
  public LinkedListQueue(){
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  public int size() {
    return this.size;
  }

  public boolean isEmpty(){
    return this.head == null;
  }

  public void push(int val){
    //create new node with val
    ListNode newNode = new ListNode(val);
    if (isEmpty()){
      head = newNode;
      tail = newNode;
    } else {
      tail.next = newNode;
      tail = newNode;
    }
    size++;
  }

  public int peek(){
    if (isEmpty()){
      throw new NoSuchElementException("Queue is empty");
    }

    return head.val;
  }

  public int pop(){
    int headVal = peek();

    head = head.next;
    size--;
    return headVal;
  }


  @Override
  public String toString(){
    StringBuilder sb = new StringBuilder("[");
    ListNode curr = head;
    while (curr != null){
      sb.append(curr.val);
      if (curr.next != null) sb.append(", ");
      curr = curr.next;
    }
    sb.append("]");
    return sb.toString();
  }

  public static void main(String[] args) {
    LinkedListQueue q = new LinkedListQueue();
    System.out.println("Queue initially empty? " + q.isEmpty());
    System.out.println("Initial size: " + q.size());

    // Enqueue (push) some elements
    q.push(10);
    q.push(20);
    q.push(30);
    System.out.println("After pushing 10, 20, 30: " + q);
    System.out.println("Current size: " + q.size());

    // Peek at the front
    System.out.println("Front element (peek): " + q.peek());

    // Dequeue (pop) two elements
    System.out.println("Popped: " + q.pop());
    System.out.println("After first pop: " + q);
    System.out.println("Popped: " + q.pop());
    System.out.println("After second pop: " + q);
    System.out.println("Current size: " + q.size());

    // Push again to test tail updates
    q.push(40);
    q.push(50);
    System.out.println("After pushing 40, 50: " + q);

    // Empty the queue completely
    while (!q.isEmpty()) {
        System.out.println("Dequeued " + q.pop() + " → " + q);
    }

    System.out.println("Queue empty? " + q.isEmpty());
  }
}

