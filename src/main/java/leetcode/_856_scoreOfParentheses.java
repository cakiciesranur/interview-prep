package leetcode;

import java.util.Stack;

/**
 * Given a balanced parentheses string S, compute the score of the string based on the following rule:
 * () has score 1
 * AB has score A + B, where A and B are balanced parentheses strings.
 * (A) has score 2 * A, where A is a balanced parentheses string.
 * Example 1:
 * Input: "()"
 * Output: 1
 * Example 2:
 * Input: "(())"
 * Output: 2
 * Example 3:
 * Input: "()()"
 * Output: 2
 * Example 4:
 * Input: "(()(()))"
 * Output: 6
 */
public class _856_scoreOfParentheses {
    public static void main(String[] args) {

        String s = "(()())";
        System.out.println(scoreOfParentheses(s));
    }

    //time : O(n)
    //space : O(n/2) =O(n)
    public static int scoreOfParentheses(String S) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (char c : S.toCharArray()) {
            if (c == '(') {
                stack.push(0);
            } else {
                int v = stack.pop();
                int w = stack.pop();

                stack.push(w + Math.max(2 * v, 1));
            }
        }

        return stack.pop();
    }
}
