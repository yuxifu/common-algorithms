package com.f21a.algorithm.string;

/*
You are given a string s and an integer k. You can choose any character of the string
and change it to any other uppercase English character. You can perform this operation
at most k times.

Return the length of the longest substring containing the same letter you can get
after performing the above operations.

Example 1:

Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.
Example 2:

Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.


Constraints:

1 <= s.length <= 105
s consists of only uppercase English letters.
0 <= k <= s.length
*/

public class LongestRepeatingCharacterReplacement {

    // Sliding Window - Two Pointers - (9 ms, faster than 63.21%)
    // O(n) time, O(k) space
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int maxCount = 0;
        int maxLength = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            count[s.charAt(right) - 'A'] += 1;
            maxCount = Math.max(maxCount, count[s.charAt(right) - 'A']);
            while (right - left + 1 - maxCount > k) {
                count[s.charAt(left) - 'A'] -= 1;
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    /* Since we are only interested in the longest valid substring, our
    sliding windows need not shrink, even if a window may cover an
    invalid substring. We either grow the window by appending one char
    on the right, or shift the whole window to the right by one. And we
    only grow the window when the count of the new char exceeds the
    historical max count (from a previous window that covers a valid substring).

    That is, we do not need the accurate max count of the current window;
    we only care if the max count exceeds the historical max count;
    and that can only happen because of the new char. */
    public int characterReplacement2(String s, int k) {
        int[] count = new int[128];
        int max = 0;
        int start = 0;
        for (int end = 0; end < s.length(); end++) {
            max = Math.max(max, ++count[s.charAt(end)]);
            if (max + k <= end - start)
                count[s.charAt(start++)]--;
        }
        return s.length() - start;
    }
}
