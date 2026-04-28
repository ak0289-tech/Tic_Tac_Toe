import java.util.Random;

public class UC7 {

    static char[][] board = {
        {'-', '-', '-'},
        {'-', '-', '-'},
        {'-', '-', '-'}
    };

    static char computerSymbol = 'O';

    public static void main(String[] args) {
        computerMove();
        printBoard();
    }

    static void computerMove() {
        Random random = new Random();
        int row, col;

        while (true) {
            int slot = random.nextInt(9) + 1; // 1 to 9

            // Convert slot to row & col
            row = (slot - 1) / 3;
            col = (slot - 1) % 3;

            // Check if the position is empty
            if (board[row][col] == '-') {
                board[row][col] = computerSymbol;
                break; // valid move found
            }
        }
    }

    static void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}