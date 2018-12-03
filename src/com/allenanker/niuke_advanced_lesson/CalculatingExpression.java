package com.allenanker.niuke_advanced_lesson;

import java.util.LinkedList;

public class CalculatingExpression {
    public static int calculateExp(String expStr) {
        return value(expStr.toCharArray(), 0)[0];
    }

    private static int[] value(char[] expChars, int i) {
        LinkedList<String> processedExp = new LinkedList<>();
        int pre = 0;
        int[] returnInfo;
        while (i < expChars.length && expChars[i] != ')') {
            if (expChars[i] >= '0' && expChars[i] <= '9') {
                pre = pre * 10 + expChars[i++] - '0';
            } else if (expChars[i] != '(') {
                addNum(processedExp, pre);
                processedExp.addLast(expChars[i++] + "");
                pre = 0;
            } else {
                // get the result of the sub expression
                returnInfo = value(expChars, i + 1);
                pre = returnInfo[0];
                // last subexpression ends at returnInfo[1]
                i = returnInfo[1] + 1;
            }
        }
        addNum(processedExp, pre);

        return new int[]{getResult(processedExp), i};
    }

    // add the num into the linked list, calculate the result if last operator is '/' or '*'
    private static void addNum(LinkedList<String> processedExp, int num) {
        if (!processedExp.isEmpty() && (processedExp.peekLast().equals("/") || processedExp.peekLast().equals("*"))) {
            num = processedExp.pollLast().equals("*") ? num * Integer.parseInt(processedExp.pollLast()) :
                    Integer.parseInt(processedExp.pollLast()) / num;
        }
        processedExp.addLast(String.valueOf(num));
    }

    // the remaining linked list will have only '+' and '-' operators
    private static int getResult(LinkedList<String> processedExp) {
        int res = 0;
        while (!processedExp.isEmpty()) {
            int num1 = Integer.valueOf(processedExp.poll());
            String operator = String.valueOf(processedExp.poll());
            int num2 = Integer.valueOf(processedExp.poll());
            res = operator.equals("+") ? num1 + num2 : num1 - num2;
            if (!processedExp.isEmpty()) {
                processedExp.addFirst(String.valueOf(res));
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String exp = "6+3-((2*3-2)+4/2)";
        System.out.println(calculateExp(exp));
    }
}
