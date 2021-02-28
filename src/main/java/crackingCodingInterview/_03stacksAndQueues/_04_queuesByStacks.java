package crackingCodingInterview._03stacksAndQueues;

import java.util.Stack;

/**
 * Queue via Stacks: Implement a MyQueue class which implements a queue using two stacks.
 */
public class _04_queuesByStacks {

}

class MyQueue<T> {
    Stack<T> newestStack, oldestStack;

    MyQueue() {
        newestStack = new Stack<T>();
        oldestStack = new Stack<T>();
    }

    public int size() {
        return newestStack.size() + oldestStack.size();
    }

    public void add(T value) {
        newestStack.push(value);
    }

    private void shiftStacks() {
        if (oldestStack.isEmpty()) {
            while (!newestStack.isEmpty()) {
                oldestStack.push(newestStack.pop());
            }
        }
    }

    public T peek() {
        shiftStacks();
        return oldestStack.peek();
    }

    public T remove() {
        shiftStacks();
        return oldestStack.pop();
    }
}