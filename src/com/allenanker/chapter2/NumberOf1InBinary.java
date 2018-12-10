package com.allenanker.chapter2;

public class NumberOf1InBinary {
    public static int numberOf1_solution2(int num) {
        int count = 0;
        while (num != 0) {
            num = num & (num - 1);
            count++;
        }
        return count;
    }
    /**
     * This is the normal way.
     *
     * @param num
     * @return
     */
    public static int numberOf1(int num) {
        int count = 0;
        int flag = 1;
        for (int i = 0; i < 32; i++) {
            if ((flag & num) != 0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }

    public static void main(String[] args) {
        int num = 15;
        System.out.println(numberOf1(num));
        System.out.println(numberOf1_solution2(num));
    }
}
