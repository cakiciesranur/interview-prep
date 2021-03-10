package leetcode;

import java.util.HashMap;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer.
 * Example 1:
 * Input: s = "III"
 * Output: 3
 */
public class _13_romanToInteger {
    static HashMap<String, Integer> values = new HashMap<>();

    static {
        values.put("M", 1000);
        values.put("D", 500);
        values.put("C", 100);
        values.put("L", 50);
        values.put("X", 10);
        values.put("V", 5);
        values.put("I", 1);
    }

    //Left-to-Right Pass
    //Time complexity : O(1)
    //Space complexity : O(1). Because only a constant number of single-value variables are used, the space complexity is O(1)O(1).
    public int romanToInt(String s) {
        int sum = 0;
        int i = 0;

        while (i < s.length()) {
            String currentSymbol = s.substring(i, i + 1);
            int currentValue = values.get(currentSymbol);

            int nextValue = 0;

            if (i + 1 < s.length()) {
                String nextSymbol = s.substring(i + 1, 1 + 2);
                nextValue = values.get(nextSymbol);
            }

            if (nextValue > currentValue) {
                sum += nextValue - currentValue;
                i += 2;
            } else {
                sum += currentValue;
                i += 1;
            }
        }
        return sum;
    }
}
