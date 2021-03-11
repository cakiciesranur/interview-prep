package leetcode;
/*Goldman sachs and amazon*/

import java.util.*;
import java.util.stream.Collectors;

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
public class _1086_highFive {
    public static void main(String[] args) {
        int[][] input = new int[][]{{1, 91}, {1, 92}, {2, 93}, {2, 97}, {1, 60}, {2, 77}, {1, 65}, {1, 87}, {1, 100}, {2, 100}, {2, 76}};
        System.out.println(highFive(input));
    }

    public static int[][] highFive(int[][] items) {
        HashMap<Integer, List<Integer>> map = new HashMap<>(); //id, socreList
        for (int[] item : items) {
            int id = item[0];
            int score = item[1];
            if (!map.containsKey(id)) {
                map.put(id, new ArrayList<>());
            }
            map.get(id).add(score);
        }

        int[][] ans = new int[map.size()][2]; // id, score
        int index = 0;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> scoreList = entry.getValue();
            Collections.sort(scoreList, Collections.reverseOrder());

            List<Integer> highFive = scoreList.stream().limit(5).collect(Collectors.toList());
            double scoreAvg = highFive.stream().mapToInt(val -> val).average().orElse(0.0);
            ans[index][0] = entry.getKey();
            ans[index][1] = (int) scoreAvg;
            index++;
        }

        return ans;
    }
}
