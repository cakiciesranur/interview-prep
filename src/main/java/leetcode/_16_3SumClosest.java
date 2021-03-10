package leetcode;

import java.util.Arrays;

/**
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * Example 1:
 * Input: nums = [-1,2,1,-4], target = 1
 * Output: 2
 * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class _16_3SumClosest {
    //Time Complexity: O(n^2)
    // We have outer and inner loops, each going through nn elements.
    //Sorting the array takes O(nlogn), so overall complexity is O(nlogn+n^2)
    //This is asymptotically equivalent to O(n^2)
    //Space Complexity: from O(logn) to O(n), depending on the implementation of the sorting algorithm.
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int first = i + 1;
            int second = nums.length - 1;
            while (first < second) {
                int sum = nums[i] + nums[first] + nums[second];
                if (Math.abs(target - sum) < Math.abs(diff)) {
                    diff = target - sum;
                }
                if (sum < target) {
                    first++;
                } else {
                    second--;
                }
            }
        }
        return target - diff;
    }
}
