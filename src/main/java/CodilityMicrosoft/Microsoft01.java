package CodilityMicrosoft;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * How to replace question mark from a String so that same letter does not occur next to each other?
 */
public class Microsoft01 {
    public static void main(String[] args) {
        int[] arr = new int[]{51, 71, 17, 42};
        System.out.println(solution(arr));
    }

    public static int solution(int[] A) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int total = 0;
        for (int i = 0; i < A.length; i++) {
            int curr = A[i];
            int sum = digitSum(curr);

            if (map.containsKey(sum)) {
                ArrayList<Integer> list = map.get(sum);
                list.add(curr);
                map.put(sum, list);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(curr);
                map.put(sum, list);
            }
        }

        total = getMaxSum(map);

        return total;

    }

    private static int getMaxSum(HashMap<Integer, ArrayList<Integer>> map) {
        int max = -1;
        for (Map.Entry<Integer, ArrayList<Integer>> ent : map.entrySet()) {
            if (ent.getValue().size() > 1) {
                Integer currTotal = ent.getValue().stream()
                        .reduce(0, Integer::sum);
                if (currTotal > max) {
                    max = currTotal;
                }


            }
        }

        return max;
    }

    private static int digitSum(int i) {
        int n = i;
        int result = 0;

        while (n > 0) {
            result += n % 10;
            n /= 10;

        }
        return result;
    }
}
