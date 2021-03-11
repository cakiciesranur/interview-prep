package leetcode;

/**
 * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 * Example:
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.
 * Note: Please solve it without division and in O(n).
 * Follow up:
 * Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
 */
public class _238_productofArrayExceptSelf {
    public static void main(String[] args) {
        productExceptSelf(new int[]{4, 5, 1, 8, 2});
    }

    /**
     * Time complexity : O(N) where NN represents the number of elements in the input array. We use one iteration to construct the array L,
     * one to construct the array RR and one last to construct the answer array using L and R.
     * Space complexity : O(N) used up by the two intermediate arrays that we constructed to keep track of product of elements to the left and right.
     */
    public static int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] R = new int[length];
        int[] L = new int[length];
        int[] answer = new int[length];

        L[0] = 1;
        for (int i = 1; i < length; i++) {
            L[i] = nums[i - 1] * L[i - 1];
        }

        R[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            R[i] = nums[i + 1] * R[i + 1];
        }
        // Constructing the answer array
        for (int i = 0; i < length; i++) {
            // For the first element, R[i] would be product except self
            // For the last element of the array, product except self would be L[i]
            // Else, multiple product of all elements to the left and to the right
            answer[i] = L[i] * R[i];
        }
        return answer;
    }
}
