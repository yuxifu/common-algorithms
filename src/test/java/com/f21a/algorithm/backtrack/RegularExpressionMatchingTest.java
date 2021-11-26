package com.f21a.algorithm.backtrack;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class RegularExpressionMatchingTest {
    /*
    Example 1:
    Input: s = "aa", p = "a"
    Output: false
    Explanation: "a" does not match the entire string "aa".

    Example 2:
    Input: s = "aa", p = "a*"
    Output: true
    Explanation: '*' means zero or more of the preceding element, 'a'.
    Therefore, by repeating 'a' once, it becomes "aa".

    Example 3:
    Input: s = "ab", p = ".*"
    Output: true
    Explanation: ".*" means "zero or more (*) of any character (.)".

    Example 4:
    Input: s = "aab", p = "c*a*b"
    Output: true
    Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches "aab".

    Example 5:
    Input: s = "mississippi", p = "mis*is*p*."
    Output: false
    */
    @Test
    public void testRegularExpressionMatchingExamples() {
        assertEquals(false, new RegularExpressionMatching().isMatch("aa", "a"));
        assertEquals(true, new RegularExpressionMatching().isMatch("aa", "a*"));
        assertEquals(true, new RegularExpressionMatching().isMatch("ab", ".*"));
        assertEquals(true, new RegularExpressionMatching().isMatch("aab", "c*a*b"));
        assertEquals(false, new RegularExpressionMatching().isMatch("mississippi", "mis*is*p*"));
    }

    @Test
    public void testRegularExpressionMatching2Examples() {
        assertEquals(false, new RegularExpressionMatching().isMatch2("aa", "a"));
        assertEquals(true, new RegularExpressionMatching().isMatch2("aa", "a*"));
        assertEquals(true, new RegularExpressionMatching().isMatch2("ab", ".*"));
        assertEquals(true, new RegularExpressionMatching().isMatch2("aab", "c*a*b"));
        assertEquals(false, new RegularExpressionMatching().isMatch2("mississippi", "mis*is*p*"));
    }

    @Test
    public void testRegularExpressionMatching3Examples() {
        assertEquals(false, new RegularExpressionMatching().isMatch3("aa", "a"));
        assertEquals(true, new RegularExpressionMatching().isMatch3("aa", "a*"));
        assertEquals(true, new RegularExpressionMatching().isMatch3("ab", ".*"));
        assertEquals(true, new RegularExpressionMatching().isMatch3("aab", "c*a*b"));
        assertEquals(false, new RegularExpressionMatching().isMatch3("mississippi", "mis*is*p*"));
    }
}
