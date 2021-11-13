package com.f21a.algorithm.graph;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class GraphValidTreeTest {
    /*
    Example 1:
         0
       / | \
      1  2  3
      |
      4
    Input: n = 5, edges = [[0,1],[0,2],[0,3],[1,4]]
    Output: true
     */
    @Test
    public void testGraphValidTreeExample1() {
        boolean result = new GraphValidTree().validTree(5,
                new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 4}});
        assertTrue(result);
    }

    /*
    Example 2:
      0-1-2
        |\|
        4 3
    Input: n = 5, edges = [[0,1],[1,2],[2,3],[1,3],[1,4]]
    Output: false
     */
    @Test
    public void testGraphValidTreeExample2() {
        boolean result = new GraphValidTree().validTree(5,
                new int[][]{{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}});
        assertFalse(result);
    }
}
