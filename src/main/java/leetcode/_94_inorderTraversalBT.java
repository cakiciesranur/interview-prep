package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 */
public class _94_inorderTraversalBT {
    public static void main(String[] args) {

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> nodes =new ArrayList<>();
        if (root == null) {
            return Collections.emptyList();
        }

        if (root.left !=null) {
            nodes.addAll(inorderTraversal(root.left));
        }
        nodes.add(root.val);
        if (root.right !=null) {
            nodes.addAll(inorderTraversal(root.right));
        }

        return nodes;
    }
}

