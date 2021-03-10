package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 * Example 1:
 * Input: x = 123
 * Output: 321
 * Example 2:
 * Input: x = -123
 * Output: -321
 */
public class _7_reverseInteger {
    public int reverse(int x) {
        Queue<Integer> queue = new LinkedList<>();

        int num = Math.abs(x);

        while (num > 0) {
            int curr = num % 10;
            queue.add(curr);
            num = num / 10;
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            sb.append(queue.remove());
        }
        int res = Integer.valueOf(sb.toString());
        if (x < 0) {
            res = res * -1;
        }


        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
            return 0;
        }

        return res;

    }
}