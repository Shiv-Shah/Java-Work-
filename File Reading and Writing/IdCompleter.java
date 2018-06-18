
/**
 * Write a description of class IdCompleter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import java.io.*;
public class IdCompleter
{
    private String id;
    private String myFile;
    private static String end;
    private static boolean end2;
    private static ArrayList<Student> the_black_mamba = new ArrayList<Student>();
    private static BufferedReader read;
    private static ArrayList<Student> myRoster = new ArrayList<Student>();
    private String firstName;
    private String lastName;
    private String idNumber;
    private File newFile = new File("hi.txt");
    public IdCompleter(String file,ArrayList roster) throws IOException 
    {
        myFile = file;
        myRoster = new ArrayList<Student>(); 
        myRoster = roster;

    }
    // 
    //     public void reading() throws IOException
    //     {
    //         read = new BufferedReader( new FileReader(myFile));
    //         String mamba = read.readLine();
    //         String newLegs = read.readLine();
    //         String betterThen23 = read.readLine();
    //         Student kobe = new Student( mamba,newLegs,betterThen23);
    //         myRoster.add(0, kobe);
    //         
    //     }

    public ArrayList<Student> completed (ArrayList<Student> original)
    {
        ArrayList<Student> answer = new ArrayList<Student>();
        int processor = 0;
        while(processor < original.size())
        {
            Student replacement = original.get(processor);
            int num = 6 - replacement.getId().length();
            for(int count = 0; count < num; count++)
            {
                replacement.setId("0" + replacement.getId());
            }
            answer.add(replacement);
            processor++;
        }
        return answer;
    }

    public void part1() throws IOException
    {
        String firstName;
        String lastName;
        String idNumber;
        PrintWriter print = new PrintWriter(newFile);
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter your first name ");
        print.write(System.getProperty("line.separator"));
        firstName = scan.nextLine();
        System.out.print("Enter your last name ");
        print.write(System.getProperty("line.separator"));
        lastName = scan.nextLine();        
        System.out.print("Enter your Id number ");
        print.write(System.getProperty("line.separator"));
        idNumber = scan.nextLine();
        Student kobe = new Student(firstName, lastName, idNumber);
        print.println(kobe.toString());
        System.out.print("To stop printing type enter ");
        print.write(System.getProperty("line.separator"));
        end = scan.nextLine();
        if( end.equals( "enter"))
        {
            end2 = true;
        }
        the_black_mamba.add(0,kobe);

    }

    public void loop() throws IOException 
    {
        PrintWriter print = new PrintWriter(newFile);
        Scanner scan = new Scanner(System.in);
        while(end2 == false)
        {
            System.out.print("Enter your first name ");
            firstName = scan.nextLine();
            print.write(System.getProperty("line.separator"));
            System.out.print("Enter your last name ");
            lastName = scan.nextLine();
            print.write(System.getProperty("line.separator"));
            System.out.print("Enter your Id number ");
            idNumber = scan.nextLine();
            print.write(System.getProperty("line.separator"));
            Student kobe2 = new Student(firstName, lastName, idNumber);
            print.println(kobe2.toString());
            System.out.print("To stop printing type enter ");
            end = scan.nextLine();
            print.write(System.getProperty("line.separator"));
            if( end.equals( "enter"))
            {
                end2 = true;
            }
            the_black_mamba.add(0,kobe2);
        }        
        print.close();
        read = new BufferedReader( new FileReader("hi.txt"));        
        String mamba = read.readLine();
        String newLegs = read.readLine();
        String betterThen23 = read.readLine();
        Student kobe4 = new Student( mamba,newLegs,betterThen23);
        myRoster.add(0, kobe4);        
        for(int i = 0; i < the_black_mamba.size();i++)
        {
            mamba = read.readLine();
            newLegs = read.readLine();
            betterThen23 = read.readLine();
            Student kobe5 = new Student( mamba,newLegs,betterThen23);
            myRoster.add(0, kobe5);  
        }

        the_black_mamba = completed(the_black_mamba);
        print = new PrintWriter(newFile);

        while(the_black_mamba.size()>0)
        {
            Student kobe3 = the_black_mamba.get(0);           
            print.println(kobe3.toString());

            the_black_mamba.remove(0);
        }
        try{
            PrintWriter step2 = new PrintWriter("hi.txt");
            //This is where io changed the number
            for(int i = 1; i < myRoster.size();i++)
            {
                step2.write(myRoster.get(i).toString());
                step2.write(System.getProperty("line.separator"));

            }
            step2.close();
        }
        catch(IOException e)
        {
            System.out.println("Error: " + e.getMessage());
        }
        print.close();

    }
}
// for (int i = processor; i < 