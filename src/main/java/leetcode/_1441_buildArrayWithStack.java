package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array target and an integer n. In each iteration, you will read a number from  list = {1,2,3..., n}.
 * Build the target array using the following operations:
 * Push: Read a new element from the beginning list, and push it in the array.
 * Pop: delete the last element of the array.
 * If the target array is already built, stop reading more elements.
 * Return the operations to build the target array. You are guaranteed that the answer is unique.
 * Input: target = [1,3], n = 3
 * Output: ["Push","Push","Pop","Push"]
 * Explanation:
 * Read number 1 and automatically push in the array -> [1]
 * Read number 2 and automatically push in the array then Pop it -> [1]
 * Read number 3 and automatically push in the array -> [1,3]
 */
public class _1441_buildArrayWithStack {
    public static void main(String[] args) {
        int[] arr = {1, 3};
        int n = 3;

        buildArray(arr, n).stream().forEach(System.out::println);
    }

    public static List<String> buildArray(int[] target, int n) {
        int targetIndex = 0;
        List<String> result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (target[targetIndex] == i) {
                result.add("Push");
                targetIndex++;
                if (targetIndex == target.length) {
                    break;
                }
            } else {
                result.add("Push");
                result.add("Pop");
            }

        }

        return result;
    }
}