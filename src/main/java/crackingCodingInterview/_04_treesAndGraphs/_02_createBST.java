package crackingCodingInterview._04_treesAndGraphs;


/**
 * Minimal Tree: Given a sorted (increasing order) array with unique integer elements, write an
 * algorithm to create a binary search tree with minimal height.
 */
public class _02_createBST {

    static TreeNode createMinimalBST(int[] arr) {
        return createMinimalBSTWithRange(arr, 0, arr.length - 1);
    }

    private static TreeNode createMinimalBSTWithRange(int[] arr, int start, int end) {
        if (end < start) {
            return null;
        }

        int mid = (end + start) / 2;
        TreeNode tree = new TreeNode(arr[mid]);
        tree.left = createMinimalBSTWithRange(arr, start, mid - 1);
        tree.right = createMinimalBSTWithRange(arr, mid + 1, end);
        return tree;
    }

}

