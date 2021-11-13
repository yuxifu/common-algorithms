package com.f21a.algorithm.graph;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class AlienDictionaryTest {
    /*
    Example 1:
    Input: words = ["wrt","wrf","er","ett","rftt"]
    Output: "wertf"
    */
    @Test
    public void testAlienDictionaryExample1() {
        assertEquals("wertf", new AlienDictionary().alienOrder(
                new String[]{"wrt", "wrf", "er", "ett", "rftt"}));
    }

    /*
    Example 2:
    Input: words = ["z","x"]
    Output: "zx"
     */
    @Test
    public void testAlienDictionaryExample2() {
        assertEquals("zx", new AlienDictionary().alienOrder(
                new String[]{"z", "x"}));
    }

    /*
    Example 3:
    Input: words = ["z","x","z"]
    Output: ""
    Explanation: The order is invalid, so return "".
     */
    @Test
    public void testAlienDictionaryExample3() {
        assertEquals("", new AlienDictionary().alienOrder(
                new String[]{"z", "x", "z"}));
    }

    /*
    Example 4:
    Input: words = ["abc","ab"]
    Output: ""
     */
    @Test
    public void testAlienDictionaryExample4() {
        assertEquals("", new AlienDictionary().alienOrder(
                new String[]{"abc", "ab"}));
    }

    // Graph solution

    @Test
    public void testAlienDictionary2Example1() {
        assertEquals("wertf", new AlienDictionary().alienOrder2(
                new String[]{"wrt", "wrf", "er", "ett", "rftt"}));
    }

    @Test
    public void testAlienDictionary2Example2() {
        assertEquals("zx", new AlienDictionary().alienOrder2(
                new String[]{"z", "x"}));
    }

    @Test
    public void testAlienDictionary2Example3() {
        assertEquals("", new AlienDictionary().alienOrder2(
                new String[]{"z", "x", "z"}));
    }

    @Test
    public void testAlienDictionary2Example4() {
        assertEquals("", new AlienDictionary().alienOrder2(
                new String[]{"abc", "ab"}));
    }
}
