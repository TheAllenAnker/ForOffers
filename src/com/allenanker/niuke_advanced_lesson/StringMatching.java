package com.allenanker.niuke_advanced_lesson;

public class StringMatching {
    public static boolean match(String str, String exp) {
        if (str == null || exp == null || str.length() == 0 || exp.length() == 0) {
            return false;
        }

        return process(str.toCharArray(), exp.toCharArray(), 0, 0);
    }

    private static boolean process(char[] str, char[] exp, int i, int j) {
        // str and exp starts matching from i and j respectively
        if (j == exp.length) {
            return i == str.length;
        }
        if (j + 1 == exp.length || exp[j + 1] != '*') {
            return i != str.length && (exp[j] == str[i] || exp[j] == '.') && process(str, exp, i + 1, j + 1);
        }
        // exp[j+1] == '*', '*' match 0 or more
        while (i != str.length && (exp[j] == '.' || exp[j] == str[i])) {
            if (process(str, exp, i, j + 2)) {
                return true;
            }
            i++;
        }

        return process(str, exp, i, j + 2);
    }

    public static void main(String[] args) {
        String str = "asdf";
        String exp = "as.f*";
        System.out.println(match(str, exp));
    }
}
