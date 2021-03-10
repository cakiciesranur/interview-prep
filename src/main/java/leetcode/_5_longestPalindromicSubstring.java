package leetcode;

/**
 * Given a string s, return the longest palindromic substring in s.
 * Example 1:
 * Input: s = "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 * Input: s = "cbbd"
 * Output: "bb"
 * Example 3:
 * Input: s = "a"
 * Output: "a"
 * Example 4:
 * Input: s = "ac"
 * Output: "a"
 */
public class _5_longestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("aacabdkacaa"));
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("ac"));
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left;
        int R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}