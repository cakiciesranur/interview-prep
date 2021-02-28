package crackingCodingInterview._01arraysAndStrings;

import java.util.Arrays;

/**
 * Given two strings, write a method to decide if one is a permutation of the
 * other.
 */
public class _02_checkPermutationOfStrings {
    public static void main(String[] args) {

        System.out.println(checkPermutation("aabdb", "aabbd"));
        System.out.println(checkPermutation("aabdb", "aabcd"));
    }

    private static boolean checkPermutation(String str, String ans) {
        if (str.length() != ans.length()) {
            return false;
        }
        if (sort(str).equals(sort(ans))) {
            return true;
        }

        return false;

    }

    private static String sort(String str) {
        char[] content = str.toCharArray();
        Arrays.sort(content);
        return new String(content);

    }


}
