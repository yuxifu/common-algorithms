package com.f21a.algorithm.dynamicprogramming;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class LongestCommonSubsequenceTest {
    /*
    Example 1:
    Input: text1 = "abcde", text2 = "ace"
    Output: 3
    Explanation: The longest common subsequence is "ace" and its length is 3.

    Example 2:
    Input: text1 = "abc", text2 = "abc"
    Output: 3
    Explanation: The longest common subsequence is "abc" and its length is 3.

    Example 3:
    Input: text1 = "abc", text2 = "def"
    Output: 0
    Explanation: There is no such common subsequence, so the result is 0.
    */
    @Test
    public void testLongestCommonSubsequenceExamples() {
        assertEquals(3, new LongestCommonSubsequence().longestCommonSubsequence("abcde", "ace"));
        assertEquals(3, new LongestCommonSubsequence().longestCommonSubsequence("abc", "abc"));
        assertEquals(0, new LongestCommonSubsequence().longestCommonSubsequence("abc", "def"));
    }

    @Test
    public void testLongestCommonSubsequence2Examples() {
        assertEquals(3, new LongestCommonSubsequence().longestCommonSubsequence2("abcde", "ace"));
        assertEquals(3, new LongestCommonSubsequence().longestCommonSubsequence2("abc", "abc"));
        assertEquals(0, new LongestCommonSubsequence().longestCommonSubsequence2("abc", "def"));
    }
}
