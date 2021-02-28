package leetcode;

/***Invert a binary tree.
 Example:
 Input:
 4
 /   \
 2     7
 / \   / \
 1   3 6   9
 Output:
 4
 /   \
 7     2
 / \   / \
 9   6 3   1
 */
public class _226_invertBT02 {
    //recursive
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);

        root.right = left;
        root.left = right;
        return root;
    }
}
