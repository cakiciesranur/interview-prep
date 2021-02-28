package leetcode;

/**
 * Design a stack which supports the following operations.
 * Implement the CustomStack class:
 * CustomStack(int maxSize) Initializes the object with maxSize which is the maximum number of elements in the stack or do nothing if the stack reached the maxSize.
 * void push(int x) Adds x to the top of the stack if the stack hasn't reached the maxSize.
 * int pop() Pops and returns the top of stack or -1 if the stack is empty.
 * void inc(int k, int val) Increments the bottom k elements of the stack by val. If there are less than k elements in the stack, just increment all the elements in the stack.
 */
public class _1381_designAStack02 {
    public static void main(String[] args) {
        CustomStackWithArray s = new CustomStackWithArray(5);
        System.out.println("Popup from empty stack : " + s.pop());
        s.push(4);
        s.push(5);
        s.push(6);
        s.push(7);
        s.push(8);
        s.push(9);
        System.out.println("Popup" + s.pop());
        s.increment(3, 100);
    }
}

class CustomStackWithArray {
    int[] stack;
    int index;
    int maxSize;

    public CustomStackWithArray(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int[maxSize];
        index = 0;
    }

    public void push(int x) {
        if (maxSize > index) {
            stack[index++] = x;
        }
    }

    public int pop() {
        if (index == 0) {
            return -1;
        }
        return stack[--index];
    }

    public void increment(int k, int val) {
        if (stack.length == 0) {
            return;
        }
        for (int i = 0; i < k && i < stack.length; i++) {
            stack[i] = stack[i] + val;
        }
    }
}