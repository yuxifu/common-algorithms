package com.f21a.algorithm.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
Given a sorted integer array arr, two integers k and x, return the k closest integers
to x in the array. The result should also be sorted in ascending order.

An integer a is closer to x than an integer b if:
|a - x| < |b - x|, or
|a - x| == |b - x| and a < b

Example 1:
Input: arr = [1,2,3,4,5], k = 4, x = 3
Output: [1,2,3,4]

Example 2:
Input: arr = [1,2,3,4,5], k = 4, x = -1
Output: [1,2,3,4]

Constraints:
1 <= k <= arr.length
1 <= arr.length <= 104
arr is sorted in ascending order.
-104 <= arr[i], x <= 104
 */

public class FindKClosestElements {

    /*
    The array is sorted.
    If we want find the one number closest to x,
    we don't have to check one by one.
    it's straightforward to use binary research.

    Now we want the k closest,
    the logic should be similar.


    Explanation
    Assume we are taking A[i] ~ A[i + k -1].
    We can binary research i
    We compare the distance between x - A[mid] and A[mid + k] - x

    @vincent_gui listed the following cases:
    Assume A[mid] ~ A[mid + k] is sliding window

    case 1: x - A[mid] < A[mid + k] - x, need to move window go left
    -------x----A[mid]-----------------A[mid + k]----------

    case 2: x - A[mid] < A[mid + k] - x, need to move window go left again
    -------A[mid]----x-----------------A[mid + k]----------

    case 3: x - A[mid] > A[mid + k] - x, need to move window go right
    -------A[mid]------------------x---A[mid + k]----------

    case 4: x - A[mid] > A[mid + k] - x, need to move window go right
    -------A[mid]---------------------A[mid + k]----x------

    If x - A[mid] > A[mid + k] - x,
    it means A[mid + 1] ~ A[mid + k] is better than A[mid] ~ A[mid + k - 1],
    and we have mid smaller than the right i.
    So assign left = mid + 1.

    Important
    Note that, you SHOULD NOT compare the absolute value of abs(x - A[mid]) and abs(A[mid + k] - x).
    It fails at cases like A = [1,1,2,2,2,2,2,3,3], x = 3, k = 3

    The problem is interesting and good.
    Unfortunately the test cases is terrible.
    The worst part of Leetcode test cases is that,
    you submit a wrong solution but get accepted.

    You didn't read my post and up-vote carefully,
    then you miss this key point.


    Complexity
    Time O(log(N - K)) to binary research and find result
    Space O(K) to create the returned list.
     */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int lo = 0;
        int hi = arr.length - k;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] + arr[mid + k] - 2 * x >= 0) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return Arrays.stream(arr, lo, lo + k).boxed().collect(Collectors.toList());
    }

    // O(n)
    public List<Integer> findClosestElements2(int[] arr, int k, int x) {
        int lo = 0;
        int hi = arr.length - 1;
        while (hi - lo >= k) {
            if (arr[lo] + arr[hi] - 2 * x < 0) {
                lo++;
            } else {
                hi--;
            }
        }
        List<Integer> result = new ArrayList<>(k);
        for (int i = lo; i <= hi; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}
