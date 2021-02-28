package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * A binary tree is univalued if every node in the tree has the same value.
 * Return true if and only if the given tree is univalued.
 * Input: [1,1,1,1,1,null,1]
 * Output: true
 */

//Time Complexity: O(N)O(N), where NN is the number of nodes in the given tree.
//Space Complexity: O(N)O(N).
public class _965_univaluedBT02 {
    List<Integer> vals = new ArrayList<>();

    public boolean isUnivalTree(TreeNode root) {
        dfs(root);

        for (Integer val : vals) {
            if (val != vals.get(0)) {
                return false;
            }
        }
        return true;
    }

    private void dfs(TreeNode root) {
        if (root != null) {
            vals.add(root.val);
            dfs(root.left);
            dfs(root.right);

        }
    }
}
