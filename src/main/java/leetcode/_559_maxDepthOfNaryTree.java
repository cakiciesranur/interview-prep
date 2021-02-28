package leetcode;

/**
 * Given a n-ary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).
 * Input: root = [1,null,3,2,4,null,5,6]
 * Output: 3
 */
public class _559_maxDepthOfNaryTree {
    //By recursive
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }

        int maxDepth = 0;

        for (Node child : root.children) {
            maxDepth = Math.max(maxDepth, maxDepth(child));
        }

        return maxDepth + 1;
    }
}
