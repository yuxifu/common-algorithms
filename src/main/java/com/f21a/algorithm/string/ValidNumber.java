package com.f21a.algorithm.string;

/**
 * A valid number can be split up into these components (in order):
 * <p>
 * A decimal number or an integer.
 * (Optional) An 'e' or 'E', followed by an integer.
 * A decimal number can be split up into these components (in order):
 * <p>
 * (Optional) A sign character (either '+' or '-').
 * One of the following formats:
 * One or more digits, followed by a dot '.'.
 * One or more digits, followed by a dot '.', followed by one or more digits.
 * A dot '.', followed by one or more digits.
 * An integer can be split up into these components (in order):
 * <p>
 * (Optional) A sign character (either '+' or '-').
 * One or more digits.
 * For example, all the following are valid numbers: ["2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"], while the following are not valid numbers: ["abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"].
 * <p>
 * Given a string s, return true if s is a valid number.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "0"
 * Output: true
 * Example 2:
 * <p>
 * Input: s = "e"
 * Output: false
 * Example 3:
 * <p>
 * Input: s = "."
 * Output: false
 * Example 4:
 * <p>
 * Input: s = ".1"
 * Output: true
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 20
 * s consists of only English letters (both uppercase and lowercase), digits (0-9), plus '+', minus '-', or dot '.'.
 */
public class ValidNumber {

    public static void main(String[] args) {
        String s = "1E9";
        boolean b = new ValidNumber().isNumber(s);
        System.out.println(b);
    }

    /**
     * We start with trimming.
     * <p>
     * If we see [0-9] we reset the number flags.
     * We can only see . if we didn't see e or ..
     * We can only see e if we didn't see e but we did see a number. We reset numberAfterE flag.
     * We can only see + and - in the beginning and after an e
     * any other character break the validation.
     * At the and it is only valid if there was at least 1 number and if we did see an e then a number after it as well.
     * <p>
     * So basically the number should match this regular expression:
     * <p>
     * [-+]?(([0-9]+(.[0-9]*)?)|.[0-9]+)(e[-+]?[0-9]+)?
     */
    public boolean isNumber(String s) {
        s = s.trim().toLowerCase();

        boolean pointSeen = false;
        boolean eSeen = false;
        boolean numberSeen = false;
        boolean numberAfterE = true;
        for (int i = 0; i < s.length(); i++) {
            if ('0' <= s.charAt(i) && s.charAt(i) <= '9') {
                numberSeen = true;
                numberAfterE = true;
            } else if (s.charAt(i) == '.') {
                if (eSeen || pointSeen) {
                    return false;
                }
                pointSeen = true;
            } else if (s.charAt(i) == 'e') {
                if (eSeen || !numberSeen) {
                    return false;
                }
                numberAfterE = false;
                eSeen = true;
            } else if (s.charAt(i) == '-' || s.charAt(i) == '+') {
                if (i != 0 && s.charAt(i - 1) != 'e') {
                    return false;
                }
            } else {
                return false;
            }
        }

        return numberSeen && numberAfterE;
    }
}
