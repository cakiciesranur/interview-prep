package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an n-ary tree, return the preorder traversal of its nodes' values.
 * Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).
 * Recursive solution is trivial, could you do it iteratively?
 */
public class _589_preorderNarryTree {
    public List<Integer> preorderByRecursive(Node root) {
        List<Integer> list = new ArrayList<>();

        return helper(root, list);
    }

    private List<Integer> helper(Node root, List<Integer> list) {
        if (root == null) {
            return list;
        }

        list.add(root.val);
        for (Node child : root.children) {
            helper(child, list);
        }

        return list;

    }
}
