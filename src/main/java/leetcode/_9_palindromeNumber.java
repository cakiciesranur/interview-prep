package leetcode;

/**
 * Given an integer x, return true if x is palindrome integer.
 * An integer is a palindrome when it reads the same backward as forward. For example, 121 is palindrome while 123 is not.
 * Example 1:
 * Input: x = 121
 * Output: true
 * Example 2:
 * Input: x = -121
 * Output: false
 */
public class _9_palindromeNumber {
    public boolean isPalindrome(int x) {
        String intStr = String.valueOf(x);
        return intStr.equals(new StringBuilder(x).reverse().toString());
    }
}
