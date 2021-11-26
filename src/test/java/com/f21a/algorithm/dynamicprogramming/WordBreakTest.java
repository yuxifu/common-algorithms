package com.f21a.algorithm.dynamicprogramming;

import org.junit.Test;

import java.util.Arrays;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class WordBreakTest {
    /*
    Example 1:
    Input: s = "leetcode", wordDict = ["leet","code"]
    Output: true
    Explanation: Return true because "leetcode" can be segmented as "leet code".

    Example 2:
    Input: s = "applepenapple", wordDict = ["apple","pen"]
    Output: true
    Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
    Note that you are allowed to reuse a dictionary word.

    Example 3:
    Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
    Output: false
    */
    @Test
    public void testWordBreakExamples() {
        assertTrue(new WordBreak().wordBreak("leetcode", Arrays.asList("leet", "code")));
        assertTrue(new WordBreak().wordBreak("applepenapple", Arrays.asList("apple", "pen")));
        assertFalse(new WordBreak().wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
    }

    @Test
    public void testWordBreak2Examples() {
        assertTrue(new WordBreak().wordBreak2("leetcode", Arrays.asList("leet", "code")));
        assertTrue(new WordBreak().wordBreak2("applepenapple", Arrays.asList("apple", "pen")));
        assertFalse(new WordBreak().wordBreak2("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
    }
}
