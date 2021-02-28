package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Given an n-ary tree, return the preorder traversal of its nodes' values.
 * Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).
 * Recursive solution is trivial, could you do it iteratively?
 */
public class _589_preorderNarryTree02 {
    public List<Integer> preorderByIterative(Node root) {
        LinkedList<Integer> list = new LinkedList<>();

        if (root == null) {
            return list;
        }

        Stack<Node> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            list.add(node.val);
            for (int i = node.children.size() - 1; i >= 0; i--) {
                stack.push(node.children.get(i));
            }

        }
        return list;
    }
}
