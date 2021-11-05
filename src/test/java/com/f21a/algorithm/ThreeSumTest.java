package com.f21a.algorithm;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class ThreeSumTest {

    int[] nums = {
            -1, 0, 1, 2, -1, -4, -1, 0, 1, 2, -1, -4, -1, 0, 1, 2, -1, -4, -1, 0, 1, 2, -1, -4, -1, 0, 1,
            2, -1, -4, -1, 0, 1, 2, -1, -4, -1, 0, 1, 2, -1, -4, -1, 0, 1, 2, -1, -4
    };

    @Test
    public void testThreeSum() {
        List<List<Integer>> ans = ThreeSum.threeSum(nums);
        assertEquals(4, ans.size());
        Assert.assertEquals(Arrays.asList(-4, 2, 2), ans.get(0));
        Assert.assertEquals(Arrays.asList(-1, -1, 2), ans.get(1));
        Assert.assertEquals(Arrays.asList(-1, 0, 1), ans.get(2));
        Assert.assertEquals(Arrays.asList(0, 0, 0), ans.get(3));
    }

    @Test
    public void testThreeSum2() {
        List<List<Integer>> ans = ThreeSum.threeSum2(nums);
        assertEquals(4, ans.size());
        Assert.assertEquals(Arrays.asList(-4, 2, 2), ans.get(0));
        Assert.assertEquals(Arrays.asList(-1, -1, 2), ans.get(1));
        Assert.assertEquals(Arrays.asList(-1, 0, 1), ans.get(2));
        Assert.assertEquals(Arrays.asList(0, 0, 0), ans.get(3));
    }
}
