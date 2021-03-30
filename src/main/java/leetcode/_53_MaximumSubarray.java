package leetcode;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 * Example 1:
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Example 2:
 * Input: nums = [1]
 * Output: 1
 * Example 3:
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 * Constraints:
 * 1 <= nums.length <= 3 * 104
 * -105 <= nums[i] <= 105
 */
public class _53_MaximumSubarray {
    //greedy
    /**
     * Time complexity : O(N) since it's one pass along the array.
     * Space complexity : O(1), since it's a constant space solution.
     */
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int currSum = nums[0], maxSum = nums[0];

        for (int i = 1; i < n; i++) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }
}