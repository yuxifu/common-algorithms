package com.f21a.algorithm.graph;

import java.util.*;

/*
There is a new alien language that uses the English alphabet. However, the order among
the letters is unknown to you.

You are given a list of strings words from the alien language's dictionary, where
the strings in words are sorted lexicographically by the rules of this new language.

Return a string of the unique letters in the new alien language sorted in
lexicographically increasing order by the new language's rules. If there is no
solution, return "". If there are multiple solutions, return any of them.

A string s is lexicographically smaller than a string t if at the first letter
where they differ, the letter in s comes before the letter in t in the alien language.
If the first min(s.length, t.length) letters are the same, then s is smaller if and
only if s.length < t.length.

Example 1:
Input: words = ["wrt","wrf","er","ett","rftt"]
Output: "wertf"

Example 2:
Input: words = ["z","x"]
Output: "zx"

Example 3:
Input: words = ["z","x","z"]
Output: ""
Explanation: The order is invalid, so return "".

Example 4:
Input: words = ["abc","ab"]
Output: ""
*/
public class AlienDictionary {

    /*
    First, build a degree map for each character in all the words:
    w:0
    r:0
    t:0
    f:0
    e:0
    Then build the hashmap by comparing the adjacent words, the first character that is
    different between two adjacent words reflect the lexicographical order. For example:

     "wrt",
     "wrf",
        first different character is 3rd letter, so t comes before f

     "wrf",
     "er",
        first different character is 1rd letter, so w comes before e

    The characters in set come after the key. x->y means letter x comes before letter y.
    x -> set: y,z,t,w means x comes before all the letters in the set. The final HashMap
    "map" looks like.

    t -> set: f
    w -> set: e
    r -> set: t
    e -> set: r

    and final HashMap "degree" looks like, the number means "how many letters come before
    the key":

    w:0
    r:1
    t:1
    f:1
    e:1

    Then use Kahn's algorithm to do topological sort. This is essentially BFS.
    https://en.wikipedia.org/wiki/Topological_sorting
     */
    public String alienOrder(String[] words) {

        // Set<Character> includes all chars come after Character
        Map<Character, Set<Character>> orderMap = new HashMap<Character, Set<Character>>();

        // How many times a char is after some other chars
        Map<Character, Integer> degree = new HashMap<Character, Integer>();

        // validate input data
        if (words == null || words.length == 0) return "";

        // set all degrees to 0
        for (String s : words) {
            for (char c : s.toCharArray()) {
                degree.put(c, 0);
            }
        }

        // build degree and order maps
        for (int i = 0; i < words.length - 1; i++) {

            // take each neighboring word pairs
            String cur = words[i];
            String next = words[i + 1];

            // take the smaller length of the pair
            int length = Math.min(cur.length(), next.length());

            // compare chars one by one until a difference is found
            boolean differenceFound = false;
            for (int j = 0; j < length; j++) {
                char c1 = cur.charAt(j);
                char c2 = next.charAt(j);
                if (c1 != c2) {
                    differenceFound = true;

                    // c1 comes before c2 because of the lexicographical order
                    Set<Character> set = new HashSet<Character>();

                    // get set c1 if exists
                    if (orderMap.containsKey(c1)) set = orderMap.get(c1);

                    // add c2 if not in the set
                    if (!set.contains(c2)) {

                        // add c2 to c1 set
                        set.add(c2);
                        orderMap.put(c1, set);

                        // how many times c2 is after some other char
                        degree.put(c2, degree.get(c2) + 1);
                    }
                    break;
                }
            }
            // test case ["abc","ab"].  Invalid order.
            if (!differenceFound && cur.length() > next.length()) {
                return "";
            }
        }

        // sort
        Queue<Character> q = new LinkedList<Character>();

        // get the char without any other chat before. It's the first char in the alphabet.
        for (char c : degree.keySet()) {
            if (degree.get(c) == 0) q.add(c);
        }

        //
        String result = "";
        while (!q.isEmpty()) {
            char c = q.remove();
            result += c;
            if (orderMap.containsKey(c)) {
                for (char c2 : orderMap.get(c)) {

                    // remove c from the degree of c2
                    degree.put(c2, degree.get(c2) - 1);

                    // c2 is the next char without any other chat before
                    if (degree.get(c2) == 0) q.add(c2);
                }
            }
        }

        // invalid order
        if (result.length() != degree.size()) return "";

        //
        return result;
    }

    // solve with a graph
    private final int N = 26;

    public String alienOrder2(String[] words) {
        boolean[][] adj = new boolean[N][N];
        int[] visited = new int[N];

        if (!buildGraph(words, adj, visited)) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (visited[i] == 0) {                 // unvisited
                if (!dfs(adj, visited, sb, i)) return "";
            }
        }
        return sb.reverse().toString();
    }

    public boolean dfs(boolean[][] adj, int[] visited, StringBuilder sb, int i) {
        visited[i] = 1;                            // 1 = visiting
        for (int j = 0; j < N; j++) {
            if (adj[i][j]) {                        // connected
                if (visited[j] == 1) return false;  // 1 => 1, cycle
                if (visited[j] == 0) {              // 0 = unvisited
                    if (!dfs(adj, visited, sb, j)) return false;
                }
            }
        }
        visited[i] = 2;                           // 2 = visited
        sb.append((char) (i + 'a'));
        return true;
    }

    public boolean buildGraph(String[] words, boolean[][] adj, int[] visited) {
        Arrays.fill(visited, -1);                 // -1 = not even existed
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) visited[c - 'a'] = 0;
            if (i > 0) {
                String w1 = words[i - 1], w2 = words[i];
                if ((w1.length() > w2.length()) && (w1.startsWith(w2))) {
                    return false;
                }
                int len = Math.min(w1.length(), w2.length());
                for (int j = 0; j < len; j++) {
                    char c1 = w1.charAt(j), c2 = w2.charAt(j);
                    if (c1 != c2) {
                        adj[c1 - 'a'][c2 - 'a'] = true;
                        break;
                    }
                }
            }
        }
        return true;
    }

}
