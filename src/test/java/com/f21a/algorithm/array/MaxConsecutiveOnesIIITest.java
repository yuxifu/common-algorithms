package com.f21a.algorithm.array;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class MaxConsecutiveOnesIIITest {

    @Test
    public void testLongestOnesNums1() {
        int[] nums1 = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        int k = 3;
        int result = new MaxConsecutiveOnesIII().longestOnes(nums1, k);
        assertEquals(11, result);
    }

    @Test
    public void testLongestOnes2Nums1() {
        int[] nums1 = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        int k = 3;
        int result = new MaxConsecutiveOnesIII().longestOnes2(nums1, k);
        assertEquals(10, result);
    }

    @Test
    public void testLongestOnesNums2() {
        int[] nums2 = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;
        int result = new MaxConsecutiveOnesIII().longestOnes(nums2, k);
        assertEquals(7, result);
    }

    @Test
    public void testLongestOnes2Nums2() {
        int[] nums2 = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;
        int result = new MaxConsecutiveOnesIII().longestOnes2(nums2, k);
        assertEquals(6, result);
    }
}
