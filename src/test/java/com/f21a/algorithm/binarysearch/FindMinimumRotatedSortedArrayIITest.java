package com.f21a.algorithm.binarysearch;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class FindMinimumRotatedSortedArrayIITest {
    /*
    Example 1:
    Input: nums = [1,3,5]
    Output: 1

    Example 2:
    Input: nums = [2,2,2,0,1]
    Output: 0
     */
    @Test
    public void testFindMinimumRotatedSortedArrayIIExamples() {
        assertEquals(1, new FindMinimumRotatedSortedArrayII().findMin(new int[]{1, 3, 5}));
        assertEquals(0, new FindMinimumRotatedSortedArrayII().findMin(new int[]{2, 2, 2, 0, 1}));
    }
}
