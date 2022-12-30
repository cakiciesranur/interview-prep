package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * You are given two strings s1 and s2 of equal length. A string swap is an operation where you choose two indices in a string (not necessarily different) and swap the characters at these indices.
 * Return true if it is possible to make both strings equal by performing at most one string swap on exactly one of the strings. Otherwise, return false.
 * Example 1:
 * <p>
 * Input: s1 = "bank", s2 = "kanb"
 * Output: true
 * Explanation: For example, swap the first character with the last character of s2 to make "bank".
 * Example 2:
 * <p>
 * Input: s1 = "attack", s2 = "defend"
 * Output: false
 * Explanation: It is impossible to make them equal with one string swap.
 * Example 3:
 * <p>
 * Input: s1 = "kelb", s2 = "kelb"
 * Output: true
 * Explanation: The two strings are already equal, so no string swap operation is required.
 */
public class _1790_equalStringsBySwap {
    public static void main(String[] args) {
        List<List<String>> testList = new ArrayList<>();
        testList.add(Arrays.asList("kelb", "kelb"));
        testList.add(Arrays.asList("attack", "defend"));
        testList.add(Arrays.asList("bank", "kanb"));

        testList.forEach(item -> System.out.printf("s1:%s, s2: %s -> %b%n", item.get(0), item.get(1), areAlmostEqual(item.get(0), item.get(1))));
    }

    private static boolean areAlmostEqual(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        List<Integer> differenceList = new ArrayList<>();
        if (s1.equals(s2)) {
            return true;
        } else {
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    differenceList.add(i);
                }
                if (differenceList.size() > 2) {
                    return false;
                }
            }

            return differenceList.size() == 0
                    || (differenceList.size() == 2
                    && s1.charAt(differenceList.get(0)) == s2.charAt(differenceList.get(1))
                    && s1.charAt(differenceList.get(1)) == s2.charAt(differenceList.get(0)));

        }
    }
}
