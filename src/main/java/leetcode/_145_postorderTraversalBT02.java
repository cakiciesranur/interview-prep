package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given the root of a binary tree, return the postorder traversal of its nodes' values.
 */
public class _145_postorderTraversalBT02 {

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<Integer> res = new ArrayList<>();

        if (root.left != null) {
            res.addAll(postorderTraversal(root.left));

        }
        if (root.right != null) {
            res.addAll(postorderTraversal(root.right));

        }
        res.add(root.val);

        return res;
    }

}

