package leetcode;

/**
 * Given four integers n, a, b, and c, return the nth ugly number.
 * Ugly numbers are positive integers that are divisible by a, b, or c.
 * Example 1:
 * Input: n = 3, a = 2, b = 3, c = 5
 * Output: 4
 * Explanation: The ugly numbers are 2, 3, 4, 5, 6, 8, 9, 10... The 3rd is 4.
 * Example 2:
 * Input: n = 4, a = 2, b = 3, c = 4
 * Output: 6
 * Explanation: The ugly numbers are 2, 3, 4, 6, 8, 9, 10, 12... The 4th is 6.
 * Example 3:
 * Input: n = 5, a = 2, b = 11, c = 13
 * Output: 10
 * Explanation: The ugly numbers are 2, 4, 6, 8, 10, 11, 12, 13... The 5th is 10.
 */
public class _1201_uglyNumbersIII {

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(3, 2, 3, 5));
    }

    public static int nthUglyNumber(int n, int a, int b, int c) {
        int left = 1, right = Integer.MAX_VALUE;
        while (left < right) {
            int mid = left + (right - left >> 1);
            if (getCount(mid, a, b, c) >= n) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static long getCount(int n, int a, int b, int c) {
        return n / a + n / b + n / c - n / LCM(a, b) - n / LCM(b, c) - n / LCM(a, c) + n / LCM(a, LCM(b, c));
    }

    private static long LCM(long a, long b) {
        return a * b / GCD(a, b);
    }

    private static long GCD(long a, long b) {
        return b == 0 ? a : GCD(b, a % b);
    }
}