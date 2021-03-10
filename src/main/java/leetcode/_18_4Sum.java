package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 * Notice that the solution set must not contain duplicate quadruplets.
 * Example 1:
 * Input: nums = [1,0,-1,0,-2,2], target = 0
 * Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * Example 2:
 * Input: nums = [], target = 0
 * Output: []
 */
public class _18_4Sum {
    public static void main(String[] args) {
        int[] nums = new int[]{-2,-1,-1,1,1,2,2};
        System.out.println(fourSum(nums, 0));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kthSum(nums, target, 0, 4);
    }

    private static List<List<Integer>> kthSum(int[] nums, int target, int start, int k) {
        List<List<Integer>> res = new ArrayList<>();

        if (nums.length == start || target > nums[nums.length - 1] * k || target < nums[start] * k) {
            return res;
        }

        if (k == 2) {
            return twoSum(nums, target, start);
        }

        for (int i = start; i < nums.length; ++i) {
            if (i == start || nums[i] != nums[i - 1]) {
                for (List<Integer> set : kthSum(nums, target - nums[i], i + 1, k - 1)) {
                    res.add(new ArrayList<>(Arrays.asList(nums[i])));
                    res.get(res.size() - 1).addAll(set);
                }
            }
        }
        return res;
    }

    private static List<List<Integer>> twoSum(int[] nums, int target, int start) {
        int first = start;
        int second = nums.length - 1;
        List<List<Integer>> res = new ArrayList<>();

        while (first < second) {
            int sum = nums[first] + nums[second];
            if (sum < target || (first > start && nums[first] == nums[first - 1])) {
                first++;
            } else if (sum > target || (second < nums.length - 1 && nums[second] == nums[second - 1])) {
                second--;
            } else {
                res.add(Arrays.asList(nums[first++], nums[second--]));
            }

        }
        return res;
    }
}
