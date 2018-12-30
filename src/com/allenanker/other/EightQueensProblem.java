package com.allenanker.other;

public class EightQueensProblem {
    int[] res = new int[8];

    public void cal8QueensProblem(int row) {
        if (row == 8) {
            return;
        }

        for (int col = 0; col < 8; col++) {
            if (isOK(row, col)) {
                res[row] = col;
                cal8QueensProblem(row + 1);
            }
        }
    }

    private void printMatrix() {
        for (int i = 0; i < 8; i++) {
            int pos = res[i];
            for (int j = 0; j < pos; j++) {
                System.out.print("* ");
            }
            System.out.print("# ");
            for (int j = pos; j < 7; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    private boolean isOK(int row, int col) {
        int leftUp = col - 1;
        int rightUp = col + 1;
        for (int i = row - 1; i >= 0; i--) {
            if (res[i] == col) return false;
            if (leftUp >= 0) {
                if (res[i] == leftUp) return false;
            }
            if (rightUp < 8) {
                if (res[i] == rightUp) return false;
            }
            leftUp--;
            rightUp++;
        }
        
        return true;
    }

    public static void main(String[] args) {
        EightQueensProblem eightQueensProblem = new EightQueensProblem();
        eightQueensProblem.cal8QueensProblem(0);
        eightQueensProblem.printMatrix();
    }
}
