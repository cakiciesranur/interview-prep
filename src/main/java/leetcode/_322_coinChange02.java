package leetcode;

import java.util.*;
import java.util.stream.Collectors;

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
public class _322_coinChange02 {
    public static void main(String[] args) {
        int[] coins = new int[] {2};
        int amount = 3;
        System.out.println(coinChange(coins, amount));
    }
    public static int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        Arrays.sort(coins);
        Set<Integer> coinSet = Arrays.stream(coins).boxed().collect(Collectors.toSet());
        int coin = getMaxCoinForAmount(coinSet, amount);
        if (coin == -1) {
            return -1;
        }
        int minCoinCount = getMinCoinCount(coin, new HashSet<>(coinSet), amount, 0);
        while (minCoinCount == Integer.MAX_VALUE && !coinSet.isEmpty()) {
            coinSet.remove(coin);
            coin = getMaxCoinForAmount(coinSet, amount);
            minCoinCount = getMinCoinCount(coin, new HashSet<>(coinSet), amount, 0);
        }
        if (minCoinCount == Integer.MAX_VALUE) {
            return -1;
        }
        return minCoinCount;
    }
    private static int getMinCoinCount(int coin, HashSet<Integer> coinSet, int amount, int counter) {
        while (coin <= amount) {
            amount -= coin;
            counter++;
        }
        if (amount == 0) {
            return counter;
        } else if (amount < 0) {
            return Integer.MAX_VALUE;
        } else {
            coinSet.remove(coin);
            int nextCoin = getMaxCoinForAmount(coinSet, amount);
            if (nextCoin == -1) {
                return -1;
            }
            return getMinCoinCount(nextCoin, coinSet, amount, counter);
        }
    }
    private static int getMaxCoinForAmount(Set<Integer> coinSet, int amount) {
        int maxCoin = -1;
        return coinSet.stream().filter(a -> a <= amount).max(Comparator.comparingInt(a -> a)).orElse(-1);
    /*for (Integer integer : coinSet) {
        if (integer <= amount) {
            maxCoin = Math.max(maxCoin, integer);
        }
    }
    return maxCoin;*/
    }
}
