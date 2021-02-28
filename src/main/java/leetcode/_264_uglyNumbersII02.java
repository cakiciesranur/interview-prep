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
public class _264_uglyNumbersII02 {

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(15));
    }


    //Time Complexity: O(n)
    //Auxiliary Space: O(n)
    //look for explanation https://www.geeksforgeeks.org/ugly-numbers/
    //with Dynamic Programming
    public static int nthUglyNumber(int n) {
        UglyNumber uglyNumber = new UglyNumber();
        return uglyNumber.getNthUglyNo(n);
    }
}

class UglyNumber {
    int getNthUglyNo(int n) {
        int[] ugly = new int[n];

        int nextUglyNo = 1, i2 = 0, i3 = 0, i5 = 0;
        ugly[0] = nextUglyNo;

        int nexMultipleOf2 = ugly[i2] * 2;
        int nextMultipleOf3 = ugly[i3] * 3;
        int nextMultipleOf5 = ugly[i5] * 5;

        for (int i = 1; i < n; i++) {
            nextUglyNo = Math.min(Math.min(nexMultipleOf2, nextMultipleOf3), nextMultipleOf5);

            ugly[i] = nextUglyNo;
            if (nextUglyNo == nexMultipleOf2) {
                i2++;
                nexMultipleOf2 = ugly[i2] * 2;
            }
            if (nextUglyNo == nextMultipleOf3) {
                i3++;
                nextMultipleOf3 = ugly[i3] * 3;
            }
            if (nextUglyNo == nextMultipleOf5) {
                i5++;
                nextMultipleOf5 = ugly[i5] * 5;
            }
        }
        return nextUglyNo;
    }

}
