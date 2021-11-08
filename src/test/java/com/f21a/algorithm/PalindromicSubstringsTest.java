package com.f21a.algorithm;

import com.f21a.algorithm.string.PalindromicSubstrings;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class PalindromicSubstringsTest {
    @Test
    public void testCountSubstringsTest1() {
        int count = new PalindromicSubstrings().countSubstrings("abc");
        assertEquals(3, count);
    }

    @Test
    public void testCountSubstringsTest2() {
        int count = new PalindromicSubstrings().countSubstrings("aaa");
        assertEquals(6, count);
    }

    @Test
    public void testCountSubstrings2Test1() {
        int count = new PalindromicSubstrings().countSubstrings2("abc");
        assertEquals(3, count);
    }

    @Test
    public void testCountSubstrings2Test2() {
        int count = new PalindromicSubstrings().countSubstrings2("aaa");
        assertEquals(6, count);
    }
}
