package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary search tree, rearrange the tree in in-order so that the leftmost node
 * in the tree is now the root of the tree, and every node has no left child and only one right child
 */
public class _897_increaseOrderSearchTree {

    /**
     * Time Complexity: O(N)O(N), where NN is the number of nodes in the given tree.
     * Space Complexity: O(N)O(N).
     */
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> nodes = inorderTraversal(root);

        TreeNode ans = new TreeNode(0), cur = ans;

        for (int value : nodes) {
            cur.right = new TreeNode(value);
            cur = cur.right;
        }

        return ans.right;
    }

    private List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> nodes = new ArrayList<>();
        if (root.left != null) {
            nodes.addAll(inorderTraversal(root.left));
        }
        nodes.add(root.val);
        if (root.right != null) {
            nodes.addAll(inorderTraversal(root.right));
        }
        return nodes;

    }


}