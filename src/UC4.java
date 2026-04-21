import java.util.*;
public class UC4 
{
    public static void main(String[] args) 
    {
        try(Scanner sc=new Scanner(System.in))
        {
            System.out.print("Enter the Slot(1-9) : ");
            int slot=sc.nextInt();
            System.out.println("Row: " + getRowFromSlot(slot));
            System.out.println("Column: " + getColFromSlot(slot));
        }
    }
    static int getRowFromSlot(int slot) 
    {
        return (slot - 1) / 3;
    }

    static int getColFromSlot(int slot) 
    {
        return (slot - 1) % 3;
    }
}