package examples;

import java.util.*;

/*Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.

2 <= nums.length <= 103
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.
* */
public class OptimizingBoxWeights {
    public static void main(String[] args) {
        List<Integer> nums1 = Arrays.asList(100, 20, 25);
        List<Integer> nums2 = Arrays.asList(10, 30, 20, 5, 4, 40);
        List<Integer> nums3 = Arrays.asList(3,7,5,6,2);
        List<Integer> nums4 = Arrays.asList(6,5,3,2,4,1,2);
        List<Integer> nums5 = Arrays.asList(100, 20, 25, 1, 2);

        System.out.println(minimalHeaviestSetA(nums1));
        System.out.println(minimalHeaviestSetA(nums2));
        System.out.println(minimalHeaviestSetA(nums3));
        System.out.println(minimalHeaviestSetA(nums4));
    }

    public static List<Integer> minimalHeaviestSetA(List<Integer> arr) {
        List<Integer> result = new ArrayList<>();
        Collections.sort(arr);
        Collections.reverse(arr); // descending order
        int sumOfItems = arr.stream().mapToInt(a -> a).sum();
        int sumOfA = 0;
        int index = 0;
        for (int i = 0; i < arr.size(); i++) {
            sumOfA = sumOfA + arr.get(i);
            int sumOfB = sumOfItems - sumOfA;
            if (sumOfA > sumOfB) {
                index = i;
                break;
            }
        }

        for (int a = 0; a <= index; a++) {
            result.add(arr.get(a));
        }

        return result;

    }

}
