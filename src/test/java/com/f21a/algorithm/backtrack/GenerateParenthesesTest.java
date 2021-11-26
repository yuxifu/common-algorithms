package com.f21a.algorithm.backtrack;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class GenerateParenthesesTest {
    /*
    Example 1:
    Input: n = 3
    Output: ["((()))","(()())","(())()","()(())","()()()"]

    Example 2:
    Input: n = 1
    Output: ["()"]

    Example 3:
    Input: n = 4
    Output: ["(((())))","((()()))","((())())","((()))()","(()(()))","(()()())","(()())()","(())(())","(())()()","()((()))","()(()())","()(())()","()()(())","()()()()"]
     */
    @Test
    public void testGenerateParenthesesExamples() {
        List<String> result1 = new GenerateParentheses().generateParenthesis(3);
        assertEquals(new HashSet<>(Arrays.asList("((()))", "(()())", "(())()", "()(())", "()()()"))
                , new HashSet<>(result1));

        List<String> result2 = new GenerateParentheses().generateParenthesis(1);
        assertEquals(new HashSet<>(Arrays.asList("()")), new HashSet<>(result2));

        List<String> result3 = new GenerateParentheses().generateParenthesis(4);
        Collections.sort(result3);
        List<String> target3 = Arrays.asList("(((())))", "((()()))", "((())())", "((()))()",
                "(()(()))", "(()()())", "(()())()", "(())(())", "(())()()", "()((()))", "()(()())",
                "()(())()", "()()(())", "()()()()");
        Collections.sort(target3);
        assertEquals(target3, result3);
    }

    @Test
    public void testGenerateParentheses2Examples() {
        List<String> result1 = new GenerateParentheses().generateParenthesis2(3);
        assertEquals(new HashSet<>(Arrays.asList("((()))", "(()())", "(())()", "()(())", "()()()"))
                , new HashSet<>(result1));

        List<String> result2 = new GenerateParentheses().generateParenthesis2(1);
        assertEquals(new HashSet<>(Arrays.asList("()")), new HashSet<>(result2));

        List<String> result3 = new GenerateParentheses().generateParenthesis2(4);
        Collections.sort(result3);
        List<String> target3 = Arrays.asList("(((())))", "((()()))", "((())())", "((()))()",
                "(()(()))", "(()()())", "(()())()", "(())(())", "(())()()", "()((()))", "()(()())",
                "()(())()", "()()(())", "()()()()");
        Collections.sort(target3);
        assertEquals(target3, result3);
    }
}
