package crackingCodingInterview._03stacksAndQueues;

import java.util.Stack;

/**
 * Stack Min: How would you design a stack which, in addition to push and pop, has a function min
 * which returns the minimum element? Push, pop and min should all operate in 0(1) time.
 */
public class _02_minStackValue {

    //There's just one issue with this: if we have a large stack, we waste a lot of space by keeping track of the min
    //for every single element. Can we do better?
    class StackWithMin extends Stack<NodeWithMin> {

        public void push(int value) {
            int newMin = Math.min(value, min());
            super.push(new NodeWithMin(value, newMin));
        }

        public int min() {
            if (this.isEmpty()) {
                return Integer.MAX_VALUE;
            } else {
                return peek().min;
            }
        }
    }

    class NodeWithMin {
        int value;
        int min;

        public NodeWithMin(int v, int m) {
            this.min = m;
            this.value = v;

        }

    }
}
