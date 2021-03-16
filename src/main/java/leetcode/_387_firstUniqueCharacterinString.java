package leetcode;

import java.util.HashMap;

/**
 * Given a string, find the first non-repeating character in it and return its index. If it doesn't exist, return -1.
 * Examples:
 * s = "leetcode"
 * return 0.
 * s = "loveleetcode"
 * return 2.
 * Note: You may assume the string contains only lowercase English letters.
 */
public class _387_firstUniqueCharacterinString {
    //Time complexity : O(N) since we go through the string of length N two times.
    //Space complexity : O(1) because English alphabet contains 26 letters.
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }
}
