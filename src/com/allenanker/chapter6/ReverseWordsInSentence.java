package com.allenanker.chapter6;

public class ReverseWordsInSentence {
    /**
     * Reverse the words order in a given English sentence. The sentence is a correct English sentence.
     *
     * @param sentence
     * @return
     */
    public String reverseWordsOrder(String sentence) {
        if (sentence == null) {
            throw new IllegalArgumentException("Invalid parameter null");
        }
        if (sentence.trim().isEmpty()) {
            return sentence;
        }

        return reverseSingleWords(getReversedStr(sentence.trim()));
    }

    private String reverseSingleWords(String reversedSentence) {
        String[] words = reversedSentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            sb.append(getReversedStr(words[i]));
            if (i != words.length - 1) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }

    private String getReversedStr(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String sentence = "I am a student.";
        String sentence1 = "student.";
        ReverseWordsInSentence rwis = new ReverseWordsInSentence();
        System.out.println(rwis.reverseWordsOrder(sentence));
        System.out.println(rwis.reverseWordsOrder(sentence1));
        System.out.println(rwis.reverseWordsOrder("   "));
    }
}
