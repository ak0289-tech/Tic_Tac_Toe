public class UC6 {

    static char[][] board = new char[3][3];

    public static void main(String[] args) {
        placeMove(0, 0, 'X');
        System.out.println(board[0][0]); // Should print X
    }

    // Place the symbol on the board
    static void placeMove(int row, int col, char symbol) {
        board[row][col] = symbol;
    }
}