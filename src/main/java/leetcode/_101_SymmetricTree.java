package leetcode;

/**
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 * mirror of the binary tree
 */
public class _101_SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }

        if (t1 != null && t2 != null && t1.val == t2.val) {
            return isMirror(t1.right, t2.left)
                    && isMirror(t1.left, t2.right);
        }

        return false;

    }
}
