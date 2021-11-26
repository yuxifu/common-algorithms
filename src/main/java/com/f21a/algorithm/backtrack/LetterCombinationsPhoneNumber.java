package com.f21a.algorithm.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that
the number could represent. Return the answer in any order.

A mapping of digit to letters (just like on the telephone buttons) is given below.
Note that 1 does not map to any letters.

String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

Example 1:
Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

Example 2:
Input: digits = ""
Output: []

Example 3:
Input: digits = "2"
Output: ["a","b","c"]

Constraints:
0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].
 */
public class LetterCombinationsPhoneNumber {
    // Time: O(4^n)
    // Space: O(4^n)
    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        if (digits.isEmpty()) return ans;
        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for (int i = 0; i < digits.length(); i++) {
            int x = Character.getNumericValue(digits.charAt(i));
            while (ans.peek().length() == i) {
                String t = ans.remove();
                for (char s : mapping[x].toCharArray())
                    ans.add(t + s);
            }
        }
        return ans;
    }

    // Backtrack
    public List<String> letterCombinations2(String digits) {
        String[] KEYPAD = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        StringBuilder sb = new StringBuilder();
        List<String> res = new ArrayList<>();
        dfs(sb, 0, digits, KEYPAD, res);

        return res;
    }

    private void dfs(StringBuilder sb, int index, String digits, String[] keypad, List<String> res) {
        if (index == digits.length()) {
            if (sb.length() != 0) {
                res.add(sb.toString());
            }
            return;
        }

        String options = keypad[digits.charAt(index) - '0'];
        for (char option : options.toCharArray()) {
            sb.append(option);
            dfs(sb, index + 1, digits, keypad, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
