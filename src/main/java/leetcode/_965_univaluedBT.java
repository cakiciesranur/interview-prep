package leetcode;

import java.util.Stack;

/**
 * A binary tree is univalued if every node in the tree has the same value.
 * Return true if and only if the given tree is univalued.
 * Input: [1,1,1,1,1,null,1]
 * Output: true
 */
public class _965_univaluedBT {

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return false;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int val = root.val;

        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if (curr.val != val) {
                return false;
            }

            if (curr.left != null) {
                stack.push(curr.left);
            }

            if (curr.left != null) {
                stack.push(curr.right);
            }

        }
        return true;

    }
}
