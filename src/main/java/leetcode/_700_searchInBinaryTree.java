package leetcode;

/**
 * You are given the root of a binary search tree (BST) and an integer val.
 * Find the node in the BST that the node's value equals val and return the subtree rooted with that node.
 * If such a node does not exist, return null.
 */
public class _700_searchInBinaryTree {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return root;
        }
        if (root.val == val) {
            return root;
        }

        return (val < root.val) ? searchBST(root.left, val) : searchBST(root.right, val);


    }

    /**
     * public TreeNode searchBST(TreeNode root, int val) {
     while(root != null && root.val != val){
     root = val<root.val? root.left:root.right;
     }
     return root;
     }
     */
}


