import java.util.Random;
public class UC2 
{
    static boolean isHumanTurn;
    static char humanSymbol;
    static char computerSymbol;

    public static void main(String[] args) 
    {
        tossAndAssignSymbols();
        displayTossResult();
    }
    static void tossAndAssignSymbols()
    {
        Random random = new Random();
        isHumanTurn = random.nextBoolean();
        if (isHumanTurn) 
        {
            humanSymbol = 'X';
            computerSymbol = 'O';
        }
        else 
        {
            humanSymbol = 'O';
            computerSymbol = 'X';
        }
    }
    static void displayTossResult() 
    {
        System.out.println("Toss result: " + (isHumanTurn ? "Human" : "Computer") + " goes first.");
        System.out.println("Human: " + humanSymbol + ", Computer: " + computerSymbol);
    }
}