package com.allenanker.chapter6;

public class AddTwoNumbers {
    public int addTwoNumbers(int a, int b) {
        int sum, carry;
        do {
            sum = a ^ b;
            carry = (a & b) << 1;
            a = sum;
            b = carry;
        } while (carry != 0);

        return a;
    }

    public static void main(String[] args) {
        System.out.println(new AddTwoNumbers().addTwoNumbers(1, -5));
        System.out.println(new AddTwoNumbers().addTwoNumbers(2, 3));
    }
}
