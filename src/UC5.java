public class UC5 
{
    static char[][] board = {
        {'-', '-', '-'},
        {'-', '-', '-'},
        {'-', '-', '-'}
    };

    public static void main(String[] args) 
    {
        System.out.println(isValidMove(1, 1));
    }

    static boolean isValidMove(int row, int col) 
    {
        if (row >= 0 && row < 3 && col >= 0 && col < 3)
            return board[row][col] == '-';
        
        return false;
    }
}