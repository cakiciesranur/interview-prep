package crackingCodingInterview._03stacksAndQueues;

import java.util.Stack;

/**
 * Why might this be more space efficient? Suppose we had a very large stack and the first element inserted
 * happened to be the minimum. In the first solution, we would be keeping n integers, where n is the size of
 * the stack. In the second solution though, we store just a few pieces of data: a second stack with one element
 * and the members within this stack.
 */
public class _02_minStackValue02 {

    public class StackWithMin2 extends Stack<Integer> {
        Stack<Integer> s2;

        public StackWithMin2() {
            s2 = new Stack<>();
        }

        public void push(int value) {
            if (value <= min()) {
                s2.push(value);
            }
            super.push(value);
        }

        public Integer pop() {
            int value = super.pop();
            if (value == min()) {
                s2.pop();
            }
            return value;
        }

        public int min() {
            if (s2.isEmpty()) {
                return Integer.MAX_VALUE;
            } else {
                return s2.peek();
            }
        }
    }
}
