package com.f21a.algorithm;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class MaximumProductSubarrayTest {

    int[] nums = {2, 3, -2, 4};

    @Test
    public void testThreeSumNums1() {
        int result = MaximumProductSubarray.maxProduct(nums);
        assertEquals(6, result);
    }

    @Test
    public void testThreeSum2Nums1() {
        int result = MaximumProductSubarray.maxProduct(nums);
        assertEquals(6, result);
    }
}
