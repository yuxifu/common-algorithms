package com.f21a.algorithm;

import com.f21a.algorithm.array.NextPermutation;
import org.junit.Assert;
import org.junit.Test;

public class NextPermutationTest {

    @Test
    public void testNextPermutation1() {
        int[] nums = {1, 2, 3};
        new NextPermutation().nextPermutation(nums);
        Assert.assertArrayEquals(new int[]{1, 3, 2}, nums);
    }

    @Test
    public void testNextPermutation2() {
        int[] nums = {3, 2, 1};
        new NextPermutation().nextPermutation(nums);
        Assert.assertArrayEquals(new int[]{1, 2, 3}, nums);
    }

    @Test
    public void testNextPermutation3() {
        int[] nums = {1, 1, 5};
        new NextPermutation().nextPermutation(nums);
        Assert.assertArrayEquals(new int[]{1, 5, 1}, nums);
    }

    @Test
    public void testNextPermutation4() {
        int[] nums = {1};
        new NextPermutation().nextPermutation(nums);
        Assert.assertArrayEquals(new int[]{1}, nums);
    }
}
