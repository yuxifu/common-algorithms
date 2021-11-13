package com.f21a.algorithm.graph;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class NumberOfIslandsTest {
    /*
    Example 1:
    Input: grid = {
      {'1','1','1','1','0'},
      {'1','1','0','1','0'},
      {'1','1','0','0','0'},
      {'0','0','0','0','0'}
    }
    Output: 1
    */
    @Test
    public void testNumberOfIslandsExample1() {
        int result = new NumberOfIslands().numIslands(new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}});
        assertEquals(1, result);
    }

    /*
    Example 2:
    Input: grid = {
      {'1','1','0','0','0'},
      {'1','1','0','0','0'},
      {'0','0','1','0','0'},
      {'0','0','0','1','1'}
    }
    Output: 3
    */
    @Test
    public void testNumberOfIslandsExample2() {
        int result = new NumberOfIslands().numIslands(new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        });
        assertEquals(3, result);
    }

    /*
    Example 2:
    Input: grid = {
      {'1','1','0','1','0'},
      {'1','1','0','0','0'},
      {'0','0','1','0','0'},
      {'1','0','0','1','1'}
    }
    Output: 3
    */
    @Test
    public void testNumberOfIslandsExample3() {
        int result = new NumberOfIslands().numIslands(new char[][]{
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'1', '0', '0', '1', '1'}
        });
        assertEquals(5, result);
    }
}
