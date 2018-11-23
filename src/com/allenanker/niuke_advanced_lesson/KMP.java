package com.allenanker.niuke_advanced_lesson;

public class KMP {
    /**
     * Return the first index that str2 appears in str1, or -1 if it does not exists.
     *
     * @param str1
     * @param str2
     * @return
     */
    public static int KMPSearch(String str1, String str2) {
        if (str1 == null || str2 == null || str1.trim().equals("") || str2.trim().equals("")) {
            return -1;
        }

        int[] steps = getSteps(str2);
//        int[] steps = new int[]{-1, 0, 1, 2};
        // start matching from index at str1 each time, it will change it does not match
        int index = 0;
        int res = 0;
        int i = 0;
        char a, b;
        while (i < str2.length()) {
            a = str1.charAt(index);
            b = str2.charAt(i);
            // if the current character does not match, adjust the current start matching position
            if (a != b) {
                if (steps[i] == -1) {
                    index++;
                    res = index;
                } else {
                    res = index - steps[i];
                    i = steps[i];
                }
                continue;
            } else {
                index++;
                i++;
            }
            if (i == str2.length()) {
                return res;
            }
        }

        return -1;
    }

    /**
     * Calculate the longest equal prefix and postfix of the string before each index.
     * The info that is needed to implement KMP.
     *
     * @param s
     * @return
     */
    private static int[] getSteps(String s) {
        if (s == null || s.trim().equals("")) {
            return null;
        }

        if (s.length() == 1) {
            return new int[]{-1};
        }
        if (s.length() == 2) {
            return new int[]{-1, 0};
        }
        int[] res = new int[s.length()];
        res[0] = -1;
        res[1] = 0;
        int to = 0;
        int i = 2;
        while (i < s.length()) {
            if (s.charAt(i - 1) == s.charAt(to)) {
                res[i++] = ++to;
            } else if (to > 0) {
                to = res[to];
            } else {
                res[i++] = 0;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String str1 = "aaaaaab";
        String str2 = "aaab";
        System.out.println(KMPSearch(str1, str2));
    }
}
