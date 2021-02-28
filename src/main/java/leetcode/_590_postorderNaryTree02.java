package leetcode;
/**
 * Given an n-ary tree, return the postorder traversal of its nodes' values.
 * Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).
 * Follow up:
 * Recursive solution is trivial, could you do it iteratively?
 * Input: root = [1,null,3,2,4,null,5,6]
 * Output: [5,6,3,2,4,1]
 */

import java.util.ArrayList;
import java.util.List;

public class _590_postorderNaryTree02 {

    public List<Integer> postorderByRecursive(Node root) {
        List<Integer> ans = new ArrayList<>();

        return helper(root, ans);
    }

    private List<Integer> helper(Node root, List<Integer> list) {
        if (root == null) {
            return list;
        }

        for (Node child : root.children) {
            helper(child, list);
        }

        list.add(root.val);
        return list;
    }
}