package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/***Invert a binary tree.
 Example:
 Input:
 4
 /   \
 2     7
 / \   / \
 1   3 6   9
 Output:
 4
 /   \
 7     2
 / \   / \
 9   6 3   1
 */
public class _226_invertBT {
    //Complexity Analysis
    //Since each node in the tree is visited / added to the queue only once, the time complexity is O(n), where nn is the number of nodes in the tree.
    //Space complexity is O(n), since in the worst case, the queue will contain all nodes in one level of the binary tree.
    //https://leetcode.com/problems/invert-binary-tree/solution/
    //iteratively
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            TreeNode temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;
            if (curr.left != null) invertTree(curr.left);
            if (curr.right != null) invertTree(curr.right);
        }

        return root;
    }
}
