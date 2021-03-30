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
public class _53_MaximumSubarray03 {
    //Divide and conquer

    /**
     * Time complexity : \mathcal{O}(N \log N)O(NlogN). Let's compute the solution with the help of master theorem T(N) = aT\left(\frac{b}{N}\right) + \Theta(N^d)T(N)=aT(
     * N
     * b
     * ​
     *  )+Θ(N
     * d
     *  ). The equation represents dividing the problem up into aa subproblems of size \frac{N}{b}
     * b
     * N
     * ​
     *   in \Theta(N^d)Θ(N
     * d
     *  ) time. Here one divides the problem in two subproblemes a = 2, the size of each subproblem (to compute left and right subtree) is a half of initial problem b = 2, and all this happens in a \mathcal{O}(N)O(N) time d = 1. That means that \log_b(a) = dlog
     * b
     * ​
     *  (a)=d and hence we're dealing with case 2 that means \mathcal{O}(N^{\log_b(a)} \log N) = \mathcal{O}(N \log N)O(N
     * log
     * b
     * ​
     *  (a)
     *  logN)=O(NlogN) time complexity.
     *
     * Space complexity : \mathcal{O}(\log N)O(logN) to keep the recursion stack.
     */
    public int crossSum(int[] nums, int left, int right, int p) {
        if (left == right) return nums[left];

        int leftSubsum = Integer.MIN_VALUE;
        int currSum = 0;
        for (int i = p; i > left - 1; --i) {
            currSum += nums[i];
            leftSubsum = Math.max(leftSubsum, currSum);
        }

        int rightSubsum = Integer.MIN_VALUE;
        currSum = 0;
        for (int i = p + 1; i < right + 1; ++i) {
            currSum += nums[i];
            rightSubsum = Math.max(rightSubsum, currSum);
        }

        return leftSubsum + rightSubsum;
    }

    public int helper(int[] nums, int left, int right) {
        if (left == right) return nums[left];

        int p = (left + right) / 2;

        int leftSum = helper(nums, left, p);
        int rightSum = helper(nums, p + 1, right);
        int crossSum = crossSum(nums, left, right, p);

        return Math.max(Math.max(leftSum, rightSum), crossSum);
    }

    public int maxSubArray(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }
}