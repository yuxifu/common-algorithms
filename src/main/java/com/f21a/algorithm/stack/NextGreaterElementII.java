package com.f21a.algorithm.stack;

import java.util.Arrays;
import java.util.Stack;

/*
Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]),
return the next greater number for every element in nums.

The next greater number of a number x is the first greater number to its traversing-order next in
the array, which means you could search circularly to find its next greater number. If it doesn't
exist, return -1 for this number.

Example 1:
Input: nums = [1,2,1]
Output: [2,-1,2]
Explanation: The first 1's next greater number is 2;
The number 2 can't find next greater number.
The second 1's next greater number needs to search circularly, which is also 2.

Example 2:
Input: nums = [1,2,3,4,3]
Output: [2,3,4,-1,4]

Constraints:
1 <= nums.length <= 104
-109 <= nums[i] <= 109
 */
public class NextGreaterElementII {
    /*
    Time O(N) for one pass
    Space O(N) in worst case
    Loop once, we can get the Next Greater Number of a normal array.
    Loop twice, we can get the Next Greater Number of a circular array

    Suppose we have a decreasing sequence followed by a greater number
    For example [5, 4, 3, 2, 1, 6] then the greater number 6 is the next greater element for all previous
    numbers in the sequence

    We use a stack to keep a decreasing sub-sequence, whenever we see a number x greater than stack.peek()
    we pop all elements less than x and for all the popped ones, their next greater element is x

    For example [9, 8, 7, 3, 2, 1, 6]

    The stack will first contain [9, 8, 7, 3, 2, 1] and then we see 6 which is greater than 1 so we pop 1 2 3
    whose next greater element should be 6
     */
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] next = new int[n];
        Arrays.fill(next, -1);
        Stack<Integer> stack = new Stack<>(); // index stack
        for (int i = 0; i < n * 2; i++) {
            int num = nums[i % n];
            while (!stack.isEmpty() && nums[stack.peek()] < num)
                next[stack.pop()] = num;
            if (i < n) stack.push(i);
        }
        return next;
    }
}
