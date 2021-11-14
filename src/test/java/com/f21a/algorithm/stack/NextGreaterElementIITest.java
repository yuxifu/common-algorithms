package com.f21a.algorithm.stack;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class NextGreaterElementIITest {
    /*
    Example 1:
    Input: nums = [1,2,1]
    Output: [2,-1,2]
    Explanation: The first 1's next greater number is 2;
    The number 2 can't find next greater number.
    The second 1's next greater number needs to search circularly, which is also 2.

    Example 2:
    Input: nums = [1,2,3,4,3]
    Output: [2,3,4,-1,4]
     */
    @Test
    public void testBasicCalculatorIIIExample1() {
        int[] result = new NextGreaterElementII().nextGreaterElements(new int[]{1, 2, 1});
        assertArrayEquals(new int[]{2, -1, 2}, result);
    }

    @Test
    public void testBasicCalculatorIIIExample2() {
        int[] result = new NextGreaterElementII().nextGreaterElements(new int[]{1, 2, 3, 4, 3});
        assertArrayEquals(new int[]{2, 3, 4, -1, 4}, result);
    }
}
