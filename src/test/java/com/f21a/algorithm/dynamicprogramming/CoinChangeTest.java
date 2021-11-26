package com.f21a.algorithm.dynamicprogramming;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class CoinChangeTest {
    /*
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
     */
    @Test
    public void testCoinChangeExamples() {
        assertEquals(2, new CoinChange().coinChange(new int[]{1, 3, 5}, 8));
        assertEquals(3, new CoinChange().coinChange(new int[]{1, 2, 5}, 11));
        assertEquals(3, new CoinChange().coinChange(new int[]{1, 3, 5}, 7));
        assertEquals(-1, new CoinChange().coinChange(new int[]{2}, 3));
        assertEquals(0, new CoinChange().coinChange(new int[]{1}, 0));
        assertEquals(1, new CoinChange().coinChange(new int[]{1}, 1));
        assertEquals(2, new CoinChange().coinChange(new int[]{1}, 2));
    }
}
