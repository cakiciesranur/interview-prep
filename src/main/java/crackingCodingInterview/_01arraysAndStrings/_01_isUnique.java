package crackingCodingInterview._01arraysAndStrings;

import java.util.HashMap;

/**
 * Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you
 * cannot use additional data structures?
 */
public class _01_isUnique {
    public static void main(String[] args) {

        String s1 = "abcgd";
        String s2 = "abcgabbd";
        String s3 = "aaaacgd";

        System.out.println(isUnique(s1));
        System.out.println(isUnique(s2));
        System.out.println(isUnique(s3));

    }

    private static boolean isUnique(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                return false;
            }
            map.put(c, 1);
        }

        return true;

    }

    private static boolean isUniqueWithArray(String str) {
        if (str.length() > 128) return false;

        boolean[] charSet = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (charSet[val]) {//Already found this char in string
                return false;
            }
            charSet[val] = true;
        }
        return true;
    }
}
