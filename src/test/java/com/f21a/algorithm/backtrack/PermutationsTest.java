package com.f21a.algorithm.backtrack;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class PermutationsTest {
    /*
    Example 1:
    Input: nums = [1,2,3]
    Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

    Example 2:
    Input: nums = [0,1]
    Output: [[0,1],[1,0]]

    Example 3:
    Input: nums = [1]
    Output: [[1]]
     */

    @Test
    public void testPermutationsExamples() {
        List<List<Integer>> result1 = new Permutations().permute(new int[]{1, 2, 3});
        assertEquals(Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(1, 3, 2),
                Arrays.asList(2, 1, 3),
                Arrays.asList(2, 3, 1),
                Arrays.asList(3, 1, 2),
                Arrays.asList(3, 2, 1))
                , result1);

        List<List<Integer>> result2 = new Permutations().permute(new int[]{0, 1});
        assertEquals(Arrays.asList(Arrays.asList(0, 1), Arrays.asList(1, 0)), result2);

        List<List<Integer>> result3 = new Permutations().permute(new int[]{1});
        assertEquals(Arrays.asList(Arrays.asList(1)), result3);
    }
}
