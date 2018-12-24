package com.allenanker.chapter5;

public class DigitsInSequecne {
    /**
     * A sequence goes as 012345678910111213..., given an index, return the number in sequence[index]
     * @param index the given index
     * @return the number on that index
     */
    public static int digitInSequence(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("index must not be smaller than 0");
        }
        if (index <= 9) {
            return index;
        }

        int currMagnitude = 2;
        int currSum = 10;
        int currStart = 10;
        int count = 90;
        while (currSum + currMagnitude * count < index) {
            currSum += currMagnitude * count;
            count *= 10;
            currMagnitude += 1;
            currStart *= 10;
        }

        int quotient = (index - currSum) / currMagnitude;
        int remainder = (index - currSum) % currMagnitude;
        return Integer.parseInt(Integer.toString(currStart + quotient).substring(remainder, remainder + 1));
    }

    public static void main(String[] args) {
        int index = 1001;
        System.out.println(digitInSequence(index));
    }
}
