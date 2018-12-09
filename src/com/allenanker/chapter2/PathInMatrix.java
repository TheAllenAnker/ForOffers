package com.allenanker.chapter2;

public class PathInMatrix {
    /**
     * Check whether a given path exists in a matrix, every node in the matrix can be used only once
     *
     * @param matrix
     * @param path
     * @return
     */
    public static boolean pathExistsInMatrix(char[][] matrix, char[] path) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        boolean[] visited = new boolean[matrix.length * matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (pathExistsCore(matrix, i, j, path, 0, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean pathExistsCore(char[][] matrix, int row, int col, char[] path, int pos, boolean[] visited) {
        boolean hasPath = false;
        int rows = matrix.length;
        int cols = matrix[0].length;
        if (row >= 0 && row < rows && col >= 0 && col < cols
                && matrix[row][col] == path[pos] && !visited[row * cols + col]) {
            pos++;
            if (pos < path.length) {
                visited[row * cols + col] = true;
                hasPath = pathExistsCore(matrix, row - 1, col, path, pos, visited) ||
                        pathExistsCore(matrix, row, col + 1, path, pos, visited) ||
                        pathExistsCore(matrix, row + 1, col, path, pos, visited) ||
                        pathExistsCore(matrix, row, col - 1, path, pos, visited);

                if (!hasPath) {
                    visited[row * cols + col] = false;
                }
            } else {
                return true;
            }
        }

        return hasPath;
    }

    public static void main(String[] args) {
        char[][] matrix = new char[][]{
                {'a', 'b', 't', 'g'},
                {'c', 'f', 'c', 's'},
                {'j', 'd', 'e', 'h'}
        };
        System.out.println(pathExistsInMatrix(matrix, new char[]{'b', 'f', 'c', 's'}));
    }
}
