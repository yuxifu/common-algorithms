package com.f21a.algorithm.backtrack;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class LetterCombinationsPhoneNumberTest {
    /*
    Example 1:
    Input: digits = "23"
    Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

    Example 2:
    Input: digits = ""
    Output: []

    Example 3:
    Input: digits = "2"
    Output: ["a","b","c"]
     */
    @Test
    public void testMergeKSortedListExamples() {
        List<String> result1 = new LetterCombinationsPhoneNumber().letterCombinations("23");
        assertEquals(Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"), result1);

        List<String> result2 = new LetterCombinationsPhoneNumber().letterCombinations("");
        assertEquals(Arrays.asList(), result2);

        List<String> result3 = new LetterCombinationsPhoneNumber().letterCombinations("2");
        assertEquals(Arrays.asList("a", "b", "c"), result3);
    }

    @Test
    public void testMergeKSortedList2Examples() {
        List<String> result1 = new LetterCombinationsPhoneNumber().letterCombinations2("23");
        assertEquals(Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"), result1);

        List<String> result2 = new LetterCombinationsPhoneNumber().letterCombinations2("");
        assertEquals(Arrays.asList(), result2);

        List<String> result3 = new LetterCombinationsPhoneNumber().letterCombinations2("2");
        assertEquals(Arrays.asList("a", "b", "c"), result3);
    }
}
