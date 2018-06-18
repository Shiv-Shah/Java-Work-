/**
 *  Binary tree lab
 *
 * @author     G. Peck
 * @created    July 2, 2003
 *
 * Modified by Jason Quesenberry and Nancy Quesenberry
 * February 9, 2006
 */
import java.util.Scanner;
import java.io.*;

public class BSTreeStrings{
    private Scanner console;

    public BSTreeStrings(){
        console = new Scanner(System.in);
    }

    void testFind(BinarySearchTreeStrings temp){
        String  stringToFind;
        String location;

        System.out.println("Testing search algorithm\n");
        System.out.print("Enter Id value to search for (-1 to quit) --> ");
        stringToFind = console.next();

        while (!stringToFind.equals("-1") ){
            location = (String)temp.find(stringToFind);
            if (location == null)
                System.out.println(stringToFind + "  No such part in stock");
            else
                System.out.println("String = " + location + " was found");
            System.out.println();
            System.out.print("Enter Id value to search for (-1 to quit) --> ");
            stringToFind = console.next();
        }
    }

    public void testDelete(BinarySearchTreeStrings temp){
        String stringToDelete;
        boolean success;

        System.out.println("Testing delete algorithm\n");
        System.out.print("Enter Id value to delete (-1 to quit) --> ");
        stringToDelete = console.next();

        while (!stringToDelete.equals("-1")){
            //             String dNode = new String(idToDelete, 0);

            if (temp.find(stringToDelete) == null)
                System.out.println("String " + stringToDelete + "  No such part in stock");
            else{
                temp.delete(stringToDelete);
                System.out.println("     String " + stringToDelete + " was deleted");
            }
            System.out.println();
            System.out.print("Enter Id value to delete (-1 to quit) --> ");

            stringToDelete = console.next();
        }
    }

    public void readData (BinarySearchTreeStrings temp){
        Scanner inFile;

        String fileName = "fileC.txt";
        String id ;
        try{
            inFile = new Scanner(new File(fileName));
            while(inFile.hasNext()){
                id = inFile.nextLine();
                temp.insert(id);
            }
        }catch(IOException i){
            System.out.println("Error: "+ i.getMessage());
        }
    }

//     public void testPrintLevel(BinarySearchTreeStrings root)
//     {
//         int level;
//         do
//         {
//             System.out.println("Print level(press -1 to exit)");
//             level = console.nextInt();
//             System.out.println();
//             root.printLevel(level);
//             System.out.println();
//         }
//         while(level != -1);
//     }

    public void testAncestor(BinarySearchTreeStrings root)
    {
        String ancestor;
        String descendant;
        do
        {
            System.out.print("To Exit write -1 on Ancestor ");
            System.out.println();
            System.out.println("\nAncestor");
            ancestor = console.next();

            if(!ancestor.equals("-1")  )
            {
                System.out.println("\nChild");
                descendant = console.next();
                System.out.println();
                System.out.println("isAncestor() : " + root.isAncestor(ancestor, descendant));  
                System.out.println();
            }

        }
        while(!ancestor.equals("-1"));
    }

    public void mainMenu (BinarySearchTreeStrings root){
        String choice;       
        do{
            System.out.println("Binary tree menu\n");
            System.out.println("(1) Read data from disk");
            System.out.println("(2) Inorder output");
            System.out.println("(3) Preorder output");
            System.out.println("(4) Postorder output");
            System.out.println("(5) Search tree");
            System.out.println("(6) Delete from tree");
            System.out.println("(7) Count the nodes in the tree");
            System.out.println("(8) Count the leaves in the tree");
            System.out.println("(9) Find the height of the tree ");
            System.out.println("(+) Find the width of the tree");
            System.out.println("(-) Clear the tree");
            System.out.println("(,) Interchange the tree(mirror image)");
            System.out.println("(.) Print level");
            System.out.println("(;) isAncestor");
            System.out.println("(Q) Quit\n");
            System.out.print("Choice ---> ");                       
            choice = console.next()+ " ";            
            //             if(choice.equals(""))
            //             {
            //                 
            //             }
            //             else
            //             {
            System.out.println();
            if ('*' <= choice.charAt(0) && choice.charAt(0) <= ';'){
                switch (choice.charAt(0)){
                    case '1' :
                    readData(root);
                    break;
                    case '2' :
                    System.out.println();
                    System.out.println("The tree printed inorder\n");
                    //System.out.printf("%10s%10s","Id","Inv");
                    System.out.println();
                    //root.print();
                    root.printInorder();
                    System.out.println();
                    break;
                    case '3' :
                    System.out.println();
                    System.out.println("The tree printed preorder\n");
                    //System.out.printf("%10s%10s","Id","Inv");
                    System.out.println();
                    root.printPreorder();
                    System.out.println();
                    break;
                    case '4' :
                    System.out.println();
                    System.out.println("The tree printed postorder\n");
                    //System.out.printf("%10s%10s","Id","Inv");
                    System.out.println();
                    root.printPostorder();
                    System.out.println();
                    break;
                    case '5' :
                    testFind(root);
                    break;
                    case '6' :
                    testDelete(root);
                    break;
                    case '7' :
                    System.out.println("Number of nodes = " + root.countNodes ());
                    System.out.println();
                    break;
                    case '8' :
                    System.out.println();
                    System.out.println("Amount of leaves in the tree\n" + root.countLeaves());
                    //System.out.printf("%10s%10s","Id","Inv");
                    System.out.println();

                    System.out.println();
                    break;
                    case '9' :
                    System.out.println();
                    System.out.println("The height of the tree "+ root.height());
                    //System.out.printf("%10s%10s","Id","Inv");
                    System.out.println();

                    System.out.println();
                    break;
                    case '+' :
                    System.out.println();
                    System.out.println("The width of the tree "+root.width());
                    //System.out.printf("%10s%10s","Id","Inv");
                    System.out.println();

                    System.out.println();
                    break;
                    case '-' :
                    System.out.println();
                    System.out.println("Clear the tree");
                    root.clearTree();
                    //System.out.println("%10s%10s","Id","Inv");
                    System.out.println();                    
                    break;
                    case ',' :
                    System.out.println();
                    System.out.println("Interchange the tree(mirror image)");
                    //System.out.printf("%10s%10s","Id","Inv");
                    System.out.println();
                    root.interchange();
                    System.out.println();
                    break;
                    case '.':
                    //testPrintLevel(root);
                    System.out.println();
                    root.printLevel();
                    System.out.println();
                    break;
                    case ';' :
                    testAncestor(root);
                    break;
                }
            }
        }

        while (choice.charAt(0) != 'Q' && choice.charAt(0) != 'q' );
    }
}

