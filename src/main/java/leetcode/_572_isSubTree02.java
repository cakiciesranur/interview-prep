package leetcode;

/**
 * Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s.
 * A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.
 * Given tree s:
 * <p>
 * 3
 * / \
 * 4   5
 * / \
 * 1   2
 * /
 * 0
 * Given tree t:
 * 4
 * / \
 * 1   2
 * Return false.
 * Given tree s:
 * <p>
 * 3
 * / \
 * 4   5
 * / \
 * 1   2
 * Given tree t:
 * 4
 * / \
 * 1   2
 * Return true, because t has the same structure and node values with a subtree of s.
 */

public class _572_isSubTree02 {

    //Time complexity : O(m^2+n^2+m*n). A total of nn nodes of the tree ss and mm nodes of tree tt are traversed.
    // Assuming string concatenation takes O(k) time for strings of length kk and indexOf takes O(m*n)O(m∗n).
    //Space complexity : O(max(m,n)). The depth of the recursion tree can go upto nn for tree tt and mm for tree ss in worst case.
    public boolean isSubtree(TreeNode s, TreeNode t) {
        String tree1 = preOrder(s, true);
        String tree2 = preOrder(t, true);
        return tree1.contains(tree2);
    }

    private String preOrder(TreeNode root, boolean left) {
        if (root == null) {
            if (left) {
                return "lnull";
            } else {
                return "rnull";
            }
        }

        return "#" + root.val + " " + preOrder(root.left, true) + " " + preOrder(root.right, false);
    }
}
