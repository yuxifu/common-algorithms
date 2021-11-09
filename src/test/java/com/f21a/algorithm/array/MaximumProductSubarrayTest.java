package com.f21a.algorithm.array;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class MaximumProductSubarrayTest {

    @Test
    public void testMaxProduct() {
        int[] nums = {2, 3, -2, 4};
        int result = new MaximumProductSubarray().maxProduct(nums);
        assertEquals(6, result);
    }

    @Test
    public void testMaxProduct2() {
        int[] nums = {2, 3, -2, 4};
        int result = new MaximumProductSubarray().maxProduct2(nums);
        assertEquals(6, result);
    }
}
