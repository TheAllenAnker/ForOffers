package com.allenanker.niuke_advanced_lesson;

public class JosephusCircle {
    /**
     * N(N = arr.length) people count number from 1 to k, the one count at k dies.
     * Start counting from the next person after the person who died in the last count.
     * Until there is only one person left.
     *
     * @param people
     * @param k
     * @return the number that live until the end
     */
    public static int getAlive(int[] people, int k) {
        if (people == null || people.length == 0 || k <= 0) {
            throw new IllegalArgumentException();
        }

        if (people.length == 1) {
            return people[0];
        }

        return people[aliveIndex(people.length, k - 1, 2, 0)];
    }

    private static int aliveIndex(int length, int k, int i, int newIndex) {
        newIndex = (newIndex + (k - 1) % i + 1) % i;
        if (i == length) {
             return newIndex;
        }

        return  aliveIndex(length, k, i + 1, newIndex);
    }

    public static void main(String[] args) {
        int[] people = new int[]{1, 3, 5, 7, 1, 21, 98};
        System.out.println(getAlive(people, 3));
    }
}
