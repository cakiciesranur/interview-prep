package leetcode;

/**
 * Given an array of integers numbers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 * Return the indices of the two numbers (1-indexed) as an integer array answer of size 2, where 1 <= answer[0] < answer[1] <= numbers.length.
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 * Example 1:
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 * Example 2:
 * Input: numbers = [2,3,4], target = 6
 * Output: [1,3]
 * Example 3:
 * Input: numbers = [-1,0], target = -1
 * Output: [1,2]
 */
public class _167_twoSumSortedArray {
    //Time complexity : O(n). Each of the nn elements is visited at most once, thus the time complexity is O(n).
    //Space complexity : O(1). We only use two indexes, the space complexity is O(1).
    public int[] twoSum(int[] numbers, int target) {
        int first = 0;
        int second = numbers.length - 1;
        int sum = 0;

        while (first <= second) {
            sum = numbers[first] + numbers[second];
            if (sum > target) {
                second--;
            } else if (sum < target) {
                first++;
            } else {
                return new int[]{first, second};
            }
        }

        return new int[]{};
    }
}
