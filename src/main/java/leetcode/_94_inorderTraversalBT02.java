package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 */
public class _94_inorderTraversalBT02 {
    public static void main(String[] args) {

    }

    //Space complexity : list : O(n) + stack O(n) = O(n)
    //Time complexity : O(n)
    public List<Integer> inorderTraversalWithStack(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            nodes.add(current.val);
            current = current.right;
        }
        return nodes;
    }
}

