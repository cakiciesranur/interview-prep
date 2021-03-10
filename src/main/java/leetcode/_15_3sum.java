package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * Notice that the solution set must not contain duplicate triplets.
 * Example 1:
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Example 2:
 * Input: nums = []
 * Output: []
 * Example 3:
 * Input: nums = [0]
 * Output: []
 */
public class _15_3sum {
    /**
     * Time Complexity:O(n^2)
     * twoSumII is  O(n), and we call it nn times.
     * Sorting the array takes O(nlogn), so overall complexity is  O(nlogn+n^2). This is asymptotically equivalent to O(n^2).
     * Space Complexity: from O(logn) to  O(n), depending on the implementation of the sorting algorithm. For the purpose of complexity analysis, we ignore the memory required for the output.
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length && nums[i] <= 0; ++i) {
            if (i == 0 || nums[i - 1] != nums[i]) {
                findTwoSum(nums, i, result);
            }
        }
        return result;
    }
    private void findTwoSum(int[] nums, int currentIndex, List<List<Integer>> result) {
        int first = currentIndex + 1;
        int second = nums.length - 1;
        while (first < second) {
            int sum = nums[currentIndex] + nums[first] + nums[second];
            if (sum > 0) {
                second--;
            } else if (sum < 0) {
                first++;
            } else {
                result.add(Arrays.asList(nums[currentIndex], nums[first], nums[second]));
                first++;
                second--;
                while (first < second && nums[first] == nums[first - 1]) {
                    first++;
                }
            }
        }
    }
}
