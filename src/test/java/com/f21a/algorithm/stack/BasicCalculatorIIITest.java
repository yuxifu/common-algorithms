package com.f21a.algorithm.stack;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class BasicCalculatorIIITest {
    /*
    Example 1:
    Input: s = "1+1"
    Output: 2

    Example 2:
    Input: s = "6-4/2"
    Output: 4

    Example 3:
    Input: s = "2*(5+5*2)/3+(6/2+8)"
    Output: 21

    Example 4:
    Input: s = "(2+6*3+5-(3*14/7+2)*5)+3"
    Output: -12

    Example 5:
    Input: s = "0"
    Output: 0
     */
    @Test
    public void testBasicCalculatorIIIExamples() {
        assertEquals(2, new BasicCalculatorIII().calculate("1+1"));
        assertEquals(4, new BasicCalculatorIII().calculate("6-4/2"));
        assertEquals(21, new BasicCalculatorIII().calculate("2*(5+5*2)/3+(6/2+8)"));
        assertEquals(-12, new BasicCalculatorIII().calculate("(2+6*3+5-(3*14/7+2)*5)+3"));
        assertEquals(0, new BasicCalculatorIII().calculate("0"));
    }

    @Test
    public void testBasicCalculatorIII2Examples() {
        assertEquals(2, new BasicCalculatorIII().calculate2("1+1"));
        assertEquals(4, new BasicCalculatorIII().calculate2("6-4/2"));
        assertEquals(21, new BasicCalculatorIII().calculate2("2*(5+5*2)/3+(6/2+8)"));
        assertEquals(-12, new BasicCalculatorIII().calculate2("(2+6*3+5-(3*14/7+2)*5)+3"));
        assertEquals(0, new BasicCalculatorIII().calculate2("0"));
    }
}
