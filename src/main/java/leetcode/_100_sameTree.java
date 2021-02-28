package leetcode;

/**
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 */
public class _100_sameTree {
    //Time : O(n)
    //Space complexity : O(log(N)) in the best case of completely balanced tree and O(N)
    // in the worst case of completely unbalanced tree, to keep a recursion stack.
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p != null && q != null) {
            return p.val == q.val
                    && isSameTree(p.left, q.left)
                    && isSameTree(p.right, q.right);
        }

        return false;
    }
}
