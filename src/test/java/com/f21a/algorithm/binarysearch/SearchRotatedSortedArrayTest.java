package com.f21a.algorithm.binarysearch;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class SearchRotatedSortedArrayTest {
    /*
    Example 1:
    Input: nums = [4,5,6,7,0,1,2], target = 0
    Output: 4

    Example 2:
    Input: nums = [4,5,6,7,0,1,2], target = 3
    Output: -1

    Example 3:
    Input: nums = [1], target = 0
    Output: -1
     */
    @Test
    public void testSearchRotatedSortedArrayExamples() {
        assertEquals(4, new SearchRotatedSortedArray().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        assertEquals(1, new SearchRotatedSortedArray().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 5));
        assertEquals(-1, new SearchRotatedSortedArray().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        assertEquals(-1, new SearchRotatedSortedArray().search(new int[]{1}, 0));
    }

    @Test
    public void testSearchRotatedSortedArray2Examples() {
        assertEquals(4, new SearchRotatedSortedArray().search2(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        assertEquals(1, new SearchRotatedSortedArray().search2(new int[]{4, 5, 6, 7, 0, 1, 2}, 5));
        assertEquals(-1, new SearchRotatedSortedArray().search2(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        assertEquals(-1, new SearchRotatedSortedArray().search2(new int[]{1}, 0));
    }

    @Test
    public void testSearchRotatedSortedArray3Examples() {
        assertEquals(4, new SearchRotatedSortedArray().search3(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        assertEquals(1, new SearchRotatedSortedArray().search3(new int[]{4, 5, 6, 7, 0, 1, 2}, 5));
        assertEquals(-1, new SearchRotatedSortedArray().search3(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        assertEquals(-1, new SearchRotatedSortedArray().search3(new int[]{1}, 0));
    }
}
