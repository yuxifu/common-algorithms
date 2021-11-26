package com.f21a.algorithm.dynamicprogramming;

import java.util.Arrays;

/*
You are given an integer array coins representing coins of different denominations
and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that
amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

Example 1:
Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1

Example 2:
Input: coins = [2], amount = 3
Output: -1

Example 3:
Input: coins = [1], amount = 0
Output: 0

Example 4:
Input: coins = [1], amount = 1
Output: 1

Example 5:
Input: coins = [1], amount = 2
Output: 2

Constraints:

1 <= coins.length <= 12
1 <= coins[i] <= 231 - 1
0 <= amount <= 104
 */
public class CoinChange {

    /*
    The idea is very classic dynamic programming: think of the last step we take.
    Suppose we have already found out the best way to sum up to amount a, then for the
    last step, we can choose any coin type which gives us a remainder r where r = a-coins[i]
    for all i's. For every remainder, go through exactly the same process as before until
    either the remainder is 0 or less than 0 (meaning not a valid solution). With this
    idea, the only remaining detail is to store the minimum number of coins needed to
    sum up to r so that we don't need to recompute it over and over again.
     */
    // Time complexity : O(S*n)O(S∗n).
    // Space complexity : O(S)O(S)
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
