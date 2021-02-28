package crackingCodingInterview._04_treesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * List of Depths: Given a binary tree, design an algorithm which creates a linked list of all the nodes
 * at each depth (e.g., if you have a tree with depth D, you'll have D linked lists).
 *
 * Example 1:
 *
 * Input: {1,2,3,4}
 * Output: [1->null,2->3->null,4->null]
 * Explanation:
 *         1
 *        / \
 *       2   3
 *      /
 *     4
 * Example 2:
 *
 * Input: {1,#,2,3}
 * Output: [1->null,2->null,3->null]
 * Explanation:
 *     1
 *      \
 *       2
 *      /
 *     3
 */
public class _03_listOfDepth {
    public static void main(String[] args) {

    }

    private List<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root){
        List<LinkedList<TreeNode>> result = new ArrayList<>();
        createLevelLinkedList(root, result, 0 );
        return result;
    }

    private void createLevelLinkedList(TreeNode root, List<LinkedList<TreeNode>> lists, int level) {
        if (root == null) {
            return;
        }

        LinkedList<TreeNode> list=null;
    }
}
