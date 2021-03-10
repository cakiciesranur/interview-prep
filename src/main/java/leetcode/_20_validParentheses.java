package leetcode;

import java.util.HashMap;
import java.util.Stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * An input string is valid if:
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Example 1:
 * Input: s = "()"
 * Output: true
 * Example 2:
 * Input: s = "()[]{}"
 * Output: true
 * Example 3:
 * Input: s = "(]"
 * Output: false
 * Example 4:
 * Input: s = "([)]"
 * Output: false
 * Example 5:
 * Input: s = "{[]}"
 * Output: true
 */
public class _20_validParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("(){}["));
    }

    /**
     * Time complexity : O(n) because we simply traverse the given string one character at a time and push and pop operations on a stack take O(1) time.
     * Space complexity : O(n) as we push all opening brackets onto the stack and in the worst case, we will end up pushing all the brackets onto the stack. e.g. ((((((((((.
     */

    public static boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                char topElement = stack.isEmpty() ? '#' : stack.pop();

                if (topElement != map.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}
