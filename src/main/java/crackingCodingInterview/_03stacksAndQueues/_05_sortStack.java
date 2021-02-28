package crackingCodingInterview._03stacksAndQueues;

import java.util.Stack;

/**
 * Sort Stack: Write a program to sort a stack such that the smallest items are on the top. You can use
 * an additional temporary stack, but you may not copy the elements into any other data structure
 * (such as an array). The stack supports the following operations: push, pop, peek, and is Empty.
 */
public class _05_sortStack {
    public static void main(String[] args) {

        Stack<Integer> s = new Stack<>();
        s.push(34);
        s.push(3);
        s.push(31);
        s.push(98);
        s.push(92);
        s.push(23);

        Stack<Integer> result = sortStack(s);
        while (!result.isEmpty()) {
            System.out.println(result.pop());
        }

    }
    //This algorithm is O ( N2 ) time and O ( N) space.
    public static Stack<Integer> sortStack(Stack<Integer> input) {
        if (input.isEmpty()) {
            return null;
        }

        Stack<Integer> temp = new Stack<>();

        while (!input.isEmpty()) {
            Integer tmp = input.pop();
            if (temp.isEmpty()) {
                temp.push(tmp);
            }

            while (!temp.isEmpty() && temp.peek() > tmp) {
                input.push(temp.pop());
            }
            temp.push(tmp);
        }

        while (!temp.isEmpty()) {
            input.push(temp.pop());
        }
        return input;
    }
}