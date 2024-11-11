import java.util.ArrayList;

public class PeakNumber {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 1, 3, 6, 9},
            {6, 7, 2, 7, 10}
        };

        for (int i = 0; i < matrix.length; i++) {
            int maxIndex = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > matrix[i][maxIndex]) {
                    maxIndex = j;
                }
            }

            
            boolean thePeakNumber = true;
            for (int k = 0; k < matrix.length; k++) {
                if (matrix[k][maxIndex] < matrix[i][maxIndex]) {
                    thePeakNumber = false;
                    break;
                }
            }

            if (thePeakNumber) {
                System.out.println("Special element at position (" + (i + 1) + ", " + (maxIndex + 1) + ") = " + matrix[i][maxIndex]);
                return;
            }
        }

        System.out.println("No such element found.");
    }
}

