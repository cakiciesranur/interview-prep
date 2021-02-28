package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given the root of a binary tree, return the preorder traversal of its nodes' values.
 */
public class _144_preorderTraversalBT {

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<Integer> res = new ArrayList<>();

        res.add(root.val);


        if (root.left != null) {
            res.addAll(preorderTraversal(root.left));
        }

        if (root.right != null) {
            res.addAll(preorderTraversal(root.right));
        }
        return res;
    }
}

