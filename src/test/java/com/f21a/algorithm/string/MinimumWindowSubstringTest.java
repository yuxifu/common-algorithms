package com.f21a.algorithm.string;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class MinimumWindowSubstringTest {
    @Test
    public void testMinWindow() {
        String subString = new MinimumWindowSubstring().minWindow("ADOBECODEBANC", "ABC");
        assertEquals("BANC", subString);
    }

    @Test
    public void testMinWindow2() {
        String subString = new MinimumWindowSubstring().minWindow2("ADOBECODEBANC", "ABC");
        assertEquals("BANC", subString);
    }

    @Test
    public void testMinWindow3() {
        String subString = new MinimumWindowSubstring().minWindow3("ADOBECODEBANC", "ABC");
        assertEquals("BANC", subString);
    }
}
