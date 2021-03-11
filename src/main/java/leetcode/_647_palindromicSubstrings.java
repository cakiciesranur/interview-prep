package leetcode;

/**
 * Given a string, your task is to count how many palindromic substrings in this string.
 * The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.
 * Example 1:
 * Input: "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 * Example 2:
 * Input: "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 */
public class _647_palindromicSubstrings {
    /**
     * Time Complexity: O(N^2) for input string of length NN. The total time taken in this approach is dictated by two variables:
     * The number of possible palindromic centers we process.
     * How much time we spend processing each center.
     * The number of possible palindromic centers is 2N-1: there are N single character centers and N-1 consecutive character pairs as centers.
     * Each center can potentially expand to the length of the string, so time spent on each center is linear on average.
     * Thus total time spent is N⋅(2N−1)≃N
     * Space Complexity: O(1). We don't need to allocate any extra space since we are repeatedly iterating on the input string itself.
     */
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            ans += expandAroundCenter(s, i, i);
            ans += expandAroundCenter(s, i, i + 1);
        }

        return ans;
    }

    private int expandAroundCenter(String s, int start, int end) {
        int ans = 0;

        while (start >= 0 && end < s.length()) {
            if (s.charAt(start) != s.charAt(end)) break;
            end++;
            start--;
            ans++;
        }
        return ans;
    }
}
