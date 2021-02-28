package crackingCodingInterview._01arraysAndStrings;

import java.util.HashMap;

/**
 * Palindrome Permutation: Given a string, write a function to check if it is a permutation of a palindrome.
 * A palindrome is a word or phrase that is the same forwards and backwards. A permutation
 * is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.
 * EXAMPLE
 * Input: Tact Coa
 * Output: True (permutations: "taco cat", "atco eta", etc.)
 */
public class _04_palindromePermutation {

    public static void main(String[] args) {

        System.out.println(hasPermutationOfPalindrome("Tact Coa"));
    }

    private static boolean hasPermutationOfPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = s.toLowerCase().toCharArray();

        for (char c : chars) {
            if (c == ' ') {
                continue;
            }
            if (!map.containsKey(c)) {
                map.put(c, 0);
            }
            map.put(c, map.get(c) + 1);
        }

        int numberOfOdd = 0;
        for (Integer count : map.values()) {
            if (count % 2 != 0) {
                numberOfOdd++;
            }

            if (numberOfOdd > 1) {
                return false;
            }
        }

        return true;
    }

}
