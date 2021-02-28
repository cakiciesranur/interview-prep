package leetcode;

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
public class _1021_removeOutermostParentheses {
    public static void main(String[] args) {
        String s1 ="(()())(())"; //result = "()()()"
        String s2 = "(()())(())(()(()))"; //result "()()()()(())"

        System.out.println(removeOuterParentheses(s1));
        System.out.println(removeOuterParentheses(s2));
    }

    //with string builder
    public static String removeOuterParentheses(String S) {
        int count = 0;
        StringBuilder sb = new StringBuilder();

        for (char c : S.toCharArray()) {
            if (c == '(') {
                if (count != 0) {
                    sb.append(c);
                }
                count++;
            }

            if (c == ')') {
                count--;
                if (count != 0) {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}
