
import java.util.Random;
import java.util.Scanner;

public class UC10 {

    static char[][] board = new char[3][3];
    static boolean isHumanTurn = true;
    static boolean gameOver = false;

    static char humanSymbol = 'X';
    static char computerSymbol = 'O';

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {

        initializeBoard();
        printBoard();

        while (!gameOver) {

            if (isHumanTurn) {
                System.out.println("Your Turn (Enter 1-9): ");
                humanMove();
            } else {
                System.out.println("Computer's Turn:");
                computerMove();
            }

            printBoard();

            if (checkWin(humanSymbol)) {
                System.out.println("You Win!");
                gameOver = true;
            } else if (checkWin(computerSymbol)) {
                System.out.println("Computer Wins!");
                gameOver = true;
            } else if (checkDraw()) {
                System.out.println("It's a Draw!");
                gameOver = true;
            } else {
                isHumanTurn = !isHumanTurn; // switch turn
            }
        }
    }

    // UC1: Initialize board
    static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    // Print board
    static void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    // Human move
    static void humanMove() {
        int slot = scanner.nextInt();

        int row = (slot - 1) / 3;
        int col = (slot - 1) % 3;

        if (slot < 1 || slot > 9 || board[row][col] != '-') {
            System.out.println("Invalid move! Try again.");
            humanMove();
        } else {
            board[row][col] = humanSymbol;
        }
    }

    // UC7: Computer move
    static void computerMove() {
        int row, col;

        while (true) {
            int slot = random.nextInt(9) + 1;

            row = (slot - 1) / 3;
            col = (slot - 1) % 3;

            if (board[row][col] == '-') {
                board[row][col] = computerSymbol;
                break;
            }
        }
    }

    // Check win
    static boolean checkWin(char symbol) {

        // Rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == symbol
                    && board[i][1] == symbol
                    && board[i][2] == symbol) {
                return true;
            }
        }

        // Columns
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == symbol
                    && board[1][i] == symbol
                    && board[2][i] == symbol) {
                return true;
            }
        }

        // Diagonals
        if (board[0][0] == symbol
                && board[1][1] == symbol
                && board[2][2] == symbol) {
            return true;
        }

        if (board[0][2] == symbol
                && board[1][1] == symbol
                && board[2][0] == symbol) {
            return true;
        }

        return false;
    }

    // Check draw
    static boolean checkDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean hasWon(char symbol) {

        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == symbol
                    && board[i][1] == symbol
                    && board[i][2] == symbol) {
                return true;
            }
        }

        // Check columns
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == symbol
                    && board[1][i] == symbol
                    && board[2][i] == symbol) {
                return true;
            }
        }

        // Check main diagonal
        if (board[0][0] == symbol
                && board[1][1] == symbol
                && board[2][2] == symbol) {
            return true;
        }

        // Check anti-diagonal
        if (board[0][2] == symbol
                && board[1][1] == symbol
                && board[2][0] == symbol) {
            return true;
        }

        return false;
    }

    static boolean isDraw() {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (board[r][c] == '-') {
                    return false; // still empty cell → not a draw
                }
            }
        }
        return true; // no empty cells → draw
    }
}
