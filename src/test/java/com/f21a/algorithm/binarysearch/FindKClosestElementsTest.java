package com.f21a.algorithm.binarysearch;

import org.junit.Test;

import java.util.Arrays;

import static junit.framework.Assert.assertEquals;

public class FindKClosestElementsTest {
    /*
    Example 1:
    Input: arr = [1,2,3,4,5], k = 4, x = 3
    Output: [1,2,3,4]

    Example 2:
    Input: arr = [1,2,3,4,5], k = 4, x = -1
    Output: [1,2,3,4]

    Example 3:
    Input: arr = [1, 2, 3, 4, 5, 6, 700, 800, 900, 1000], k = 3, x = 6
    Output: [4,5,6]
     */
    @Test
    public void testFindKClosestElementsExamples() {
        assertEquals(Arrays.asList(1, 2, 3, 4), new FindKClosestElements().findClosestElements(
                new int[]{1, 2, 3, 4, 5}, 4, 3));
        assertEquals(Arrays.asList(1, 2, 3, 4), new FindKClosestElements().findClosestElements(
                new int[]{1, 2, 3, 4, 5}, 4, -1));
        assertEquals(Arrays.asList(4, 5, 6), new FindKClosestElements().findClosestElements(
                new int[]{1, 2, 3, 4, 5, 6, 700, 800, 900, 1000}, 3, 6));
    }

    @Test
    public void testFindKClosestElements2Examples() {
        assertEquals(Arrays.asList(1, 2, 3, 4), new FindKClosestElements().findClosestElements2(
                new int[]{1, 2, 3, 4, 5}, 4, 3));
        assertEquals(Arrays.asList(1, 2, 3, 4), new FindKClosestElements().findClosestElements2(
                new int[]{1, 2, 3, 4, 5}, 4, -1));
        assertEquals(Arrays.asList(4, 5, 6), new FindKClosestElements().findClosestElements2(
                new int[]{1, 2, 3, 4, 5, 6, 700, 800, 900, 1000}, 3, 6));
    }
}
