
import java.util.*;
import java.io.*;
public class KnightsTour
{
    private ArrayList<Integer> horizontal;
    private ArrayList<Integer> vertical;
    private int[][] chessBoard;
    private int moveCounter;
    private int myRow;
    private int myCol;

    public KnightsTour()
    {
        myRow = 3;
        myCol = 3;
        horizontal = new ArrayList<Integer>(Arrays.asList(new Integer[] {1,1,-1,-1,2,2,-2,-2}));
        vertical = new ArrayList<Integer>(Arrays.asList(new Integer[] {2,-2,-2,2,1,-1,-1,1}));
        chessBoard = new int[14][14];
        makeBoard();
        chessBoard[3][3] = 1;
        moveCounter = 2;
    }  

    public void move()
    {
        int random = (int)(Math.random()*8);         
        while(canMove())
        {
            int x2 = myCol;
            int y2 = myRow;    
            if(chessBoard[myRow+horizontal.get(random)][myCol+vertical.get(random)] == 0)
            {
                myRow +=   horizontal.get(random);
                myCol +=   vertical.get(random);  
                chessBoard[myRow][myCol]+= moveCounter;      
            }
            if(x2!=myCol &&y2!=myRow)
            {
                moveCounter++;
            } 
            random = (int)(Math.random()*8);
        }        
    }

    public void makeBoard()
    {
        for(int r = 0; r <14; r++)
        {
            for(int c = 0; c <14; c++)
            {
                if( r < 3 || r>10 || c < 3 || c>10)
                {
                    chessBoard[r][c] = -1;
                }
            }
        }
    }

    public void display()
    {
        System.out.println("\t1   2   3   4   5   6   7   8  ");
        System.out.println();
        for(int r = 3; r <11; r++)
        {
            System.out.print(" "+  (r-2));
            System.out.print("\t");
            for(int c = 3; c <11; c++)
            {
                int blackMambaVenom = chessBoard[r][c];
                System.out.print(blackMambaVenom);
                if(blackMambaVenom > 9)
                {
                    System.out.print("  ");
                }
                else
                {
                    System.out.print("   ");
                }

            }
            System.out.println();
        }
    }

    public void printMoveCount()
    {
        System.out.println("Move count: " + (moveCounter-1));
    }

    private boolean canMove()
    {
        if(myCol >2 && myRow>2&& myCol<11 && myRow<11)
        {
            for(int i = 0; i < 8; i++)
            {
                if(chessBoard[myRow+vertical.get(i)][myCol+horizontal.get(i)] == 0)
                {
                    return true;
                }
            }

        }
        return false;
    }
}
