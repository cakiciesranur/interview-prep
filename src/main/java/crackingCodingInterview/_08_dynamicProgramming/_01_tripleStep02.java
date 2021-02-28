package crackingCodingInterview._08_dynamicProgramming;

import java.util.Arrays;

/**
 * A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3
 * steps at a time. Implement a method to count how many possible ways the child can run up the
 * stairs.
 */
public class _01_tripleStep02 {

    public static void main(String[] args) {
        System.out.println(countWays(3));//"1,1,1", "1,2", "3", 2,1"
    }

    //memorization solution
    static int countWays(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return countWays(n, memo);
    }

    private static int countWays(int n, int[] memo) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        } else if (memo[n] > -1) {
            return memo[n];
        }
        memo[n] = countWays(n - 1, memo) + countWays(n - 2, memo) + countWays(n - 3, memo);
        return memo[n];
    }
}
