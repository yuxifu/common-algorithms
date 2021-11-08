package com.f21a.algorithm;

import com.f21a.algorithm.string.LongestRepeatingCharacterReplacement;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class LongestRepeatingCharacterReplacementTest {
    @Test
    public void testCharacterReplacement() {

        // Replace the two 'A's with two 'B's or vice versa.
        int len1 = new LongestRepeatingCharacterReplacement().characterReplacement("ABAB", 2);
        assertEquals(4, len1);

        // Replace the one 'A' in the middle with 'B' and form "AABBBBA".
        // The substring "BBBB" has the longest repeating letters, which is 4.
        int len2 = new LongestRepeatingCharacterReplacement().characterReplacement("AABABBA", 1);
        assertEquals(4, len2);
    }

    @Test
    public void testCharacterReplacement2() {

        // Replace the two 'A's with two 'B's or vice versa.
        int len1 = new LongestRepeatingCharacterReplacement().characterReplacement2("ABAB", 2);
        assertEquals(4, len1);

        // Replace the one 'A' in the middle with 'B' and form "AABBBBA".
        // The substring "BBBB" has the longest repeating letters, which is 4.
        int len2 = new LongestRepeatingCharacterReplacement().characterReplacement2("AABABBA", 1);
        assertEquals(4, len2);
    }
}

