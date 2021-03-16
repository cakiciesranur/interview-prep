package leetcode;

import java.util.Arrays;

/**
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 * You may assume that you have an infinite number of each kind of coin.
 * Example 1:
 * Input: coins = [1,2,5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 * Input: coins = [2], amount = 3
 * Output: -1
 * Example 3:
 * Input: coins = [1], amount = 0
 * Output: 0
 * Example 4:
 * Input: coins = [1], amount = 1
 * Output: 1
 * Example 5:
 * Input: coins = [1], amount = 2
 * Output: 2
 */
public class _322_coinChange {
    public static void main(String[] args) {
        //int[] input = new int[]{1, 2, 5};
        int[] input = new int[]{186, 419, 83, 408};
        System.out.println(coinChange(input, 6249));
    }

    public static int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[max];
        Arrays.fill(dp, max);
        dp[0] = 0;

        for (int i = 0; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    int remain = amount - coins[j];
                    dp[i] = Math.min(dp[i], dp[remain + 1]);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
