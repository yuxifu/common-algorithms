package com.f21a.algorithm.string;

import java.util.HashMap;

/**
 * Created by gouthamvidyapradhan on 03/12/2017.
 * <p>
 * Given a string S and a string T, find the minimum window in S which will contain all the
 * characters in T in complexity O(n).
 * <p>
 * For example, S = "ADOBECODEBANC" T = "ABC" Minimum window is "BANC".
 * <p>
 * Note: If there is no such window in S that covers all characters in T, return the empty string
 * "".
 * <p>
 * If there are multiple such windows, you are guaranteed that there will always be only one
 * unique minimum window in s.
 * <p>
 * Solution O(n). Sliding window sub-sting using two pointers.
 */
public class MinimumWindowSubstring {
    private int[] hash = new int[256];
    private int[] curr = new int[256];

    /**
     * Main method
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        System.out.println(new MinimumWindowSubstring().minWindow3("ADOBECODEBANC", "ABC"));
    }

    // 47 ms
    public String minWindow(String s, String t) {
        if (s.isEmpty() && t.isEmpty()) return "";
        if (t.length() > s.length()) return "";
        int start = -1, end = -1, min = Integer.MAX_VALUE;
        for (int i = 0, l = t.length(); i < l; i++) {
            hash[t.charAt(i)]++;
        }

        for (int i = 0, l = t.length() - 1; i < l; i++) {
            curr[s.charAt(i)]++;
        }

        for (int i = 0, j = t.length() - 1, l = s.length(); j < l; ) {
            curr[s.charAt(j)]++;
            if (isMatch()) {
                if (j - i < min) {
                    min = j - i;
                    start = i;
                    end = j;
                }
                while (j > i) {
                    curr[s.charAt(i)]--;
                    i++;
                    if (isMatch()) {
                        if (j - i < min) {
                            min = j - i;
                            start = i;
                            end = j;
                        }
                    } else break;
                }
            }
            j++;
        }
        if (min == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(start, end + 1);
    }

    private boolean isMatch() {
        for (int i = 0; i < 256; i++) {
            if (curr[i] < hash[i]) {
                return false;
            }
        }
        return true;
    }

    // 14 ms
    public String minWindow2(String s, String t) {
        HashMap<Character, Integer> goal = new HashMap<>();
        int goalSize = t.length();
        int minLen = Integer.MAX_VALUE;
        String result = "";

        //target dictionary
        for (int k = 0; k < t.length(); k++) {
            goal.put(t.charAt(k), goal.getOrDefault(t.charAt(k), 0) + 1);
        }

        int i = 0;
        int total = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            if (!goal.containsKey(c)) {
                continue;
            }

            //if c is a target character in the goal, and count is < goal, increase the total
            int count = map.getOrDefault(c, 0);
            if (count < goal.get(c)) {
                total++;
            }

            map.put(c, count + 1);

            //when total reaches the goal, trim from left until no more chars can be trimmed.
            if (total == goalSize) {
                while (!goal.containsKey(s.charAt(i)) || map.get(s.charAt(i)) > goal.get(s.charAt(i))) {
                    char pc = s.charAt(i);
                    if (goal.containsKey(pc) && map.get(pc) > goal.get(pc)) {
                        map.put(pc, map.get(pc) - 1);
                    }

                    i++;
                }

                if (minLen > j - i + 1) {
                    minLen = j - i + 1;
                    result = s.substring(i, j + 1);
                }
            }
        }

        return result;
    }

    // 4 ms
    public String minWindow3(String s, String t) {
        int N = s.length(), M = t.length();
        if (N < M) return new String("");
        int[] need = new int[256];
        int[] find = new int[256];
        for (int i = 0; i < M; ++i)
            need[t.charAt(i)]++;

        int count = 0, resStart = -1, resEnd = N;
        for (int start = 0, end = 0; end < N; ++end) {
            if (need[s.charAt(end)] == 0)
                continue;
            if (find[s.charAt(end)] < need[s.charAt(end)])
                count++;
            find[s.charAt(end)]++;
            if (count != M) continue;
            // move 'start'
            for (; start < end; ++start) {
                if (need[s.charAt(start)] == 0) continue;
                if (find[s.charAt(start)] <= need[s.charAt(start)]) break;
                find[s.charAt(start)]--;
            }
            // update result
            if (end - start < resEnd - resStart) {
                resStart = start;
                resEnd = end;
            }
        }
        return (resStart == -1) ? new String("") : s.substring(resStart, resEnd + 1);
    }
}
