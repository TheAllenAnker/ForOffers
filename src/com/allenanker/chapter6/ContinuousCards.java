package com.allenanker.chapter6;

import java.util.Arrays;
import java.util.HashMap;

public class ContinuousCards {
    private static String[] possibleCars = new String[]{
            "King", "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"
    };

    private HashMap<String, Integer> cardsMap;

    public ContinuousCards() {
        cardsMap = new HashMap<>();
        for (int i = 0; i < possibleCars.length; i++) {
            cardsMap.put(possibleCars[i], i);
        }
    }

    /**
     * Determine the given 5 cards are continuous ones, assuming that the given cards are reasonable.
     *
     * @param cards
     * @return
     */
    public boolean isContinuousCards(String[] cards) {
        if (cards == null || cards.length != 5) {
            throw new IllegalArgumentException("Invalid parameter cards");
        }

        int[] processedCards = new int[5];
        for (int i = 0; i < 5; i++) {
            processedCards[i] = cardsMap.get(cards[i]);
        }
        Arrays.sort(processedCards);

        int zeroCount = 0;
        int gapCount = 0;
        for (int i = 0; i < 5; i++) {
            if (processedCards[i] == 0) {
                zeroCount++;
            } else {
                break;
            }
        }
        if (zeroCount > 2) {
            throw new IllegalArgumentException("Too many kings in given 5 cards");
        }

        for (int i = zeroCount + 1; i < 5; i++) {
            int curr = processedCards[i];
            int prev = processedCards[i - 1];
            if (curr == prev) {
                return false;
            }
            gapCount += curr - prev - 1;
        }

        return zeroCount == gapCount;
    }

    public static void main(String[] args) {
        String[] cards = new String[]{
                "King", "A", "3", "4", "6"
        };
        System.out.println(new ContinuousCards().isContinuousCards(cards));
    }
}
