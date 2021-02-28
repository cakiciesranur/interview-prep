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
public class _91_decodeWays {
    //Time Complexity: O(N), where N is length of the string. Memoization helps in pruning the recursion tree and hence decoding for an index only once.
    // Thus this solution is linear time complexity.
    //Space Complexity: O(N) The dictionary used for memoization would take the space equal to the length of the string.
    // There would be an entry for each index value. The recursion stack would also be equal to the length of the string.

    Map<Integer, Integer> memo = new HashMap<>();

    public int numDecodingsWithRecursiveAndMemo(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        return getWays(0, s);

    }

    private int getWays(int index, String s) {
        if (memo.containsKey(index)) {
            return memo.get(index);
        }

        if (index == s.length()) {
            return 1;
        }

        if (s.charAt(index) == '0') {
            return 0;
        }

        if (index == s.length() - 1) {
            return 1;
        }

        int ans = getWays(index + 1, s);
        if (Integer.parseInt(s.substring(index, index + 2)) <= 26) {
            ans += getWays(index + 2, s);
        }

        memo.put(index, ans);

        return ans;
    }
}
