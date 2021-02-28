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
public class _844_backspaceString {
    /**
     * Time Complexity: O(M + N)O(M+N), where M, NM,N are the lengths of S and T respectively.
     * Space Complexity: O(M + N)O(M+N).
     */
    public static boolean backspaceCompare(String S, String T) {
        String s1 = getText(S);
        String s2 = getText(T);
        return s1.equalsIgnoreCase(s2);
    }

    private static String getText(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c != '#')
                stack.push(c);
            else if (!stack.empty())
                stack.pop();
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }
}