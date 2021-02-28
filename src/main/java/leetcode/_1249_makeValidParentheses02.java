package leetcode;

import java.util.Stack;

/**
 * Given a string s of '(' , ')' and lowercase English characters.
 * Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.
 * Formally, a parentheses string is valid if and only if:
 * It is the empty string, contains only lowercase characters, or
 * It can be written as AB (A concatenated with B), where A and B are valid strings, or
 * It can be written as (A), where A is a valid string.
 * Example 1:
 * Input: s = "lee(t(c)o)de)"
 * Output: "lee(t(c)o)de"
 * Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
 * Example 2:
 * Input: s = "a)b(c)d"
 * Output: "ab(c)d"
 * Example 3:
 * Input: s = "))(("
 * Output: ""
 * Explanation: An empty string is also valid.
 * Example 4:
 * Input: s = "(a(b(c)d)"
 * Output: "a(b(c)d)"
 */
public class _1249_makeValidParentheses02 {
    public static void main(String[] args) {
        String s = "lee(t(c)o)de)";
        System.out.println(minRemoveToMakeValidWithSb(s));
        String s1 = "a)b(c)d";
        System.out.println(minRemoveToMakeValidWithSb(s1));
        String s2 = "))((";
        System.out.println(minRemoveToMakeValidWithSb(s2));
    }

    /*Time Limit Exceeded*/
    public static String minRemoveToMakeValidWithSb(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder(n);
        boolean[] remove = new boolean[n];
        int open = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                open++;
            } else if (s.charAt(i) == ')') {
                if (open > 0) {
                    open--;
                } else {
                    remove[i] = true;
                }
            }
        }

        int close = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') {
                close++;
            } else if (s.charAt(i) == '(') {
                if (close > 0) {
                    close--;
                } else {
                    remove[i] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (!remove[i]) sb.append(s.charAt(i));
        }

        return sb.toString();
    }


}
