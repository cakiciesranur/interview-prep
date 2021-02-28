package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Given the root of a binary tree, return the preorder traversal of its nodes' values.
 */
public class _144_preorderTraversalBT02 {

    public List<Integer> preorderTraversalWithStack(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<Integer> nodes = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            nodes.add(curr.val);
            if(curr.right!= null){
                stack.push(curr.right);
            }
            if(curr.left!= null){
                stack.push(curr.left);
            }

        }
        return nodes;
    }
}

