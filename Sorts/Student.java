//Create a program that prompts for a student's name and student ID#.
// Program will 
//   - add name and id to a file  
//   - continually prompt and add until user chooses to end program
// Create a class, Student, which has-A String for the name (Last, First)
//  and a String for the id
// 
// Create a class called IdCompleter, 
//  which has-A (HLY2)List/(SL)Array of Students
// 
//  load the file into a (HLY2) List or (SL) Array
//  create a completeID method, which adds zeroes to the front 
//        of the ID IF there are less than 6 digits in the ID
//  
//  modify the file to include the updated IDs.
// 
// ******************************************************************** 
// Use BufferedReader(FileReader) class to read from a file
//  and PrintWriter(FileWriter) class to write to a file
// (LOOK THEM UP)
public class Student
{
    private String myFirstName;
    private String myLastName;
    private String myId;
    public Student(String first, String last, String id)
    {
        myFirstName = first;
        myLastName = last;
        myId=id;
    }

    public String getFirstName()
    {
        return myFirstName;
    }

    public String getLastName()
    {
        return myLastName;
    }

    public String getId()
    {
        return myId;
    }

    public String setId(String id)
    {
        myId = id;
        return myId;
    }
    
    public String toString()
    {
        return myFirstName + " " + myLastName +  " " + myId;
    }
}