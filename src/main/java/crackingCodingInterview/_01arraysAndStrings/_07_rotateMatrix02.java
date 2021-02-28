package crackingCodingInterview._01arraysAndStrings;

import static crackingCodingInterview._01arraysAndStrings._07_rotateMatrix.printMatrix;

/**
 * in anti-clockwise direction
 */
public class _07_rotateMatrix02 {
    public static void main(String[] args) {
        int arr[][] = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
        System.out.println("=========BEFORE=======");
        printMatrix(arr);
        rotateMatrixAnti(arr);
        System.out.println("=========AFTER=======");
        printMatrix(arr);
    }

    static void rotateMatrixAnti(int[][] matrix) {
        int n = matrix.length;

        for (int x = 0; x < n / 2; x++) {
            for (int y = x; y < n - x - 1; y++) {
                // Store current cell in
                // temp variable
                int temp = matrix[x][y];
                // Move values from right to top
                matrix[x][y] = matrix[y][n - 1 - x];

                // Move values from bottom to right
                matrix[y][n - 1 - x] = matrix[n - 1 - x][n - 1 - y];

                // Move values from left to bottom
                matrix[n - 1 - x][n - 1 - y] = matrix[n - 1 - y][x];

                // Assign temp to left
                matrix[n - 1 - y][x] = temp;
            }
        }
    }
}
