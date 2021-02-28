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
public class GetTargetFromArray {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 10;

        int[] result = twoSum(nums, target);
        System.out.println(result[0] + " " + result[1]);
    }

    public static int[] twoSum(int[] nums, int target) {

        int[] result = new int[2];
        List<Integer> list = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toList());

        for (int i = 0; i < list.size(); i++) {
            int remaining = target - list.get(i);
            result[0] = i;
            if (list.contains(remaining) && list.indexOf(remaining) != i) {
                result[1] = list.indexOf(remaining);
                break;
            }
        }
        return result;
    }

}
