package leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * You need to construct a string consists of parenthesis and integers from a binary tree with the preorder traversing way.
 * The null node needs to be represented by empty parenthesis pair "()". And you need to omit all the empty parenthesis pairs that don't affect the one-to-one mapping relationship between the string and the original binary tree.
 * Example 1:
 * Input: Binary tree: [1,2,3,4]
 * 1
 * /   \
 * 2     3
 * /
 * 4
 * Output: "1(2(4))(3)"
 * Explanation: Originallay it needs to be "1(2(4)())(3()())",
 * but you need to omit all the unnecessary empty parenthesis pairs.
 * And it will be "1(2(4))(3)".
 */
public class _606_constructStringFromBT03 {
    /**
     * Iterative Method Using stack
     */
    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(t);
        Set<TreeNode> visited = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            t = stack.peek();
            if (visited.contains(t)) {
                stack.pop();
                sb.append(")");
            } else {
                visited.add(t);
                sb.append("(").append(t.val);
                if (t.left == null && t.right != null) {
                    sb.append("()");
                }
                if (t.right != null) {
                    stack.push(t.right);
                }

                if (t.left != null) {
                    stack.push(t.left);
                }
            }
        }


        //return sb.toString(); wrong because we add "(" in  begin and  ")" in the end. "(1(2(4))(3))"
        return sb.substring(1, sb.length()-1);
    }
}
