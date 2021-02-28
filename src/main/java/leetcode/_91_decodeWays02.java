package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * A message containing letters from A-Z can be encoded into numbers using the following mapping:
 * 'A' -> "1"
 * 'B' -> "2"
 * ...
 * 'Z' -> "26"
 * To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the mapping above (there may be multiple ways). For example, "11106" can be mapped into:
 * "AAJF" with the grouping (1 1 10 6)
 * "KJF" with the grouping (11 10 6)
 * Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".
 * Given a string s containing only digits, return the number of ways to decode it.
 * The answer is guaranteed to fit in a 32-bit integer.
 * Example 1:
 * Input: s = "12"
 * Output: 2
 * Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).
 * Example 2:
 * Input: s = "226"
 * Output: 3
 * Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 */
public class _91_decodeWays02 {
    //Time Complexity: O(N), where NN is length of the string. We iterate the length of dp array which is N+1N+1.
    //Space Complexity: O(N). The length of the DP array.
    public int numDecodingsWithDynamicProgramming(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i < dp.length; i++) {

            if (s.charAt(i - 1) != '0') {
                dp[i] = dp[i - 1];
            }

            int twoDigits = Integer.parseInt(s.substring(i - 2, i));

            if (twoDigits >= 10 && twoDigits <= 26) {
                dp[i] = dp[i] + dp[i - 2];
            }

        }
        return dp[s.length()];
    }
}
