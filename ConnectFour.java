
import java.util.Scanner;
import java.util.Arrays;

public class ConnectFour {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int Row = 0;
        int Column = 0;
        boolean game;
        int player1Column = 0;
        int player2Column = 0;
        int playerRow1;
        int playerRow2;


        System.out.println("What would you like the height of the board to be? ");
        Row = scan.nextInt();
        System.out.println("What would you like the length of the board to be?");
        Column = scan.nextInt();
        char[][] grid = new char[Row][Column];
        // row is the height and column the length
        initializeBoard(grid);
        printBoard(grid);
        System.out.println();
        System.out.println("Player 1: x");
        System.out.println("Player 2: o");
        System.out.println();

        int count = 0;
        int max = Row * Column;
        while (game = true) {
            System.out.println("Player 1: Which column would you like to choose?");
            player1Column = scan.nextInt();
            playerRow1 = insertChip(grid, player1Column, 'x');
            printBoard(grid);
            count++;
            if (checkIfWinner(grid, player1Column, playerRow1, 'x')) {
                System.out.println("Player 1 won the game!");
                break;
            }
            if (count == max) {
                System.out.println("Draw. Nobody wins. ");
                break;
            }
            //
            // if checkIfWinner method is true then player has won and exit loop
            System.out.println("Player 2: Which column would you like to choose?");
            player2Column = scan.nextInt();
            playerRow2 = insertChip(grid, player2Column, 'o');
            printBoard(grid);
            count++;
            if (checkIfWinner(grid, player2Column, playerRow2, 'o')) {
                System.out.println("Player 2 won the game!");
                break;
            }
            if (count == max) {
                System.out.println("Draw. Nobody wins.");
                break;
            }


        }

    }

    public static void printBoard(char[][] array) {
        for (int rowCount = array.length - 1; rowCount >= 0; rowCount--) {
            System.out.println();
            for (int columnCount = 0; columnCount < array[rowCount].length; columnCount++) {
                System.out.print(array[rowCount][columnCount]);
                System.out.print(" ");

            }

        }
        System.out.println();

    }

    public static void initializeBoard(char[][] array) {
        for (int rowCount = 0; rowCount < array.length; rowCount++) {

            // arrays start at zero so make it stop before reaching the array length

            for (int columnCount = 0; columnCount < array[rowCount].length; columnCount++) {
                array[rowCount][columnCount] = '-';


            }
        }


    }

    public static int insertChip(char[][] array, int col, char chipType) {
        int count = 1;
        int row = 0;
        boolean rowCount = true;


        while (rowCount == true) {

            // need to have row subtract and store each time
            if ((array[row][col] == 'x') || (array[row][col] == 'o')) {
                row++;

                if (array[row][col] == '-') {
                    array[row][col] = chipType;
                    System.out.println();
                    count++;

                    break;
                }

            } else {
                array[row][col] = chipType;
                break;
            }
        }


        return row;

    }

    public static boolean checkIfWinner(char[][] array, int col, int row, char chipType) {

        int count = 0;
        int drawCount = 0;
        int totalTurns = 0;


        //horizontal
        for (int j = 0; j < array[0].length; j++) {
            // the column needs to be in the inner loop because pieces will be through one row and many columns
            if (array[row][j] == chipType) {
                count++;
                // if player has column after column 4 times in the same row they win
            } else if (array[row][j] != chipType) {
                count = 0;
            }
            if (count >= 4) {
                return true;
            }


        }


        //vertical

        count = 0;

        for (int i = 0; i < array.length; i++) {

            if (array[i][col] == chipType) {
                count++;


            } else if (array[i][col] != chipType) {
                count = 0;
            }
            if (count >= 4) {

                return true;
            }
            //count will keep place for the amount of chip type


        }


        return false;
    }
}




