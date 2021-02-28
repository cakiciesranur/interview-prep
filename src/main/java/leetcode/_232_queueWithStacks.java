package leetcode;

import java.util.Stack;

/**
 * Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).
 * Implement the MyQueue class:
 * void push(int x) Pushes element x to the back of the queue.
 * int pop() Removes the element from the front of the queue and returns it.
 * int peek() Returns the element at the front of the queue.
 * boolean empty() Returns true if the queue is empty, false otherwise.
 * Notes:
 * You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty operations are valid.
 * Depending on your language, the stack may not be supported natively. You may simulate a stack using a list or deque (double-ended queue) as long as you use only a stack's standard operations.
 * Follow-up: Can you implement the queue such that each operation is amortized O(1) time complexity? In other words, performing n operations will take overall O(n) time even if one of those operations may take longer.
 */
public class _232_queueWithStacks {
    class MyQueue {
        Stack<Integer> oldestStack, newestStack;
        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
            newestStack = new Stack<Integer>();
            oldestStack = new Stack<Integer>();
        }
        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            newestStack.push(x);
        }
        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            shiftStacks();
            return oldestStack.pop();
        }
        /**
         * Get the front element.
         */
        public int peek() {
            shiftStacks();
            return oldestStack.peek();
        }
        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            shiftStacks();
            return oldestStack.isEmpty();
        }
        private void shiftStacks() {
            if (oldestStack.isEmpty()) {
                while (!newestStack.isEmpty()) {
                    oldestStack.push(newestStack.pop());
                }
            }
        }
    }
}
