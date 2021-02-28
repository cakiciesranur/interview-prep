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
public class _1249_makeValidParentheses {
    public static void main(String[] args) {
        String s = "lee(t(c)o)de)";
        System.out.println(minRemoveToMakeValidWithStack(s));
        String s1 = "a)b(c)d";
        System.out.println(minRemoveToMakeValidWithStack(s1));
        String s2 = "))((";
        System.out.println(minRemoveToMakeValidWithStack(s2));
    }

    /*Time Limit Exceeded*/
    public static String minRemoveToMakeValidWithStack(String s) {
        Stack<Integer> indexes = new Stack<>();
        StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < sb.length(); ++i) {
            if (sb.charAt(i) == '(') {
                indexes.push(i);
            }
            if (sb.charAt(i) == ')') {
                if (!indexes.isEmpty()) {
                    indexes.pop();
                }else{
                    sb.setCharAt(i, '*');
                }
            }
        }

        while (!indexes.isEmpty()) {
            sb.setCharAt(indexes.pop(), '*');
        }

        return sb.toString().replaceAll("\\*","");
    }


}
