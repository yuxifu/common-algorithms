package com.f21a.algorithm.binarysearch;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class SingleElementSortedArrayTest {
    /*
    Example 1:
    Input: nums = [1,1,2,3,3,4,4,8,8]
    Output: 2

    Example 2:
    Input: nums = [3,3,7,7,10,11,11]
    Output: 10
     */
    @Test
    public void testSingleElementSortedArrayExamples() {
        assertEquals(2, new SingleElementSortedArray().singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}));
        assertEquals(10, new SingleElementSortedArray().singleNonDuplicate(new int[]{3, 3, 7, 7, 10, 11, 11}));
    }
}
