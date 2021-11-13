package com.f21a.algorithm.graph;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CountComponentsTest {
    /*
    Example 1:
    Input: n = 5, edges = [[0,1],[1,2],[3,4]]
    Output: 2
     */
    @Test
    public void testCountComponentsExample1() {
        int result = new CountComponents().countComponents(5,
                new int[][]{{0, 1}, {1, 2}, {3, 4}});
        assertEquals(2, result);
    }

    /*
    Example 2:
    Input: n = 5, edges = [[0,1],[1,2],[2,3],[3,4]]
    Output: 1
     */
    @Test
    public void testCountComponentsExample2() {
        int result = new CountComponents().countComponents(5,
                new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 4}});
        assertEquals(1, result);
    }
}
