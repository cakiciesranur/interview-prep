package leetcode;

/**
 * Write a program to find the n-th ugly number.
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 * Example:
 * Input: n = 10
 * Output: 12
 * Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 * Note:
 * 1 is typically treated as an ugly number.
 * n does not exceed 1690.
 */
public class _264_uglyNumbersII {

    //for some cases Time Limit Exceeded example :1352 so check solution 02
    public static int nthUglyNumber(int n) {
        int i = 1;
        int count = 1; //ugly number count

        while (n > count) {
            i++;
            if (isUgly(i) == 1) {
                count++;
            }
        }

        return i;
    }

    static int isUgly(int n) {
        n = maxDivide(n, 2);
        n = maxDivide(n, 3);
        n = maxDivide(n, 5);

        return n == 1 ? 1 : 0;
    }

    /*This function divides a by greatest
    divisible power of b*/
    static int maxDivide(int a, int b) {
        while (a % b == 0) {
            a = a / b;
        }

        return a;
    }
}
