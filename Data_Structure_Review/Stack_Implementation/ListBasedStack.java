package Stack_Implementation;

import java.util.ArrayList;
import java.util.List;

public class ListBasedStack {
    /** A stack implementation based on list */

    /** Construct methods */
    private List<Integer> _stack;

    public ListBasedStack() {
        this._stack = new ArrayList<>();
    }

    /** Get the size of the stack */
    public int size() {
        return _stack.size();
    }

    /** Check the stack emptyness */
    public boolean is_empty() {
        return _stack.isEmpty();
    }

    /** Insert into the last position of list */
    public void push(int val) {
        _stack.add(val);
    }

    /** Get the last elt in this list as the pop operation */
    public int pop() {
        if (is_empty()) {
            throw new IllegalStateException("Stack is empty!");
        }
        return _stack.remove(_stack.size() - 1);
    }

    /** Check the top of the stack */
    public int peek() {
        if (is_empty()) {
            throw new IllegalStateException("Stack is empty!");
        }
        return _stack.get(_stack.size() - 1);  // LIFO!
    }

    /** Just return the list */
    public List<Integer> to_list() {
        return _stack;
    }

    public static void main(String[] args) {
        ListBasedStack my_stack = new ListBasedStack();
        for (int x : new int[]{10, 20, 30}) {
            my_stack.push(x);
        }
        System.out.println("Stack = " + my_stack.to_list());      // [10, 20, 30]
        System.out.println("peek: " + my_stack.peek());           // 30
        System.out.println("pop : " + my_stack.pop());            // 30
        System.out.println("after pop = " + my_stack.to_list());  // [10, 20]
        System.out.println("size: " + my_stack.size());           // 2
    }
}