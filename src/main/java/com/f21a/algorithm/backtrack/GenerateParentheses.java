package com.f21a.algorithm.backtrack;

import java.util.ArrayList;
import java.util.List;

/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

Example 1:
Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]

Example 2:
Input: n = 1
Output: ["()"]

Example 3:
Input: n = 4
Output: ["(((())))","((()()))","((())())","((()))()","(()(()))","(()()())","(()())()","(())(())","(())()()","()((()))","()(()())","()(())()","()()(())","()()()()"]

Constraints:
1 <= n <= 8
 */

public class GenerateParentheses {

    /*
    The idea here is to only add '(' and ')' that we know will guarantee us a solution (instead of adding 1
    too many close). Once we add a '(' we will then discard it and try a ')' which can only close a valid '('.
    Each of these steps are recursively called.
     */
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    public void backtrack(List<String> list, String str, int open, int close, int max) {

        if (str.length() == max * 2) {
            list.add(str);
            return;
        }

        if (open < max)
            backtrack(list, str + "(", open + 1, close, max);
        if (close < open)
            backtrack(list, str + ")", open, close + 1, max);
    }

    public List<String> generateParenthesis2(int n) {
        List<String> ret = new ArrayList<String>(), inner, outter;
        if (n == 0) {
            ret.add("");
            return ret;
        }
        if (n == 1) {
            ret.add("()");
            return ret;
        }
        for (int i = 0; i < n; ++i) {
            inner = generateParenthesis(i);
            outter = generateParenthesis(n - i - 1);
            for (int j = 0; j < inner.size(); ++j) {
                for (int k = 0; k < outter.size(); ++k) {
                    ret.add("(" + inner.get(j) + ")" + outter.get(k));
                }
            }
        }
        return ret;
    }
}
