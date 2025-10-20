import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LinkedListStack {

    private static class ListNode {
        int _val;
        ListNode _next;

        ListNode(int val) {
            this._val = val;
            this._next = null;
        }
    }

    /** Stack implementation based on linked list */
    /** Class properties */
    private ListNode _head;
    private int _size;

    /** Constructor */
    public LinkedListStack(){
        this._head = null;
        this._size = 0;
    }

    /** Get the size of the stack */
    public int size() {
        return _size;
    }

    /** Check the stack emptyness */
    // return self._head == None
    public boolean is_empty() {
        return _head == null;
    }

    /** Push a new elt into the stack */
    public void push(int val) {
        ListNode new_node = new ListNode(val);
        new_node._next = _head;
        _head = new_node;
        _size += 1; // dont forget the size
    }

    /** Get the top elt in the stack */
    public int pop() {
        if (_head == null) {
            throw new IllegalStateException("Empty Stack!");
        }
        int num = _head._val;
        _head = _head._next;
        _size -= 1;
        return num;
    }

    /** Peek the top elt on the stack */
    public int peek() {
        if (_head == null) {
            throw new IllegalStateException("Empty Stack!");
        }
        return _head._val;
    }

    public List<Integer> to_list() {
        List<Integer> arr = new ArrayList<>();
        ListNode curr = _head;
        while (curr != null) {
            arr.add(curr._val);
            curr = curr._next;
        }
        Collections.reverse(arr);
        return arr;
    }

    public static void main(String[] args) {
        LinkedListStack s = new LinkedListStack();
        for (int x : new int[]{10, 20, 30}) {
            s.push(x);
        }
        System.out.println("Stack = " + s.to_list());  // [10, 20, 30]  ← 底到顶

        System.out.println("peek: " + s.peek());       // 30
        System.out.println("pop : " + s.pop());        // 30
        System.out.println("after pop = " + s.to_list());  // [10, 20]
        System.out.println("size: " + s.size());       // 2
    }
}