package leetcode;

import java.util.*;

/**
 * Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 * Input: root = [1,2,3,null,5,null,4]
 * Output: [1,3,4]
 * Example 2:
 * Input: root = [1,null,3]
 * Output: [1,3]
 * Example 3:
 * Input: root = []
 * Output: []
 */
public class _199_BTRightSideView02 {
    //BFS: One Queue + Sentinel

    /**
     * Time complexity:O(N) since one has to visit each node.
     * Space complexity: O(D) to keep the queues, where DD is a tree diameter. Let's use the last level to estimate the queue size.
     * This level could contain up to N/2 tree nodes in the case of complete binary tree.
     */
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        TreeNode prev, curr = root;

        while (!queue.isEmpty()) {
            prev = curr;
            curr = queue.poll();

            while (curr != null) {
                if (curr.left != null) {
                    queue.offer(curr.left);
                }

                if (curr.right != null) {
                    queue.offer(curr.right);
                }
                prev = curr;
                curr = queue.poll();
            }
            res.add(prev.val);
            // add a sentinel to mark the end
            // of the next level
            if (!queue.isEmpty()) {
                queue.offer(null);
            }
        }
        return res;
    }
}
