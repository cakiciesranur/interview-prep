package leetcode;

/**
 * You need to construct a string consists of parenthesis and integers from a binary tree with the preorder traversing way.
 * The null node needs to be represented by empty parenthesis pair "()". And you need to omit all the empty parenthesis pairs that don't affect the one-to-one mapping relationship between the string and the original binary tree.
 * Example 1:
 * Input: Binary tree: [1,2,3,4]
 * 1
 * /   \
 * 2     3
 * /
 * 4
 * Output: "1(2(4))(3)"
 * Explanation: Originallay it needs to be "1(2(4)())(3()())",
 * but you need to omit all the unnecessary empty parenthesis pairs.
 * And it will be "1(2(4))(3)".
 */
public class _606_constructStringFromBT {
    /**
     * Using Recursion
     */
    //Time complexity : O(n) The preorder traversal is done over the n nodes of the given Binary Tree.
    //Space complexity : O(n) The depth of the recursion tree can go upto n in case of a skewed tree.
    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        return helper(t).toString();
    }

    private StringBuilder helper(TreeNode t) {
        if (t == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(t.val);

        StringBuilder left = helper(t.left);
        StringBuilder right = helper(t.right);
        if (right == null && left == null) return sb;
        sb.append("(").append(left != null ? left : "").append(")");
        if (right != null) sb.append("(").append(right).append(")");
        return sb;
    }
}
