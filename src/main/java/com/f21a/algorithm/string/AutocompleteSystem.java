package com.f21a.algorithm.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Design a search autocomplete system for a search engine. Users may input a sentence
 * (at least one word and end with a special character '#').
 * <p>
 * You are given a string array sentences and an integer array times both of length n
 * where sentences[i] is a previously typed sentence and times[i] is the corresponding number of times the sentence was
 * typed. For each input character except '#', return the top 3 historical hot sentences that have the same prefix as the
 * part of the sentence already typed.
 * <p>
 * Here are the specific rules:
 * <p>
 * The hot degree for a sentence is defined as the number of times a user typed the exactly same sentence before.
 * <p>
 * The returned top 3 hot sentences should be sorted by hot degree (The first is the hottest one). If several sentences
 * have the same hot degree, use ASCII-code order (smaller one appears first).
 * <p>
 * If less than 3 hot sentences exist, return as many as you can.
 * <p>
 * When the input is a special character, it means the sentence ends, and in this case, you need to return an empty list.
 * <p>
 * Implement the AutocompleteSystem class:
 * <p>
 * AutocompleteSystem(String[] sentences, int[] times) Initializes the object with the sentences and times arrays.
 * <p>
 * List<String> input(char c) This indicates that the user typed the character c.
 * Returns an empty array [] if c == '#' and stores the inputted sentence in the system.
 * Returns the top 3 historical hot sentences that have the same prefix as the part of the sentence already typed. If
 * there are fewer than 3 matches, return them all.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input
 * ["AutocompleteSystem", "input", "input", "input", "input"]
 * [[["i love you", "island", "iroman", "i love leetcode"], [5, 3, 2, 2]], ["i"], [" "], ["a"], ["#"]]
 * <p>
 * Output
 * [null, ["i love you", "island", "i love leetcode"], ["i love you", "i love leetcode"], [], []]
 * <p>
 * Explanation
 * AutocompleteSystem obj = new AutocompleteSystem(["i love you", "island", "iroman", "i love leetcode"], [5, 3, 2, 2]);
 * obj.input("i"); // return ["i love you", "island", "i love leetcode"]. There are four sentences that have prefix "i".
 * Among them, "ironman" and "i love leetcode" have same hot degree. Since ' ' has ASCII code 32 and 'r' has ASCII code
 * 114, "i love leetcode" should be in front of "ironman". Also we only need to output top 3 hot sentences, so "ironman"
 * will be ignored.
 * <p>
 * obj.input(" "); // return ["i love you", "i love leetcode"]. There are only two sentences that have prefix "i ".
 * <p>
 * obj.input("a"); // return []. There are no sentences that have prefix "i a".
 * <p>
 * obj.input("#"); // return []. The user finished the input, the sentence "i a" should be saved as a historical sentence
 * in system. And the following input will be counted as a new search.
 */

public class AutocompleteSystem {

    /**
     * Main method
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        String[] sentences = {"i love you", "island", "ironman", "i love leetcode"};
        int[] degree = {5, 3, 2, 2};
        AutocompleteSystem autocomplete = new AutocompleteSystem(sentences, degree);

        System.out.println("input = " + 'i');
        List<String> result = autocomplete.input('i');
        result.forEach(System.out::println);

        System.out.println("input = " + "");
        result = autocomplete.input(' ');
        result.forEach(System.out::println);

        System.out.println("input = " + 'a');
        result = autocomplete.input('a');
        result.forEach(System.out::println);

        System.out.println("input = " + '#');
        result = autocomplete.input('#');
        result.forEach(System.out::println);
    }

    class TrieNode implements Comparable<TrieNode> {
        TrieNode[] children;
        String s;
        int times;
        List<TrieNode> hot;

        public TrieNode() {
            children = new TrieNode[128];
            s = null;
            times = 0;
            hot = new ArrayList<>();
        }

        public int compareTo(TrieNode o) {
            if (this.times == o.times) {
                return this.s.compareTo(o.s);
            }

            return o.times - this.times;
        }

        public void update(TrieNode node) {
            if (!this.hot.contains(node)) {
                this.hot.add(node);
            }

            Collections.sort(hot);

            if (hot.size() > 3) {
                hot.remove(hot.size() - 1);
            }
        }
    }

    TrieNode root;
    TrieNode cur;
    StringBuilder sb;

    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        cur = root;
        sb = new StringBuilder();

        for (int i = 0; i < times.length; i++) {
            add(sentences[i], times[i]);
        }
    }


    public void add(String sentence, int t) {
        TrieNode tmp = root;

        List<TrieNode> visited = new ArrayList<>();
        for (char c : sentence.toCharArray()) {
            if (tmp.children[c] == null) {
                tmp.children[c] = new TrieNode();
            }

            tmp = tmp.children[c];
            visited.add(tmp);
        }

        tmp.s = sentence;
        tmp.times += t;

        for (TrieNode node : visited) {
            node.update(tmp);
        }
    }

    public List<String> input(char c) {
        List<String> res = new ArrayList<>();
        if (c == '#') {
            add(sb.toString(), 1);
            sb = new StringBuilder();
            cur = root;
            return res;
        }

        sb.append(c);
        if (cur != null) {
            cur = cur.children[c];
        }

        if (cur == null) return res;
        for (TrieNode node : cur.hot) {
            res.add(node.s);
        }

        return res;
    }
}
