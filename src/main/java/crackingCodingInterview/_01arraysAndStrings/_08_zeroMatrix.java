package crackingCodingInterview._01arraysAndStrings;

import static crackingCodingInterview._01arraysAndStrings._07_rotateMatrix.printMatrix;

/**
 * Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
 * column are set to 0.
 * O(N) space.
 */
public class _08_zeroMatrix {
    public static void main(String[] args) {
        int arr[][] = {{1, 2, 3},
                {5, 6, 0},
                {9, 0, 11},
                {13, 14, 10}};
        System.out.println("=========BEFORE=======");
        printMatrix(arr);
        setZeroes(arr);
        System.out.println("=========AFTER=======");
        printMatrix(arr);
    }


    static void setZeroes(int[][] matrix) {
        boolean[] rows = new boolean[matrix.length];
        boolean[] columns = new boolean[matrix[0].length];

        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix[0].length; y++) {
                if (matrix[x][y] == 0) {
                    rows[x] = true;
                    columns[y] = true;
                }
            }
        }

        for (int i = 0; i < rows.length; i++) {
            if (rows[i]) nullifyRows(matrix, i);
        }

        for (int i = 0; i < columns.length; i++) {
            if (columns[i]) nullifyColumns(matrix, i);
        }

    }

    private static void nullifyRows(int[][] matrix, int row) {
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[row][i] = 0;
        }
    }

    private static void nullifyColumns(int[][] matrix, int column) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][column] = 0;
        }
    }
}