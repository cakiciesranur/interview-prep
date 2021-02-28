package leetcode;

/**
 * Write a program to check whether a given number is an ugly number.
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 * 1 is typically treated as an ugly number.
 * Input is within the 32-bit signed integer range: [−231,  231 − 1].
 */
public class _263_uglyNumbersI {

    public static void main(String[] args) {
        System.out.println(isUgly(24));
        System.out.println(isUgly(14));
    }

    public static boolean isUgly(int num) {
        if(num == 0){
            return false;
        }

        if(num ==1){
            return true;
        }

        while (num % 2 == 0) {
            num = num / 2;
        }
        while (num % 3 == 0) {
            num = num / 3;
        }
        while (num % 5 == 0) {
            num = num / 5;
        }

        if (num == 1) {
            return true;
        }

        return false;
    }
}

