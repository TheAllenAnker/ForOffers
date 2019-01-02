package com.allenanker.chapter6;

public class ContinuousSequenceWithSum {
    /**
     * Return the sequences that sum to the specified sum.
     * Return value 3-4 means 3 sum to 4, the sum is 7.
     * Each sequence must have at least 2 numbers.
     *
     * @param sum
     * @return
     */
    public void getContinuousSequencesWithSum(int sum) {
        if (sum < 3) {
            throw new IllegalArgumentException("Invalid parameter");
        }

        int frontNum = 1;
        int backNum = 2;
        int currSum = 3;
        while (frontNum < backNum) {
            if (currSum == sum) {
                System.out.println(frontNum + "-" + backNum);
                backNum++;
                currSum += backNum;
            } else if (currSum < sum) {
                backNum++;
                currSum += backNum;
            } else {
                currSum -= frontNum;
                frontNum++;
            }
        }
    }

    public static void main(String[] args) {
        new ContinuousSequenceWithSum().getContinuousSequencesWithSum(9);
        new ContinuousSequenceWithSum().getContinuousSequencesWithSum(15);
    }
}
