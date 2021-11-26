package com.f21a.algorithm.backtrack;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class NQueensTest {
    /*
    Example 1:
    Input: n = 4
    Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
    Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above

    Example 2:
    Input: n = 1
    Output: [["Q"]]
    */
    @Test
    public void testNQueensExamples() {
        List<List<String>> result1 = new NQueens().solveNQueens(4);
        assertEquals(Arrays.asList(".Q..", "...Q", "Q...", "..Q."), result1.get(0));
        assertEquals(Arrays.asList("..Q.", "Q...", "...Q", ".Q.."), result1.get(1));

        List<List<String>> result2 = new NQueens().solveNQueens(1);
        assertEquals(Arrays.asList("Q"), result2.get(0));
    }
}
