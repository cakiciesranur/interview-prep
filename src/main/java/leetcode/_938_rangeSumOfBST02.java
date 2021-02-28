package leetcode;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given the root node of a binary search tree, return the sum of values of all nodes with a value in the range [low, high].
 */
public class _938_rangeSumOfBST02 {
    public int rangeSumBSTWithQueue(TreeNode root, int low, int high) {
        int sum = 0;

        if (root == null) {
            return sum;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode current = q.remove();
            if (current.val >= low && current.val <= high) {
                sum += current.val;
            }

            if (current.left != null && current.val > low) {
                q.add(current.left);
            }

            if (current.right != null && current.val < high) {
                q.add(current.right);
            }
        }

        return sum;
    }
}
