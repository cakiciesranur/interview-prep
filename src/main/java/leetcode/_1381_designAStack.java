package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Design a stack which supports the following operations.
 * Implement the CustomStack class:
 * CustomStack(int maxSize) Initializes the object with maxSize which is the maximum number of elements in the stack or do nothing if the stack reached the maxSize.
 * void push(int x) Adds x to the top of the stack if the stack hasn't reached the maxSize.
 * int pop() Pops and returns the top of stack or -1 if the stack is empty.
 * void inc(int k, int val) Increments the bottom k elements of the stack by val. If there are less than k elements in the stack, just increment all the elements in the stack.
 */
public class _1381_designAStack {
    public static void main(String[] args) {
        CustomStack s = new CustomStack(5);
        System.out.println("Popup from empty stack : " + s.pop());
        s.push(4);
        s.push(5);
        s.push(6);
        s.push(7);
        s.push(8);
        s.push(9);
        System.out.println("Printing elements:: (stack size)" + s.stack.size());
        s.stack.stream().forEach(System.out::println);
        System.out.println("Popup" + s.pop());
        s.increment(3, 100);

        System.out.println("Printing elements after increment:: (stack size)" + s.stack.size());
        s.stack.stream().forEach(System.out::println);

    }
}

class CustomStack {
    List<Integer> stack;
    int index = 0;
    int maxSize;

    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new ArrayList<>(maxSize);
    }

    public void push(int x) {
        if (maxSize > index) {
            stack.add(x);
            index++;
        }
    }

    public int pop() {
        if (stack.isEmpty()) {
            return -1;
        }
        int val = stack.get(index - 1);
        stack.remove(index - 1);
        index--;
        return val;
    }

    public void increment(int k, int val) {
        if (stack.isEmpty()) {
            return;
        }
        for (int i = 0; i < k && i < stack.size(); i++) {
            stack.set(i, stack.get(i) + val);
        }
    }
}