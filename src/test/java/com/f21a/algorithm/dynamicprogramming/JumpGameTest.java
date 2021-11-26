package com.f21a.algorithm.dynamicprogramming;

import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class JumpGameTest {
    /*
    Example 1:
    Input: nums = [2,3,1,1,4]
    Output: true
    Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

    Example 2:
    Input: nums = [3,2,1,0,4]
    Output: false
    Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
     */
    @Test
    public void testJumpGameExamples() {
        assertTrue(new JumpGame().canJump(new int[]{2, 3, 1, 1, 4}));
        assertFalse(new JumpGame().canJump(new int[]{3, 2, 1, 0, 4}));
    }

    @Test
    public void testJumpGame2Examples() {
        assertTrue(new JumpGame().canJump2(new int[]{2, 3, 1, 1, 4}));
        assertFalse(new JumpGame().canJump2(new int[]{3, 2, 1, 0, 4}));
    }

    @Test
    public void testJumpGame3Examples() {
        assertTrue(new JumpGame().canJump3(new int[]{2, 3, 1, 1, 4}));
        assertFalse(new JumpGame().canJump3(new int[]{3, 2, 1, 0, 4}));
    }
}
