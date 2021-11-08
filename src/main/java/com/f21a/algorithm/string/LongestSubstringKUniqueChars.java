package com.f21a.algorithm.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s and an integer k, return the length of the longest substring of s that contains at most k distinct characters.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "eceba", k = 2
 * Output: 3
 * Explanation: The substring is "ece" with length 3.
 * Example 2:
 * <p>
 * Input: s = "aa", k = 1
 * Output: 2
 * Explanation: The substring is "aa" with length 2.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 5 * 104
 * 0 <= k <= 50
 */
public class LongestSubstringKUniqueChars {
    /**
     * Main method
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        String s = "aabacbebebe";
        int k = 3;
        int b = new LongestSubstringKUniqueChars().lengthOfLongestSubstringKDistinct(s, k);
        System.out.println(b);
    }

    /**
     * We use 2 pointers to keep track of the window having at most k distinct characters.
     * We keep adding the characters to the right while the map size <= k, thus expanding
     * the window. Once the map size exceeds k, we start removing characters from left,
     * thus shrinking the window to bring it to k unique characters. Here is the Java code below -
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0) return 0;
        if (s.length() == 1) return 1;

        Map<Character, Integer> map = new HashMap<>();

        int left = 0;
        int maxLen = 1;

        for (int right = 0; right < s.length(); right++) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);

            if (map.size() > k) {
                while (left < right && map.size() > k) {
                    char c = s.charAt(left);
                    map.put(c, map.get(c) - 1);

                    if (map.get(c) == 0) map.remove(c);
                    left++;
                }
            }

            if (right - left + 1 > maxLen) maxLen = right - left + 1;
        }
        return maxLen;
    }
}
