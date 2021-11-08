package com.f21a.algorithm.string;

import java.util.Stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "()"
 * Output: true
 * Example 2:
 * <p>
 * Input: s = "()[]{}"
 * Output: true
 * Example 3:
 * <p>
 * Input: s = "(]"
 * Output: false
 * Example 4:
 * <p>
 * Input: s = "([)]"
 * Output: false
 * Example 5:
 * <p>
 * Input: s = "{[]}"
 * Output: true
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 104
 * s consists of parentheses only '()[]{}'.
 */
public class ValidParentheses {

    public static void main(String[] args) {
        String s = "{[]}";
        boolean b = new ValidParentheses().isValid(s);
        System.out.println(b);
    }

    /**
     *
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
}
