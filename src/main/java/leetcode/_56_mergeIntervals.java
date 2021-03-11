package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

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
        int[][] input2 = new int[][]{{1, 4}, {2, 3}};
        merge(input);
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 1) {
            return intervals;
        }
        //Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));
        //Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[1]));
        Arrays.sort(intervals, Comparator.<int[]>comparingInt(a -> a[0]).thenComparingInt(a -> a[1]));

        List<int[]> res = new ArrayList<>();
        res.add(new int[]{intervals[0][0], intervals[0][1]});
        int listCursor = 0;

        for (int i = 1; i < intervals.length; i++) {
            int[] prev = res.get(listCursor);

            if (prev[1] >= intervals[i][0]) {
                prev[0] = Math.min(intervals[i][0], prev[0]);
                prev[1] = Math.max(intervals[i][1], prev[1]);
            } else {
                res.add(intervals[i]);
                listCursor++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}