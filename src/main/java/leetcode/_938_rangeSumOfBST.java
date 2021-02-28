package leetcode;

/**
 * Given the root node of a binary search tree, return the sum of values of all nodes with a value in the range [low, high].
 */
public class _938_rangeSumOfBST {

    private int sum = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return sum;
        }

        calculateSum(root, low, high);

        return sum;
    }

    private void calculateSum(TreeNode root, int low, int high) {
        if (root == null) {
            return;
        }

        calculateSum(root.left, low, high);

        if (root.val <= high && root.val >= low) {
            sum = sum + root.val;
        }
        calculateSum(root.right, low, high);
    }
}
