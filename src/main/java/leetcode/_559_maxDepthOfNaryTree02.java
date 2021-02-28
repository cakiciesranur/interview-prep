package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a n-ary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).
 * Input: root = [1,null,3,2,4,null,5,6]
 * Output: 3
 */
public class _559_maxDepthOfNaryTree02 {
    //By iterative
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int depth = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node curr = queue.poll();
                for (Node child : curr.children) {
                    queue.add(child);
                }
            }
            depth++;

        }
        return depth;


    }
}
