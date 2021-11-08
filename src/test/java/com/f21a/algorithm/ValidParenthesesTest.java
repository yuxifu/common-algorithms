package com.f21a.algorithm;

import com.f21a.algorithm.string.ValidParentheses;
import org.junit.Assert;
import org.junit.Test;

public class ValidParenthesesTest {

    @Test
    public void testValidParentheses1() {
        boolean result = new ValidParentheses().isValid("()");
        Assert.assertTrue(result);
    }

    @Test
    public void testValidParentheses2() {
        boolean result = new ValidParentheses().isValid("()[]{}");
        Assert.assertTrue(result);
    }

    @Test
    public void testValidParentheses3() {
        boolean result = new ValidParentheses().isValid("(]");
        Assert.assertFalse(result);
    }

    @Test
    public void testValidParentheses4() {
        boolean result = new ValidParentheses().isValid("([)]");
        Assert.assertFalse(result);
    }

    @Test
    public void testValidParentheses5() {
        boolean result = new ValidParentheses().isValid("{[]}");
        Assert.assertTrue(result);
    }
}
