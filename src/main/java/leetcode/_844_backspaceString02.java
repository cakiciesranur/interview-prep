package leetcode;

import java.util.Stack;

/**
 * Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.
 * Note that after backspacing an empty text, the text will continue empty.
 * Input: S = "ab#c", T = "ad#c"
 * Output: true
 * Explanation: Both S and T become "ac".
 * <p>
 * Example 2:
 * Input: S = "ab##", T = "c#d#"
 * Output: true
 * Explanation: Both S and T become "".
 * <p>
 * Example 3:
 * Input: S = "a##c", T = "#a#c"
 * Output: true
 * Explanation: Both S and T become "c".
 * <p>
 * Example 4:
 * Input: S = "a#c", T = "b"
 * Output: false
 * Explanation: S becomes "c" while T becomes "b".
 */
public class _844_backspaceString02 {

    public static boolean backspaceCompare(String S, String T) {
        String s1 = getText(S);
        String s2 = getText(T);
        return s1.equalsIgnoreCase(s2);
    }

    private static String getText(String s) {
        StringBuilder sb = new StringBuilder();
        int index= 0;
        for (char c : s.toCharArray()) {
            if (c != '#') {
                sb.append(c);
                index++;
            }
            else if (!sb.toString().isEmpty()){
                sb.deleteCharAt(index-1);
                index--;
            }
        }
        return sb.toString();
    }
}