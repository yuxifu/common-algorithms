package com.f21a.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gouthamvidyapradhan on 29/03/2017. Given an array S of n integers, are there elements
 * a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum
 * of zero.
 *
 * <p>Note: The solution set must not contain duplicate triplets.
 *
 * <p>For example, given array S = [-1, 0, 1, 2, -1, -4],
 *
 * <p>A solution set is: [ [-1, 0, 1], [-1, -1, 2] ]
 */
public class ThreeSum {
  /**
   * Main method
   *
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    int[] nums = {
      -1, 0, 1, 2, -1, -4, -1, 0, 1, 2, -1, -4, -1, 0, 1, 2, -1, -4, -1, 0, 1, 2, -1, -4, -1, 0, 1,
      2, -1, -4, -1, 0, 1, 2, -1, -4, -1, 0, 1, 2, -1, -4, -1, 0, 1, 2, -1, -4
    };
    System.out.println(ThreeSum.threeSum2(nums));
  }

  public static List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    if (nums.length < 3) return result;
    Arrays.sort(nums);
    for (int i = 0, l = nums.length; i < l - 2; i++) {
      if (i == 0 || nums[i] != nums[i - 1]) {
        int j = i + 1, k = l - 1;
        while (k > j) {
          if (j != i + 1 && nums[j] == nums[j - 1]) {
            j++;
            continue;
          }
          int sum = nums[i] + nums[j] + nums[k];
          if (sum == 0) {
            result.add(Arrays.asList(nums[i], nums[j], nums[k]));
            k--;
            j++;
          } else if (sum > 0) k--;
          else j++;
        }
      }
    }
    return result;
  }

  /*
  1.  Sort the array
  2.  Loop over array and fix current value x as first element of the possible triplet
  3.  Create two pointers:
      left, pointing to element right after x
      right, pointing to last element
  4.  While left pointer is less then right compare their sum to -x:
      sum < -x, shift the left pointer to the right
      sum > -x, shift the right pointer to the left
      sum = -x, store triplet a, b, c it in the result variable, and shift the left pointer to the right
   */
  public static List<List<Integer>> threeSum2(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    if (nums.length < 3) return result;
    Arrays.sort(nums);
    int l = nums.length;
    for (int i = 0; i < l - 2; i++) {
      // skip the duplicate num[i]
      if (i == 0 || nums[i] != nums[i - 1]) {
        int j = i + 1, k = l - 1;
        while (k > j) {
          // skip the duplicate num[j]
          if (j != i + 1 && nums[j] == nums[j - 1]) {
            j++;
            continue;
          }
          int sum = nums[i] + nums[j] + nums[k];
          if (sum == 0) {
            result.add(Arrays.asList(nums[i], nums[j], nums[k]));
            k--;
            j++;
          } else if (sum > 0) k--;
          else j++;
        }
      }
    }
    return result;
  }
}
