package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Implement a last in first out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal queue (push, top, pop, and empty).
 * Implement the MyStack class:
 * void push(int x) Pushes element x to the top of the stack.
 * int pop() Removes the element on the top of the stack and returns it.
 * int top() Returns the element on the top of the stack.
 * boolean empty() Returns true if the stack is empty, false otherwise.
 * Notes:
 * You must use only standard operations of a queue, which means only push to back, peek/pop from front, size, and is empty operations are valid.
 * Depending on your language, the queue may not be supported natively.
 * You may simulate a queue using a list or deque (double-ended queue), as long as you use only a queue's standard operations.
 */
public class _225_implementStackWithQueue {


}

class MyStack {
    Queue<Integer> q = new LinkedList<>();
    /**
     * Initialize your data structure here.
     */
    public MyStack() {
    }

    /**
     * Time complexity : O(n)O(n). The algorithm removes n elements and inserts n + 1n+1 elements to q1 , where n is the stack size. This gives 2n + 12n+1 operations.
     * The operations add and remove in linked lists has O(1)O(1) complexity.
     * Space complexity : O(1)O(1).
     */
    public void push(int x) {
        q.add(x);
        int size = q.size();
        while (size > 1) {
            q.add(q.remove());
            size--;
        }
    }

    /**
     * Time complexity : O(1)O(1).
     * Space complexity : O(1)O(1).
     */
    public int pop() {
        return q.remove();
    }

    /**
     * Time complexity : O(1)O(1).
     * Space complexity : O(1)O(1).
     */
    public int top() {
        return q.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return q.isEmpty();
    }
}
