package com.f21a.algorithm.dynamicprogramming;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class ClimbStairsTest {
    /*
    Example 1:
    Input: n = 2
    Output: 2
    Explanation: There are two ways to climb to the top.
    1. 1 step + 1 step
    2. 2 steps

    Example 2:
    Input: n = 3
    Output: 3
    Explanation: There are three ways to climb to the top.
    1. 1 step + 1 step + 1 step
    2. 1 step + 2 steps
    3. 2 steps + 1 step
     */
    @Test
    public void testClimbStairsExamples() {
        assertEquals(2, new ClimbingStairs().climbStairs(2));
        assertEquals(3, new ClimbingStairs().climbStairs(3));
    }
}
