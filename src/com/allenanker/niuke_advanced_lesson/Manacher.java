package com.allenanker.niuke_advanced_lesson;

import java.util.HashMap;

public class Manacher {
    public static int longestAnagramInStr(String str) {
        if (str == null || str.trim().equals("")) {
            return 0;
        }

        // process the input str so that it produce correct result in odd or even length
        StringBuilder builder = new StringBuilder();
        builder.append("#");
        for (int i = 0; i < str.length(); i++) {
            builder.append(str.charAt(i)).append("#");
        }
        String processedStr = builder.toString();

        int rightBound = -1;
        int center = -1;
        HashMap<Integer, Integer> radiusMap = new HashMap<>();
        int l, r;
        for (int i = 0; i < processedStr.length(); i++) {
            // if the current position is outside the current right bound
            if (i > rightBound) {
                l = i - 1;
                r = i + 1;
                int currRightBound = i;
                while (l >= 0 && r < processedStr.length() && processedStr.charAt(l) == processedStr.charAt(r)) {
                    currRightBound++;
                    l--;
                    r++;
                }
                // update the current right bound and its corresponding center
                // store the radius of position i
                rightBound = currRightBound;
                center = i;
                radiusMap.put(i, currRightBound - i);
            } else {
                // the i symmetry's index
                int iSymmetry = center - (i - center);
                int symLeftBound = iSymmetry - radiusMap.get(iSymmetry);
                int currLeftBound = center - radiusMap.get(center);
                if (symLeftBound > currLeftBound) {
                    radiusMap.put(i, radiusMap.get(iSymmetry));
                } else if (symLeftBound < currLeftBound) {
                    radiusMap.put(i, iSymmetry - currLeftBound);
                } else {
                    r = rightBound + 1;
                    l = i - (rightBound - i) - 1;
                    int currRightBound = rightBound;
                    while (l >= 0 && r < processedStr.length() && processedStr.charAt(l) == processedStr.charAt(r)) {
                        currRightBound++;
                        l--;
                        r++;
                    }
                    // update the current right bound and its corresponding center
                    // store the radius of position i
                    center = currRightBound > rightBound ? i : center;
                    rightBound = currRightBound;
                    radiusMap.put(i, currRightBound - i);
                }
            }
        }

        // find the largest radius and return
        int max = Integer.MIN_VALUE;
        for (int radius : radiusMap.values()) {
            if (radius > max) {
                max = radius;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestAnagramInStr("1223221"));
    }
}
