package com.allenanker.chapter5;

public class TranslateNumbersToStrs {
    /**
     * Solution 2: iterate the number string from the end of the string.
     * Using dynamic programming
     *
     * @param num
     * @return
     */
    public static int numberOfWaysToTranslate_v2(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("Parameter must not be smaller than zero");
        }
        if (num < 10) {
            return 1;
        }

        String numStr = Integer.toString(num);
        int length = numStr.length();
        int[] res = new int[length]; // this is the dp array
        int count;
        for (int i = length - 1; i >= 0; i--) {
            if (i < length - 1) {
                count = res[i + 1];
            } else {
                count = 1;
            }
            if (i < length - 1) {
                int concatNum = Integer.parseInt(numStr.substring(i, i + 2));
                if (concatNum >= 10 && concatNum <= 25) {
                    if (i < length - 2) {
                        count += res[i + 2];
                    } else {
                        count += 1;
                    }
                }
            }
            res[i] = count;
        }

        return res[0];
    }

    /**
     * Translate number 0 to 'a', 1 to 'b', 2 to 'c', ..., 25 to 'z'.
     * Given a number, return the number of ways to translate it.
     *
     * @param num the given number
     * @return
     */
    public static int numberOfWaysToTranslate(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("Parameter must not be smaller than zero");
        }
        if (num < 10) {
            return 1;
        }

        return waysCore(Integer.toString(num));
    }

    /**
     * Solution 1, using recursion and recalculate a lot or duplicate values.
     *
     * @param numStr
     * @return
     */
    private static int waysCore(String numStr) {
        if (numStr == null) {
            throw new IllegalArgumentException("Invalid parameter numStr");
        }

        if (numStr.length() == 0 || Integer.parseInt(numStr) < 10) {
            return 1;
        }
        if (numStr.length() >= 2) {
            if (Integer.parseInt(numStr.substring(0, 2)) > 9 && Integer.parseInt(numStr.substring(0, 2)) < 26) {
                return waysCore(numStr.substring(1)) + waysCore(numStr.substring(2));
            }
        }

        return waysCore(numStr.substring(1));
    }

    public static void main(String[] args) {
        int num = 12258;
        System.out.println(numberOfWaysToTranslate(num));
        System.out.println(numberOfWaysToTranslate_v2(num));
    }
}
