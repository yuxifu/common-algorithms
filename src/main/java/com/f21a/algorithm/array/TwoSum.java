package com.f21a.algorithm.array;

import java.util.*;

/**
 * Created by gouthamvidyapradhan on 11/07/2017. Given an array of integers, return indices of the
 * two numbers such that they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same
 * element twice.
 * <p>
 * Example: Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
 * <p>
 * Solution: O(n log n). Wrap index and element in a class and sort in increasing order. Do a two
 * pointer sum and compare. An alternative solution is to use hashing which is a O(n) solution - For
 * each element e check if element (target - e) is already found in hashset, if yes return their
 * index, else add this to hash-set and continue.
 */
public class TwoSum {

    private static class NumIndex {
        int i, e;

        NumIndex(int i, int e) {
            this.i = i;
            this.e = e;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int[] ans = new TwoSum().twoSum2(nums, 9);
        for (int i : ans) System.out.println(i);
    }

    public int[] twoSum(int[] nums, int target) {
        List<NumIndex> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            NumIndex n = new NumIndex(i, nums[i]);
            list.add(n);
        }
        list.sort(Comparator.comparingInt(o -> o.e));

        int[] ans = new int[2];
        for (int i = 0, j = nums.length - 1; i < j; ) {
            NumIndex numi = list.get(i);
            NumIndex numj = list.get(j);
            int sum = numi.e + numj.e;
            if (sum == target) {
                ans[0] = numi.i;
                ans[1] = numj.i;
                return ans;
            } else if (sum > target) {
                j--;
            } else i++;
        }
        return ans;
    }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            Integer j = target - nums[i];
            if (map.containsKey(j) && i != map.get(j)) {
                ans[0] = i;
                ans[1] = map.get(j);
                break;
            }
        }
        return ans;
    }
}
