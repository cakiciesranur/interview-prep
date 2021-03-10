package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 * Example 1:
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 * Example 2:
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 */
public class _4_medianofTwoSortedArrays {
    public static void main(String[] args) {

        int[] arr = new int[]{1,2};
        int[] arr1 = new int[]{3, 4};

        System.out.println(findMedianSortedArrays(arr, arr1));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> list = Arrays.stream(nums1).boxed().collect(Collectors.toList());
        list.addAll(Arrays.stream(nums2).boxed().collect(Collectors.toList()));
        Collections.sort(list);

        double result;
        int index = (list.size() / 2);
        if (list.size() % 2 == 0) {
            result = (double)(list.get(index) + list.get(index - 1)) / 2;
        } else {
            result = list.get(index);
        }

        return result;


    }
}
