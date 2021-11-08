package com.f21a.algorithm;

import com.f21a.algorithm.string.LongestSubstringKUniqueChars;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class LongestSubstringKUniqueCharsTest {
    @Test
    public void testLengthOfLongestSubstringKDistinctsTest1() {
        int len = new LongestSubstringKUniqueChars().lengthOfLongestSubstringKDistinct("eceba", 2);
        assertEquals(3, len);
    }

    @Test
    public void testLengthOfLongestSubstringKDistinctsTest2() {
        int len = new LongestSubstringKUniqueChars().lengthOfLongestSubstringKDistinct("aa", 1);
        assertEquals(2, len);
    }
}
