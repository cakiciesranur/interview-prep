package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 * Example 1:
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * Example 2:
 * Input: digits = ""
 * Output: []
 * Example 3:
 * Input: digits = "2"
 * Output: ["a","b","c"]
 * Constraints:
 * 0 <= digits.length <= 4
 * digits[i] is a digit in the range ['2', '9'].
 */
public class _17_letterCombinationsofPhoneNumber {
    public static List<String> letterCombinationsWithMap(String digits) {
        Map<Character, String> phone = new HashMap<>();
        phone.put('2', "abc");
        phone.put('3', "def");
        phone.put('4', "ghi");
        phone.put('5', "jkl");
        phone.put('6', "mno");
        phone.put('7', "pqrs");
        phone.put('8', "tuv");
        phone.put('9', "wxyz");

        List<String> result = new ArrayList<>();

        if (digits.length() == 0) return result;
        result.add("");

        for (int i = 0; i < digits.length(); i++) {
            result = combine(phone.get(digits.charAt(i)), result);
        }
        return result;
    }

    public static List<String> letterCombinationsWithArray(String digits) {
        String digitLetter[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> result = new ArrayList<>();

        if (digits.length() == 0) return result;

        result.add("");
        for (int i = 0; i < digits.length(); i++)
        /**Why is 0 being subtracted here?
         digits.charAt(i)-'0'
         the ASCII value of 0 is 48 and the ASCII values of digits (1-9) are 49 - 57,
         so subtracting the digits ASCII value from 0's ASCII value will give the value of the digit as an integer*/
            result = combine(digitLetter[digits.charAt(i) - '0'], result);

        return result;
    }

    private static List<String> combine(String digit, List<String> list) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < digit.length(); i++) {
            for (String s : list) {
                result.add(s + digit.charAt(i));
            }
        }
        return result;
    }
}
