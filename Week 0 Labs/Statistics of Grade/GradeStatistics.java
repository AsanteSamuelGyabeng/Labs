import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class GradeStatistics {
    public static void main(String[] args) {
        ArrayList<Integer> scores = getStudentScores();
        int totalSum = calculateTotalSum(scores);
        int[] stats = categorizeScores(scores);
        
        printStatistics(scores, totalSum);
        printScoreDistribution(stats);
    }



    /**
     * @return {@link ArrayList<Integer> } of integers
     * */
    private static ArrayList<Integer> getStudentScores() {
        ArrayList<Integer> scores = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        int numOfStudents = 0;
    
       
        while (true) {  // Validate input for the number of students
            System.out.print("Enter the Number of students: ");
            if (input.hasNextInt()) {
                numOfStudents = input.nextInt();
                if (numOfStudents > 0) {
                    break; 
                } else {
                    System.out.println("Please enter a positive integer.");
                }
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                input.next();
            }
        }
    
        System.out.println("Enter the Scores of students:");
    
        // Validate input for each student's score
        for (int i = 0; i < numOfStudents; i++) {
            while (true) {
                System.out.print("Score for student " + (i + 1) + ": ");
                if (input.hasNextInt()) {
                    int score = input.nextInt();
                    scores.add(score);
                    break; 
                } else {
                    System.out.println("Invalid input. Please enter an integer.");
                    input.next(); 
                }
            }
        }
    
        input.close();
        return scores;
    }


    /**
     *
     * @param scores
     * @return {@link int} the totalSum of the scores
     */
    private static int calculateTotalSum(ArrayList<Integer> scores) {
        int totalSum = 0;
        for (int score : scores) {
            totalSum += score;
        }
        return totalSum;
    }

    /**
     *
     * @param scores
     * @return {@link int[]} the stats of the scores
     */
    private static int[] categorizeScores(ArrayList<Integer> scores) {
        int[] stats = new int[5];
        for (int score : scores) {
            int index = Math.min(score / 20, 4); 
            stats[index]++;
        }
        return stats;
    }

    /**
     *          *
     * @param scores
     * @param totalSum
     * printStatistics prints the statistics of the scores
     */
    private static void printStatistics(ArrayList<Integer> scores, int totalSum) {
        int minScore = Collections.min(scores);
        int maxScore = Collections.max(scores);
        double average = (double) totalSum / scores.size();

        System.out.println("\nValues:");
        System.out.println("The minimum score is: " + minScore); 
        System.out.println("The maximum score is: " + maxScore);
        System.out.printf("The average score is: %.2f\n", average);
    }

    /**
     *
     * @param stats
     * prints out the graph of the score distribution
     */
    private static void printScoreDistribution(int[] stats) {
        int maxStat = getMaxStat(stats);

        System.out.println("\nScore Distribution:");
        String bar = "  #####   ";
        String noBar = "        ";

        for (int i = maxStat; i > 0; i--) {
            System.out.printf("%2d > ", i);
            for (int stat : stats) {
                System.out.print(stat >= i ? bar : noBar);
            }
            System.out.println();
        }

        System.out.println("     +-------+-------+-------+-------+--------+");
        System.out.println("     | 0-20  | 21-40 | 41-60 | 61-80 | 81-100 |");
    }

    /**
     *
     * @param stats
     * @return the maximum value in the array
     */
    public static int getMaxStat(int[] stats) {
        int maxStat = 0;
        for (int stat : stats) {
            if (stat > maxStat) {
                maxStat = stat;
            }
        }
        return maxStat;
    }
}
