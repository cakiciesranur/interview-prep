package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 * Example 1:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * Example 4:
 * Input: s = ""
 * Output: 0
 */
public class _3_longestSubstring {
    //sliding Window Approach
    //Time complexity : O(2n)=O(n). In the worst case each character will be visited twice by i and j.
    //
    //Space complexity : O(min(m, n)). Same as the previous approach. We need O(k)space for the sliding window,
    // where kk is the size of the Set. The size of the Set is upper bounded by the size of the string nn and the size of the charset/alphabet mm.
    public int lengthOfLongestSubstring(String s) {
        int first = 0, second = 0, max = 0;

        Set<Character> exist = new HashSet<>();

        while (second < s.length()) {
            if (!exist.contains(s.charAt(second))) {
                exist.add(s.charAt(second));
                max = Math.max(exist.size(), max);
                second++;
            } else {
                exist.remove(s.charAt(first));
                first++;
            }
        }
        return max;
    }
}
