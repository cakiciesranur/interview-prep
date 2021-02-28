/*
package crackingCodingInterview._03stacksAndQueues;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

*/
/**
 * Stack of Plates: Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
 * Therefore, in real life, we would likely start a new stack when the previous stack exceeds some
 * threshold. Implement a data structure SetOfStacks that mimics this. SetOfStacks should be
 * composed of several stacks and should create a new stack once the previous one exceeds capacity.
 * SetOfStacks. push() and SetOfStacks. pop() should behave identically to a single stack
 * (that is, pop () should return the same values as it would if there were just a single stack).
 * FOLLOW UP
 * Implement a function popAt(int index) which performs a pop operation on a specific substack.
 *//*

public class _03_stackOfPlates {
    public class SetOfStacks {
        List<Stack> stacks = new ArrayList<>();
        int capacity;

        public SetOfStacks(int capacity) {
            this.capacity = capacity;
        }


        public Stack<Integer> getLastStack() {
            if (stacks.size() == 0) {
                return null;
            }
            return stacks.get(stacks.size() - 1);
        }

        public void push(int val) {
            Stack last = getLastStack();
            if (last != null && !last.isFull()) {
                last.push(val);
            } else {
                Stack<Integer> stack = new Stack<>();
                stack.push(val);
                stacks.add(stack);
            }
        }

        public int pop() {
            Stack last = getLastStack();
            if (last == null) {
                throw new EmptyStackException();
            }

            int v = (int) last.pop();
            if (last.size() == 0) {
                stacks.remove(stacks.size() - 1);
            }
            return v;
        }



    }
}

}*/
