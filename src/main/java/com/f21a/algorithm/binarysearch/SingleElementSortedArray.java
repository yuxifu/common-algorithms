package com.f21a.algorithm.binarysearch;

/*
You are given a sorted array consisting of only integers where every element
appears exactly twice, except for one element which appears exactly once.

Return the single element that appears only once.

Your solution must run in O(log n) time and O(1) space.

Example 1:
Input: nums = [1,1,2,3,3,4,4,8,8]
Output: 2

Example 2:
Input: nums = [3,3,7,7,10,11,11]
Output: 10

Constraints:
1 <= nums.length <= 105
0 <= nums[i] <= 105
 */

public class SingleElementSortedArray {
    /*
    My solution using binary search. lo and hi are not regular index,
    but the pair index here. Basically you want to find the first even-index
    number not followed by the same number.
     */
    public int singleNonDuplicate(int[] nums) {
        // binary search
        int n = nums.length, lo = 0, hi = n / 2;
        while (lo < hi) {
            int m = (lo + hi) / 2;
            if (nums[2 * m] != nums[2 * m + 1]) hi = m;
            else lo = m + 1;
        }
        return nums[2 * lo];
    }
}
