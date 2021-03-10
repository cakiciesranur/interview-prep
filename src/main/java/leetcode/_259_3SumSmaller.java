package leetcode;

import java.util.Arrays;

/**
 * Given an array of n integers nums and an integer target, find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.
 * Follow up: Could you solve it in O(n2) runtime?
 * Example 1:
 * Input: nums = [-2,0,1,3], target = 2
 * Output: 2
 * Explanation: Because there are two triplets which sums are less than 2:
 * [-2,0,1]
 * [-2,0,3]
 * Example 2:
 * Input: nums = [], target = 0
 * Output: 0
 * Example 3:
 * Input: nums = [0], target = 0
 * Output: 0
 */
public class _259_3SumSmaller {

    public static void main(String[] args) {
        int[] nums = {-2, 0, 1, 3};
        System.out.println(threeSumSmaller(nums, 2));
    }

    public static int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int count= 0;
        for (int i = 0; i < nums.length-2; i++) {
            count += findSmallSum(nums, i+1,  target-nums[i]);
        }

        return count;
    }

    private static int findSmallSum(int[] nums, int i, int target) {
        int first = i;
        int second = nums.length-1;
        int count = 0;
        while(first<second){
            if(nums[first]+ nums[second]< target){
                count += second - first;
                first++;
            }else{
                second--;
            }
        }
        return count;
    }
}
