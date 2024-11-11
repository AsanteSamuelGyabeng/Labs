import java.util.Scanner;

public class MatrixMultiplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the number of rows and columns for the first matrix:");
        int rows1 = getIntInput(scanner);
        int cols1 = getIntInput(scanner);
        int[][] matrix1 = new int[rows1][cols1];
        
        System.out.println("Enter the elements of the first matrix:");
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols1; j++) {
                matrix1[i][j] = getIntInput(scanner);
            }
        }

        System.out.println("Enter the number of rows and columns for the second matrix:");
        int rows2 = getIntInput(scanner);
        int cols2 = getIntInput(scanner);
        int[][] matrix2 = new int[rows2][cols2];
        
        System.out.println("Enter the elements of the second matrix:");
        for (int i = 0; i < rows2; i++) {
            for (int j = 0; j < cols2; j++) {
                matrix2[i][j] = getIntInput(scanner);
            }
        }
        scanner.close();

        /**
         * Check if the number of columns in the first matrix is equal to the number of rows in the second matrix.
         */
        if (cols1 != rows2) {
            System.out.println("Matrix multiplication is not possible. The number of columns in the first matrix must be equal to the number of rows in the second matrix.");
            return;
        }

        
        int[][] result = multiplyMatrices(matrix1, matrix2);

        System.out.println("The result of matrix multiplication is:");
        printMatrix(result);
    }


    /**
     * Reads an integer input from the user.
     * @param scanner
     * @return
     */
    private static int getIntInput(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer:");
            scanner.next(); // Discard non-integer input
        }
        return scanner.nextInt();
    }



    /**
     * Multiply matrices int [ ] [ ].
     *
     * @param matrix1 the matrix 1
     * @param matrix2 the matrix 2
     * @return the int [ ] [ ]
     */
    public static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
        int[][] result = new int[matrix1.length][matrix2[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                for (int k = 0; k < matrix2.length; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
    }



    /**
     * Print matrix.
     *
     * @param matrix the matrix
     */
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
