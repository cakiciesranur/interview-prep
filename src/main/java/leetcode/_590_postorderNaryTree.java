package leetcode;
/**
 * Given an n-ary tree, return the postorder traversal of its nodes' values.
 * Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).
 * Follow up:
 * Recursive solution is trivial, could you do it iteratively?
 * Input: root = [1,null,3,2,4,null,5,6]
 * Output: [5,6,3,2,4,1]
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class _590_postorderNaryTree {
    /*Running Time: O(N)
      Space Complexity: O(N)*/
    public List<Integer> postorderWithStack(Node root) {
        LinkedList<Integer> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            ans.addFirst(node.val);
            for (Node child : node.children) {
                stack.push(child);
            }
        }
        return ans;

    }
}