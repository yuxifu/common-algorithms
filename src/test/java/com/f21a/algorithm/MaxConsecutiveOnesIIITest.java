package com.f21a.algorithm;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class MaxConsecutiveOnesIIITest {

    int[] nums1 = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
    int[] nums2 = {1,1,1,0,0,0,1,1,1,1,0};

    @Test
    public void testLongestOnesNums1() {
        int k = 3;
        int result = MaxConsecutiveOnesIII.longestOnes(nums1, k);
        assertEquals(11, result);
    }

    @Test
    public void testLongestOnes2Nums1() {
        int k = 3;
        int result = MaxConsecutiveOnesIII.longestOnes2(nums1, k);
        assertEquals(10, result);
    }

    @Test
    public void testLongestOnesNums2() {
        int k = 2;
        int result = MaxConsecutiveOnesIII.longestOnes(nums2, k);
        assertEquals(7, result);
    }

    @Test
    public void testLongestOnes2Nums2() {
        int k = 2;
        int result = MaxConsecutiveOnesIII.longestOnes2(nums2, k);
        assertEquals(6, result);
    }
}
