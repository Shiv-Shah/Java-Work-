import java.io.File;
import java.util.Scanner;
import java.io.IOException;
public class EraseObject
{
    //     private static final char BLANK = ' ';
    //     private static final int MAXROW = 21;
    //     private static final int MAXCOL = 21;
    //     private int myMaxRow;
    //     private int myMaxCol;
    private int [][] copyMaze;
    public EraseObject()
    {
        copyMaze = new int[21][21];
    }

    public boolean removeObject(int xCoord, int yCoord)
    {       
        removeWall(copyMaze,xCoord, yCoord);
        return isDone();
    }

    public int[][] getMaze()
    {
        return copyMaze;
    }

    public int[][] removeWall(int[][]grid, int x,int y)
    {
        int[][]copy=(int[][])copyMaze.clone();
        if(x > 0 && x < 21)
        {           
            if(y > 0 && y < 21)               
            { 
                int check = copy[x][y];
                if(check != 0)
                {
                    copy[x][y]=0;
                    copyMaze[x][y]=0;
                    removeWall(copy,x+1,y);
                    removeWall(copy,x,y+1);
                    removeWall(copy,x-1,y);
                    removeWall(copy,x,y-1);
                }                
            }
        }
        return copyMaze;
    }

    public int[][] loadMaze(String inFileName){
        Scanner inFile;
        try{
            inFile = new Scanner(new File(inFileName));
            inFile.nextInt();
            while(inFile.hasNextInt())
            {
                int row = inFile.nextInt();
                int col = inFile.nextInt();
                if(row > 0 && row < 21)
                {
                    if(col > 0 && col < 21)
                    {
                        copyMaze[row][col]=1;
                    }
                }

            }
        }
        catch(IOException i)
        {
            System.out.println("Error: " + i.getMessage());
        }
        return copyMaze;
    }

    public void display(int[][] maze)
    {
        System.out.println("\t1234567890123456789");
        for(int r =1; r <21; r++)
        {
            System.out.print(r);
            System.out.print("\t");
            for(int c = 1; c <21; c++)
            {
                int work = copyMaze[r][c];
                if(work == 0)
                {                   
                    System.out.print("-");
                }
                else
                {
                    System.out.print("@");
                }
            }
            System.out.println();
        }
    }

    public boolean isDone()
    {       

        for(int r = 0; r <21; r++)
        {         
            for(int c = 0; c <21; c++)
            {
                if(copyMaze[r][c]==1)
                {
                    return false;
                }
            }     

        }
        return true;
    }
}
