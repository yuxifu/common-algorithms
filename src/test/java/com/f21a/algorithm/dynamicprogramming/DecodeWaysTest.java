package com.f21a.algorithm.dynamicprogramming;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class DecodeWaysTest {
    /*
    Example 1:
    Input: s = "12"
    Output: 2
    Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).

    Example 2:
    Input: s = "226"
    Output: 3
    Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).

    Example 3:
    Input: s = "0"
    Output: 0
    Explanation: There is no character that is mapped to a number starting with 0.
    The only valid mappings with 0 are 'J' -> "10" and 'T' -> "20", neither of which start with 0.
    Hence, there are no valid ways to decode this since all digits need to be mapped.

    Example 4:
    Input: s = "06"
    Output: 0
    Explanation: "06" cannot be mapped to "F" because of the leading zero ("6" is different from "06").
     */
    @Test
    public void testDecodeWaysExamples() {
        assertEquals(2, new DecodeWays().numDecodings("12"));
        assertEquals(3, new DecodeWays().numDecodings("226"));
        assertEquals(0, new DecodeWays().numDecodings("0"));
        assertEquals(0, new DecodeWays().numDecodings("06"));
    }
}
