package leetcode;

/**
 * A binary tree is univalued if every node in the tree has the same value.
 * Return true if and only if the given tree is univalued.
 * Input: [1,1,1,1,1,null,1]
 * Output: true
 */

//Time Complexity: O(N)O(N), where NN is the number of nodes in the given tree.
//Space Complexity: O(H)O(H), where HH is the height of the given tree.
//recursive
public class _965_univaluedBT03 {

    public boolean isUnivalTree(TreeNode root) {
        boolean left = root.left == null || (root.left.val == root.val && isUnivalTree(root.left));
        boolean right = root.right == null || (root.right.val == root.val && isUnivalTree(root.right));

        return left && right;
    }
}
