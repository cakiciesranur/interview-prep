package examples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.

2 <= nums.length <= 103
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.
* */
public class SumofArray {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 10;

        //int result = arraySum(nums);
        //System.out.println(result);
    }

    public static int arraySum(List<Integer> numbers) {
        // Write your code here
        return numbers.stream()
                .mapToInt(a -> a)
                .sum();


    }

}
