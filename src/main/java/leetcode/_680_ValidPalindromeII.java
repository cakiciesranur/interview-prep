package leetcode;

/**
 * FACEBOOK
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
 * Example 1:
 * Input: "aba"
 * Output: True
 * Example 2:
 * Input: "abca"
 * Output: True
 * Explanation: You could delete the character 'c'.
 * The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
 */
public class _680_ValidPalindromeII {

    //Brute Force Time Limit Exceeded
    //Time Complexity: O(N^2) where NN is the length of the string. We do the following N times: create a string of length N and iterate over it.
    //Space Complexity: O(N), the space used by our candidate answer.
    public boolean validPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < s.length(); i++) {
            char c = sb.charAt(i);
            sb.deleteCharAt(i);
            if (isPalindrome(sb)) {
                return true;
            }
            sb.insert(i, c);
        }
        return false;
    }

    private boolean isPalindrome(StringBuilder s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
