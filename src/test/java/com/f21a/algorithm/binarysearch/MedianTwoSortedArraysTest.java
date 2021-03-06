package com.f21a.algorithm.binarysearch;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class MedianTwoSortedArraysTest {
    /*
    Example 1:
    Input: nums1 = [1,3], nums2 = [2]
    Output: 2.00000
    Explanation: merged array = [1,2,3] and median is 2.

    Example 2:
    Input: nums1 = [1,2], nums2 = [3,4]
    Output: 2.50000
    Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.

    Example 3:
    Input: nums1 = [0,0], nums2 = [0,0]
    Output: 0.00000

    Example 4:
    Input: nums1 = [], nums2 = [1]
    Output: 1.00000

    Example 5:
    Input: nums1 = [2], nums2 = []
    Output: 2.00000
     */
    @Test
    public void testSingleElementSortedArrayExamples() {
        assertEquals(2.0, new MedianTwoSortedArrays().findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        assertEquals(2.5, new MedianTwoSortedArrays().findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
        assertEquals(0.0, new MedianTwoSortedArrays().findMedianSortedArrays(new int[]{0, 0}, new int[]{0, 0}));
        assertEquals(1.0, new MedianTwoSortedArrays().findMedianSortedArrays(new int[]{}, new int[]{1}));
        assertEquals(2.0, new MedianTwoSortedArrays().findMedianSortedArrays(new int[]{2}, new int[]{}));
    }
}
