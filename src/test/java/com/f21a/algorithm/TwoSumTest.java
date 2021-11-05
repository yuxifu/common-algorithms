package com.f21a.algorithm;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TwoSumTest {

    int[] nums = {2, 11, 7, 15};

    @Test
    public void testTwoSum() {
        int[] ans = TwoSum.twoSum(nums, 9);
        assertEquals(0, ans[0]);
        assertEquals(2, ans[1]);
    }

    @Test
    public void testTwoSum2() {
        int[] ans = TwoSum.twoSum2(nums, 18);
        assertEquals(1, ans[0]);
        assertEquals(2, ans[1]);
    }
}
