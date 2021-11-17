package com.f21a.algorithm.priorityqueue;

import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertArrayEquals;

public class TopKFrequentElementsTest {
    /*
    Example 1:
    Input: nums = [1,1,1,2,2,3], k = 2
    Output: [1,2]

    Example 2:
    Input: nums = [1], k = 1
    Output: [1]

    Example 3:
    Input: nums = [1,1,1,2,2,3,5,5,5,-1,-1,-1,-1], k = 2
    Output: [-1,1]
     */
    @Test
    public void testTopKFrequentElements1Examples() {
        assertArrayEquals(new int[]{1, 2}, new TopKFrequentElements().topKFrequent(
                new int[]{1, 1, 1, 2, 2, 3}, 2));
        assertArrayEquals(new int[]{1}, new TopKFrequentElements().topKFrequent(
                new int[]{1}, 1));
        assertArrayEquals(new int[]{-1, 1}, new TopKFrequentElements().topKFrequent(
                new int[]{1, 1, 1, 2, 2, 3, 5, 5, 5, -1, -1, -1, -1}, 2));
    }

    @Test
    public void testTopKFrequentElements2Examples() {
        assertEquals(Arrays.asList(1, 2), new TopKFrequentElements().topKFrequent2(
                new int[]{1, 1, 1, 2, 2, 3}, 2));
        assertEquals(Arrays.asList(1), new TopKFrequentElements().topKFrequent2(
                new int[]{1}, 1));
        assertEquals(Arrays.asList(-1, 1), new TopKFrequentElements().topKFrequent2(
                new int[]{1, 1, 1, 2, 2, 3, 5, 5, -1, -1, -1, -1}, 2));
    }

    @Test
    public void testTopKFrequentElements3Examples() {
        assertEquals(Arrays.asList(1, 2), new TopKFrequentElements().topKFrequent3(
                new int[]{1, 1, 1, 2, 2, 3}, 2));
        assertEquals(Arrays.asList(1), new TopKFrequentElements().topKFrequent3(
                new int[]{1}, 1));
        assertEquals(Arrays.asList(-1, 1), new TopKFrequentElements().topKFrequent3(
                new int[]{1, 1, 1, 2, 2, 3, 5, 5, -1, -1, -1, -1}, 2));
    }
}
