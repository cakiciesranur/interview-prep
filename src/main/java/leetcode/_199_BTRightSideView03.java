package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
public class _199_BTRightSideView03 {
    // BFS: Two Queues

    /**
     * Time complexity:O(N) since one has to visit each node.
     * Space complexity:O(D) to keep the queues, where DD is a tree diameter. Let's use the last level to estimate the queue size.
     * This level could contain up to N/2 tree nodes in the case of complete binary tree.
     */
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> res = new ArrayList<>();
        ArrayDeque<TreeNode> nextLevel = new ArrayDeque();
        nextLevel.add(root);
        ArrayDeque<TreeNode> currLevel = new ArrayDeque();

        TreeNode node = null;

        while (!nextLevel.isEmpty()) {
            currLevel = nextLevel.clone();
            nextLevel.clear();

            while (!currLevel.isEmpty()) {
                node = currLevel.poll();
                // add child nodes of the current level
                // in the queue for the next level
                if (node.left != null)
                    nextLevel.offer(node.left);
                if (node.right != null)
                    nextLevel.offer(node.right);
            }

            // The current level is finished.
            // Its last element is the rightmost one.
            if (currLevel.isEmpty())
                res.add(node.val);
        }
        return res;
    }
}
