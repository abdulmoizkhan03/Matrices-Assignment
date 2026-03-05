import java.util.Scanner;

public class MatricesAssignment {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter total rows: ");
        int totalRows = input.nextInt();
        System.out.print("Enter total columns: ");
        int totalCols = input.nextInt();

        int[][] data = new int[totalRows][totalCols];

        System.out.println("Input matrix elements:");
        for (int r = 0; r < totalRows; r++) {
            for (int c = 0; c < totalCols; c++) {
                data[r][c] = input.nextInt();
            }
        }

        System.out.println("Your matrix:");
        for (int r = 0; r < totalRows; r++) {
            for (int c = 0; c < totalCols; c++) {
                System.out.print(data[r][c] + " ");
            }
            System.out.println();
        }

        System.out.println("Sum of each row:");
        for (int r = 0; r < totalRows; r++) {
            int sumRow = 0;
            for (int c = 0; c < totalCols; c++) {
                sumRow += data[r][c];
            }
            System.out.println("Row " + (r + 1) + ": " + sumRow);
        }

        System.out.println("Sum of each column:");
        for (int c = 0; c < totalCols; c++) {
            int sumCol = 0;
            for (int r = 0; r < totalRows; r++) {
                sumCol += data[r][c];
            }
            System.out.println("Column " + (c + 1) + ": " + sumCol);
        }

        if (totalRows == totalCols) {
            int mainDiag = 0;
            for (int i = 0; i < totalRows; i++) {
                mainDiag += data[i][i];
            }
            System.out.println("\nMain diagonal sum: " + mainDiag);

            int antiDiag = 0;
            for (int i = 0; i < totalRows; i++) {
                antiDiag += data[i][totalCols - 1 - i];
            }
            System.out.println("Anti-diagonal sum: " + antiDiag);
        } else {
            System.out.println("\nDiagonal sums are for square matrices only.");
        }

        input.close();
    }
}