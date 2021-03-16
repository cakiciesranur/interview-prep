package leetcode;
/*Goldman sachs and amazon*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Given a list of the scores of different students, items, where items[i] = [IDi, scorei] represents one score from a student with IDi, calculate each student's top five average.
 * Return the answer as an array of pairs result, where result[j] = [IDj, topFiveAveragej] represents the student with IDj and their top five average. Sort result by IDj in increasing order.
 * A student's top five average is calculated by taking the sum of their top five scores and dividing it by 5 using integer division.
 * Example 1:
 * Input: items = [[1,91],[1,92],[2,93],[2,97],[1,60],[2,77],[1,65],[1,87],[1,100],[2,100],[2,76]]
 * Output: [[1,87],[2,88]]
 * Explanation:
 * The student with ID = 1 got scores 91, 92, 60, 65, 87, and 100. Their top five average is (100 + 92 + 91 + 87 + 65) / 5 = 87.
 * The student with ID = 2 got scores 93, 97, 77, 100, and 76. Their top five average is (100 + 97 + 93 + 77 + 76) / 5 = 88.6, but with integer division their average converts to 88.
 * Example 2:
 * Input: items = [[1,100],[7,100],[1,100],[7,100],[1,100],[7,100],[1,100],[7,100],[1,100],[7,100]]
 * Output: [[1,100],[7,100]]
 */
public class _1086_highFive04 {
    /**
     * Time Complexity: Assuming N is the total number of items, sorting the items takes O(NlogN) time and
     * traversing the sorted array takes O(N) time. Hence the overall time complexity of this approach is O(NlogN).
     * Space Complexity: O(N), the space used by solution.
     */
    private int K;

    public int[][] highFive(int[][] items) {
        this.K = 5;
        Arrays.sort(
                items,
                (a, b) -> {
                    if (a[0] != b[0])
                        // item with lower id goes first
                        return a[0] - b[0];
                    // in case of tie for ids, item with higher score goes first
                    return b[1] - a[1];
                });
        List<int[]> solution = new ArrayList<>();
        int n = items.length;
        int i = 0;
        while (i < n) {
            int id = items[i][0];
            int sum = 0;
            // obtain total using the top 5 scores
            for (int k = i; k < i + this.K; ++k)
                sum += items[k][1];
            // ignore all the other scores for the same id
            while (i < n && items[i][0] == id)
                i++;
            solution.add(new int[]{id, sum / this.K});
        }
        int[][] solutionArray = new int[solution.size()][];
        return solution.toArray(solutionArray);
    }
}
