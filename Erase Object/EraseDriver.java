
import java.io.*;
import java.util.Scanner;
import java.io.IOException;
public class EraseDriver
{
    public static void main(String[] args) 
    {
        boolean finish = false;
        int[][]kobe=new int[21][21];
        EraseObject better_then_the_king = new EraseObject(); 
        kobe = better_then_the_king.loadMaze("digital.txt");
        better_then_the_king.display(kobe);
        while (finish!= true)
        {
            Scanner the_black_mamba2 = new Scanner(System.in);
            System.out.print("Enter the Row number(X coordinate)");
            int xCoord2 = the_black_mamba2.nextInt();
            System.out.print("Enter the Column number (Y coordinate)");
            int yCoord2 = the_black_mamba2.nextInt();
            finish = better_then_the_king.removeObject(xCoord2, yCoord2);
            kobe=better_then_the_king.getMaze();
            better_then_the_king.display(kobe);

        }        

    }
}
