package leetcode;

import java.util.HashSet;

/**
 * Given the root of a Binary Search Tree and a target number k, return true if there exist two elements in the BST such that their sum is equal to the given target.
 */
public class _653_findSumTargetInBST {
    //Time complexity : O(n) The entire tree is traversed only once in the worst case. Here, n refers to the number of nodes in the given tree.
    //Space complexity : O(n) The size of the set can grow upto n in the worst case.
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        return find(root, set, k);
    }

    private boolean find(TreeNode root, HashSet<Integer> set, int target) {
        if (root == null) {
            return false;
        }
        if (set.contains(target - root.val)) {
            return true;
        }
        set.add(root.val);
        return find(root.left, set, target) || find(root.right, set, target);
    }
}
