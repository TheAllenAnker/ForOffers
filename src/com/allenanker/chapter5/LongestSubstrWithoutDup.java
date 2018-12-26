package com.allenanker.chapter5;

import java.util.HashMap;

public class LongestSubstrWithoutDup {
    public static int lengthOfLongestSubstrWithoutDup(String str) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("Invalid parameter str");
        }

        int res = 1;
        int start = 0;
        HashMap<Character, Integer> indexMap = new HashMap<>();
        indexMap.put(str.charAt(0), 0);
        for (int i = 1; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!indexMap.containsKey(c)) {
                indexMap.put(c, i);
            } else {
                int lastIndex = indexMap.get(c);
                if (lastIndex >= start) {
                    start = lastIndex + 1;
                    res = Math.max(res, i - 1 - start);
                }
                indexMap.put(c, i);
            }
        }
        res = Math.max(res, str.length() - start);

        return res;
    }

    public static void main(String[] args) {
        String str = "arabcacfr";
        System.out.println(lengthOfLongestSubstrWithoutDup(str));
    }
}
