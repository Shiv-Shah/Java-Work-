
import java.util.*;
import java.io.*;
public class KnightsTour2
{
    private ArrayList<Integer> horizontal;
    private ArrayList<Integer> vertical;
    private int[][] chessBoard;
    private int moveCounter;
    private int myRow;
    private int myCol;
    private int[][] fileBoard;
 
    public KnightsTour2()
    {
        myRow = 3;
        myCol = 3;
        horizontal = new ArrayList<Integer>(Arrays.asList(new Integer[] {1,1,-1,-1,2,2,-2,-2}));
        vertical = new ArrayList<Integer>(Arrays.asList(new Integer[] {2,-2,-2,2,1,-1,-1,1}));
        chessBoard = new int[14][14];
        fileBoard = new int [14][14];
        makeBoard();          
        chessBoard[3][3] = 1;
        moveCounter = 2;            
        loadFile("access.txt");
    }  

    public void move()
    {
        int x2 = myRow;
        int y2 = myCol;
        int forNum = 0;
        int forNumY = 0;
        int least = 8;
        while(canMove())
        {
            for( int r = 0; r < horizontal.size(); r++)
            {                      
                if(fileBoard[myRow+horizontal.get(r)][myCol+vertical.get(r)] < least)
                {
                    forNum = myRow+horizontal.get(r);
                    forNumY = myCol+vertical.get(r);      

                } 
                least = fileBoard[forNum][forNumY];
            }            
            for(int i = 0; i< horizontal.size(); i++)
            {
                fileBoard[myRow+horizontal.get(i)][myCol+vertical.get(i)]--;                
            }            
            if(chessBoard[forNum][forNumY] == 0 )
            {
                myRow = forNum;
                myCol = forNumY;  
                chessBoard[myRow][myCol] = moveCounter;

            }                        
            if(x2!=myRow &&y2!=myCol)
            {                
                fileBoard[x2][y2] = 9;
                x2 = myRow;
                y2 = myCol;
                least = 8;
                moveCounter++;
                forNum = 0;
                forNumY = 0;
            }
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
                    chessBoard[r][c] = 9;
                    fileBoard[r][c] = 9;
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
        printMoveCount();
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

    private void loadFile(String fileName)
    {
        Scanner file;
        try
        {
            file = new Scanner(new File(fileName));
            for (int r = 3; r < 11; r++)
            {
                for(int c = 3; c< 11; c++)
                {
                    fileBoard[r][c] = file.nextInt();
                }
            }
        }
        catch (IOException error)
        {
            System.out.println (error.getMessage());            
        }
    }

}
