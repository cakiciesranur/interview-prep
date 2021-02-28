package leetcode;

import java.util.Stack;

/**
 * A valid parentheses string is either empty (""), "(" + A + ")", or A + B, where A and B are valid parentheses strings, and + represents string concatenation.  For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.
 * A valid parentheses string S is primitive if it is nonempty, and there does not exist a way to split it into S = A+B, with A and B nonempty valid parentheses strings.
 * Given a valid parentheses string S, consider its primitive decomposition: S = P_1 + P_2 + ... + P_k, where P_i are primitive valid parentheses strings.
 * Return S after removing the outermost parentheses of every primitive string in the primitive decomposition of S.
 * <p>
 * Input: "(()())(())"
 * Output: "()()()"
 * Explanation:
 * The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
 * After removing outer parentheses of each part, this is "()()" + "()" = "()()()".
 */
public class _1021_removeOutermostParentheses02 {
    public static void main(String[] args) {
        String s1 = "(()())(())"; //result = "()()()"
        String s2 = "(()())(())(()(()))"; //result "()()()()(())"
        String s3 = "(()())(())(()())";

        System.out.println(removeOuterParentheses(s1));
        System.out.println(removeOuterParentheses(s2));
        System.out.println(removeOuterParentheses(s3));
    }

    //with stack and string builder
    public static String removeOuterParentheses(String S) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int start = 0;

        for (char c : S.toCharArray()) {
            sb.append(c);
            if (!stack.isEmpty() && stack.peek() == '(' && c == ')') {
                stack.pop();
            } else {
                stack.push(c);
            }

            if (stack.isEmpty()) {
                // we found primitive pair
                sb.deleteCharAt(start);
                sb.deleteCharAt(sb.length() - 1);
                start = sb.length();
            }
        }
        return sb.toString();
    }
}
