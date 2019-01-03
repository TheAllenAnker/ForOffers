package com.allenanker.chapter6;

public class LeftRotateString {
    public String getLeftRotateString(String str, int rotateNum) {
        if (str == null || str.trim().length() == 0 || rotateNum <= 0 || rotateNum == str.length()) {
            return str;
        }
        if (rotateNum > str.length()) {
            throw new IllegalArgumentException("Invalid parameter rotateNum");
        }

        String processedStr = str.substring(0, rotateNum) + " " + str.substring(rotateNum);
        ReverseWordsInSentence rwis = new ReverseWordsInSentence();
        String res = rwis.reverseWordsOrder(processedStr);
        res = res.substring(0, res.length() - rotateNum - 1) + res.substring(res.length() - rotateNum);

        return res;
    }

    public static void main(String[] args) {
        LeftRotateString lrs = new LeftRotateString();
        System.out.println(lrs.getLeftRotateString("abcdefg", 2));
    }
}
