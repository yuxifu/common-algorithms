package com.f21a.algorithm;

/**
 Given a binary array nums and an integer k, return the maximum number of consecutive
 1's in the array if you can flip at most k 0's.

 Example 1:

 Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
 Output: 6
 Explanation: [1,1,1,0,0,1,1,1,1,1,1]
 Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 Example 2:

 Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
 Output: 10
 Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.


 Constraints:

 1 <= nums.length <= 105
 nums[i] is either 0 or 1.
 0 <= k <= nums.length

 Solution:
 Time Complexity: O(n)
 Space Complexity: O(1)

 Let me explain the step by step approach that I have taken to solve this problem.
 I have defined below mentioned variables in my code:
 max — contains the max number of consecutive ones encountered so far.
 current — contains current count of consecutive ones.
 start — start index. initially it is 0.
 end — end index. initially it is 0.

 Consider have below example.

 Input: A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
  Output: 6

 We will begin from start and keep on incrementing the end variable as long as we are encountering a 1.
 When end = 3 than we will encounter a 0. At this point we will check if K > 0 it means we still
 have power to change a 0 to 1.

 We will decrement k by 1( as we used one power) and move forward. When end = 4 , we again encounter a 0.
 We again check that k > 0 so we decrement K by 1 and move forward.

 Now when end = 5, we again encounter 0, but this time K is 0 and our powers are finished.

 We will assign the current value to max if it is greater than max. We will move start to index 4
 and again start repeating the above steps.

 **/

public class MaxConsecutiveOnesIII {
  public static void main(String[] args) {
    int[] nums = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
    int k = 3;
    int result = MaxConsecutiveOnesIII.longestOnes2(nums, k);
    System.out.println(result);
  }

  /**
   * For each A[j], try to find the longest subarray.
   * If A[i] ~ A[j] has zeros <= K, we continue to increment j.
   * If A[i] ~ A[j] has zeros > K, we increment i (as well as j).
   */
  public static int longestOnes2(int[] nums, int k) {
    int i = 0, j;
    for (j = 0; j < nums.length; ++j) {
      if (nums[j] == 0) k--;
      if (k < 0 && nums[i++] == 0) k++;
    }
    return j - i;
  }

  public static int longestOnes(int[] nums, int k) {
    int max = 0;
    int current = 0;
    int start = 0;
    int end = 0;
    while (end < nums.length) {
      if (nums[end] == 1) {
        current++;
        end++;
      } else if (nums[end] == 0 && k > 0) {
        k--;
        current++;
        end++;
      } else {
        if (max < current) {
          max = current;
        }
        while (nums[start] == 1) {
          start++;
        }
        start++;
        end++;
        current = end - start + 1;
      }
    }
    return Math.max(current, max);
  }
}
