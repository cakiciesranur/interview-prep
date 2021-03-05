package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
 * Example 1:
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */
public class _56_mergeIntervals {
    public static void main(String[] args) {
        int[][] input = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 48}};
        System.out.println(merge(input));
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 1) {
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));
        int start = 0;
        int end = 0;

        int[][] res = new int[intervals.length][2];
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][0] <= intervals[i + 1][0] && intervals[i][1] >= intervals[i + 1][0]) {
                start = intervals[i][0];
                end = intervals[i + 1][1];
            } else {
                start = intervals[i][0];
                end = intervals[i][1];
            }
            res[i][0] = start;
            res[i][1] = end;

        }
        return res;
    }
}
