package com.f21a.algorithm;

import com.f21a.algorithm.string.ValidNumber;
import org.junit.Assert;
import org.junit.Test;

public class ValidNumberTest {

    @Test
    public void testValidNumber1() {
        boolean result = new ValidNumber().isNumber("0");
        Assert.assertTrue(result);
    }

    @Test
    public void testValidNumber2() {
        boolean result = new ValidNumber().isNumber("e");
        Assert.assertFalse(result);
    }

    @Test
    public void testValidNumber3() {
        boolean result = new ValidNumber().isNumber(".");
        Assert.assertFalse(result);
    }

    @Test
    public void testValidNumber4() {
        boolean result = new ValidNumber().isNumber(".1");
        Assert.assertTrue(result);
    }
}
