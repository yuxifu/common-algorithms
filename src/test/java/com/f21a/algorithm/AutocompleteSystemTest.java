package com.f21a.algorithm;

import com.f21a.algorithm.string.AutocompleteSystem;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class AutocompleteSystemTest {
    @Test
    public void testAutocompleteSystemTest() {
        String[] sentences = {"i love you", "island", "ironman", "i love leetcode"};
        int[] degree = {5, 3, 2, 2};
        AutocompleteSystem autocomplete = new AutocompleteSystem(sentences, degree);

        List<String> result1 = autocomplete.input('i');
        assertEquals(Arrays.asList("i love you", "island", "i love leetcode"), result1);

        List<String> result2 = autocomplete.input(' ');
        assertEquals(Arrays.asList("i love you", "i love leetcode"), result2);

        List<String> result3 = autocomplete.input('a');
        assertEquals(Collections.emptyList(), result3);

        List<String> result4 = autocomplete.input('#');
        assertEquals(Collections.emptyList(), result4);
    }
}
