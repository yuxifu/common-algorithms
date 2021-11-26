package com.f21a.algorithm.dynamicprogramming;

/*
A message containing letters from A-Z can be encoded into numbers using the following mapping:

'A' -> "1"
'B' -> "2"
...
'Z' -> "26"
To decode an encoded message, all the digits must be grouped then mapped back into letters
using the reverse of the mapping above (there may be multiple ways). For example, "11106" can be mapped into:
"AAJF" with the grouping (1 1 10 6)
"KJF" with the grouping (11 10 6)

Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".

Given a string s containing only digits, return the number of ways to decode it.

The answer is guaranteed to fit in a 32-bit integer.

Example 1:
Input: s = "12"
Output: 2
Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).

Example 2:
Input: s = "226"
Output: 3
Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).

Example 3:
Input: s = "0"
Output: 0
Explanation: There is no character that is mapped to a number starting with 0.
The only valid mappings with 0 are 'J' -> "10" and 'T' -> "20", neither of which start with 0.
Hence, there are no valid ways to decode this since all digits need to be mapped.

Example 4:
Input: s = "06"
Output: 0
Explanation: "06" cannot be mapped to "F" because of the leading zero ("6" is different from "06").

Constraints:
1 <= s.length <= 100
s contains only digits and may contain leading zero(s).
 */

public class DecodeWays {
    /*
    I used a dp array of size n + 1 to save subproblem solutions. dp[0] means an empty string will have
    one way to decode, dp[1] means the way to decode a string of size 1. I then check one digit and
    two digit combination and save the results along the way. In the end, dp[n] will be the end result.
     */
    public int numDecodings(String s) {
        if (s.isEmpty() || s.charAt(0) - '0' == 0) {
            return 0;
        }

        int[] waysToDecode = new int[s.length() + 1];
        waysToDecode[0] = 1;
        waysToDecode[1] = 1;
        for (int i = 1; i < s.length(); i++) {
            int curr = s.charAt(i) - '0';
            int prev = s.charAt(i - 1) - '0';

            // can't make progress, return 0
            if (prev == 0 && curr == 0 || (curr == 0 && (prev * 10 + curr > 26))) {
                return 0;
            }
            // can't use the previous value, so can only get to this state from the previous
            else if (prev == 0 || (prev * 10 + curr) > 26) {
                waysToDecode[i + 1] = waysToDecode[i];
            }
            // can't use current state, can only get to this state from i - 1 state
            else if (curr == 0) {
                waysToDecode[i + 1] = waysToDecode[i - 1];
            }
            // can get to this state from the previous two states
            else {
                waysToDecode[i + 1] = waysToDecode[i] + waysToDecode[i - 1];
            }
        }

        return waysToDecode[waysToDecode.length - 1];
    }
}
