package examples;

/**Zalando
 * You are given a string consisting of digits. Find biggest two that is a consistent fragment of the given string. For example, two-digit consistent fragments of "50552" are ["50" "55", "52"), representing the numbers (50, 5, 55, 52). The biggest among them is 55. Write a function: class Solution { public int solution (String s); } that, given a string S consisting of digits, returns the maximum two value that is a consistent fragment of S. Examples: 1. Given S="50552", your function should return 55. 2. Given S="10101", your function should return 10. 3. Given S="88", your function should return 88
 */
public class TwoDigits {
    public static void main(String[] args) {
        System.out.println(solution("50552"));

    }

    public static int solution(String S) {
        // write your code in Java SE 8

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < S.length() - 1; i++) {
            String curr = S.substring(i, i + 2);
            if (Integer.parseInt(curr) > max) {
                max = Integer.parseInt(curr);
            }
        }
        return max;
    }
}
