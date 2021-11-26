package com.f21a.algorithm.backtrack;

/*
Given an input string s and a pattern p, implement regular expression matching with support
for '.' and '*' where:
'.' Matches any single character.
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).

Example 1:
Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".

Example 2:
Input: s = "aa", p = "a*"
Output: true
Explanation: '*' means zero or more of the preceding element, 'a'.
Therefore, by repeating 'a' once, it becomes "aa".

Example 3:
Input: s = "ab", p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".

Example 4:
Input: s = "aab", p = "c*a*b"
Output: true
Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches "aab".

Example 5:
Input: s = "mississippi", p = "mis*is*p*."
Output: false

Constraints:

1 <= s.length <= 20
1 <= p.length <= 30
s contains only lowercase English letters.
p contains only lowercase English letters, '.', and '*'.
It is guaranteed for each appearance of the character '*', there will be a previous valid character to match.
 */

public class RegularExpressionMatching {

    /*
    Dynamic Programming (commonly referred to as DP) is an algorithmic technique for solving a problem
    by recursively breaking it down into simpler subproblems and using the fact that the optimal
    solution to the overall problem depends upon the optimal solution to it's individual subproblems.
     */

    // 11/20/21: 2 ms
    // Dynamic Programming
    // Time: O(m*n)
    // Space: O(m*n)
    // more explanation, see https://www.youtube.com/watch?v=l3hda49XcDE
    public boolean isMatch(String s, String p) {
        // corner case
        if (s == null || p == null) return false;

        int m = s.length();
        int n = p.length();

        // M[i][j] represents if the 1st i characters in s can match the 1st j characters in p
        // s[1]: first character in s
        // p[1]: first character in p
        boolean[][] M = new boolean[m + 1][n + 1];

        // initialization:
        // 1. M[0][0] = true, since empty string matches empty pattern
        M[0][0] = true;

        // 2. M[i][0] = false(which is default value of the boolean array) since empty pattern cannot match non-empty string
        // 3. M[0][j]: what pattern matches empty string ""? It should be #*#*#*#*..., or (#*)* if allow me to represent regex using regex :P,
        // and for this case we need to check manually:
        // as we can see, the length of pattern should be even && the character at the even position should be *,
        // thus for odd length, M[0][j] = false which is default. So we can just skip the odd position, i.e. j starts from 2, the interval of j is also 2.
        // and notice that the length of repeat sub-pattern #* is only 2, we can just make use of M[0][j - 2] rather than scanning j length each time
        // for checking if it matches #*#*#*#*.
        for (int j = 2; j < n + 1; j += 2) {
            if (p.charAt(j - 1) == '*' && M[0][j - 2]) {
                M[0][j] = true;
            }
        }

        // Induction rule is very similar to edit distance, where we also consider from the end. And it is based on what character in the pattern we meet.
        // 1. if p.charAt(j) == s.charAt(i), M[i][j] = M[i - 1][j - 1]
        //    ######a(i)
        //    ####a(j)
        // 2. if p.charAt(j) == '.', M[i][j] = M[i - 1][j - 1]
        // 	  #######a(i)
        //    ####.(j)
        // 3. if p.charAt(j) == '*':
        //    1. if p.charAt(j - 1) != '.' && p.charAt(j - 1) != s.charAt(i), then b* is counted as empty. M[i][j] = M[i][j - 2]
        //       #####a(i)
        //       ####b*(j)
        //    2.if p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i):
        //       ######a(i)
        //       ####.*(j)
        //
        // 	  	 #####a(i)
        //    	 ###a*(j)
        //      2.1 if p.charAt(j - 1) is counted as empty, then M[i][j] = M[i][j - 2]
        //      2.2 if counted as one, then M[i][j] = M[i - 1][j - 2]
        //      2.3 if counted as multiple, then M[i][j] = M[i - 1][j]

        // recap:
        // M[i][j] = M[i - 1][j - 1]
        // M[i][j] = M[i - 1][j - 1]
        // M[i][j] = M[i][j - 2]
        // M[i][j] = M[i][j - 2]
        // M[i][j] = M[i - 1][j - 2]
        // M[i][j] = M[i - 1][j]
        // Observation: from above, we can see to get M[i][j], we need to know previous elements in M, i.e. we need to compute them first.
        // which determines i goes from 1 to m + 1, j goes from 1 to n + 1

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                char curS = s.charAt(i - 1);
                char curP = p.charAt(j - 1);
                if (curS == curP || curP == '.') {
                    M[i][j] = M[i - 1][j - 1];
                } else if (curP == '*') {
                    char preCurP = p.charAt(j - 2);
                    if (preCurP != '.' && preCurP != curS) {
                        M[i][j] = M[i][j - 2];
                    } else {
                        M[i][j] = (M[i][j - 2] || M[i - 1][j - 2] || M[i - 1][j]);
                    }
                }
            }
        }

        return M[m][n];
    }

    // 11/20/21: 6 ms
    public boolean isMatch2(String s, String p) {
        int lens = s.length();
        int lenp = p.length();
        if (lens == 0 && lenp == 0) return true;

        boolean[] last = new boolean[lenp + 1]; //last[j] means if p[1~j] matches s[1~i-1]
        boolean[] cur = new boolean[lenp + 1]; //last[j] means if p[1~j] matches s[1~i]
        last[0] = cur[0] = true;
        // for string like "a*b*c*", make last/cur[indexOf('*')]=true.
        for (int j = 1; j <= lenp; j++) {
            if (j >= 2 && p.charAt(j - 1) == '*' && last[j - 2]) {
                last[j] = cur[j] = true;
            }
        }

        for (int i = 1; i <= lens; i++) {
            // determine if p[1~j] matches s[1~i].
            cur[0] = false;
            for (int j = 1; j <= lenp; j++) {
                // three cases:
                // 1) p[j]==s[i] (include p[j]=='.') and p[1~j-1] matches s[1~i-1];
                // 2) p[j-1~j]="x*" and s[i]='x' and p[1~j] matches s[1~i-1];
                // 3) p[j-2~j]="xy*" and p[1~j-2] matches s[1~i].
                cur[j] = (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.') && last[j - 1]
                        || p.charAt(j - 1) == '*' && (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.') && last[j]
                        || j >= 2 && p.charAt(j - 1) == '*' && cur[j - 2];
            }
            for (int j = 0; j <= lenp; j++) {
                last[j] = cur[j];
            }
        }

        return cur[lenp];
    }


    // 11/20/21: 18 ms
    public boolean isMatch3(String s, String p) {
        return isMatchRecursive(0, s, 0, p);
    }

    private boolean isMatchRecursive(int i, String s, int j, String p) {
        int sn = s.length(), pn = p.length();
        if (j == pn) { // since * in p can match 0 of previous char, so empty string(i==sn) may match p
            return i == sn;
        }
        char pj = p.charAt(j);
        if (j + 1 < pn && p.charAt(j + 1) == '*') { //match *, needs to look at the next char to repeat current char
            if (isMatchRecursive(i, s, j + 2, p)) {
                return true;
            }
            while (i < sn && (pj == '.' || pj == s.charAt(i))) {
                if (isMatchRecursive(++i, s, j + 2, p)) {
                    return true;
                }
            }
        } else if (i < sn && (s.charAt(i) == pj ||    //match char
                pj == '.')) {              //match dot
            return isMatchRecursive(i + 1, s, j + 1, p);
        }
        return false;
    }
}
