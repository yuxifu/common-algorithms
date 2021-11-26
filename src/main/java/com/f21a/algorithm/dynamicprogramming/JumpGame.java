package com.f21a.algorithm.dynamicprogramming;

/*
You are given an integer array nums. You are initially positioned at the array's first index,
and each element in the array represents your maximum jump length at that position.
Return true if you can reach the last index, or false otherwise.

Example 1:
Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

Example 2:
Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.

Constraints:
1 <= nums.length <= 104
0 <= nums[i] <= 105
 */
public class JumpGame {
    /*
    Greedy
    Time: O(n), 2 ms
    Idea is to work backwards from the last index. Keep track of the smallest index that can "jump"
    to the last index. Check whether the current index can jump to this smallest index.
     */
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int last = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (i + nums[i] >= last) last = i;
        }
        return last <= 0;
    }

    /*
    Greedy
    Time: O(n)
    Great solution. One possible improvement is that your loops runs for n times no matter what.
    This might not be necessary if we compute from start to end. The idea is: whenever we realize
    that we cannot reach a point i, return false.
     */
    public boolean canJump2(int[] nums) {
        int maxLocation = 0;
        for (int i = 0; i < nums.length; i++) {
            // if previous maxLocation smaller than i, meaning we cannot reach location i, thus return false.
            if (maxLocation < i) return false;
            maxLocation = Math.max((i + nums[i]), maxLocation); // greedy:
            if (maxLocation >= nums.length - 1) break;
        }
        return true;
    }

    /*
    Dynamic Programming
    Looking from the end and at each point ahead checking the best possible way to reach the end
    Time: O(n^2)
     */
    public boolean canJump3(int[] nums) {
        int n = nums.length;
        boolean[] jump = new boolean[n];
        jump[n - 1] = true;
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= nums[i] && i + j < n; j++) {
                if (jump[i + j]) {
                    jump[i] = true;
                    break;
                }
            }
        }
        return jump[0];
    }
}
