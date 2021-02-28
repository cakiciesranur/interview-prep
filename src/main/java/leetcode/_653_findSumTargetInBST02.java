package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Given the root of a Binary Search Tree and a target number k, return true if there exist two elements in the BST such that their sum is equal to the given target.
 */
public class _653_findSumTargetInBST02 {
    /**
     * Using BFS and HashSet
     */
    //Time complexity : O(n) . We need to traverse over the whole tree once in the worst case. Here, n refers to the number of nodes in the given tree.
    //Space complexity : O(n) . The size of the setset can grow atmost upto n.
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            if (queue.peek() != null) {
                TreeNode curr = queue.remove();
                if (set.contains(k - curr.val)) {
                    return true;
                }
                set.add(curr.val);
                queue.add(curr.left);
                queue.add(curr.right);
            } else {
                queue.remove();
            }
        }
        return false;
    }
}
