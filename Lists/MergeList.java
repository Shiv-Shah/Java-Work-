import java.util.*;
import java.io.*;

/**
 *  Implements a recursive mergesort on a LinkedList data type
 *
 * @author     G. Peck
 * @created    July 18, 2002
 *
 * Modified by Jason Quesenberry and Nancy Quesenberry
 * February 9, 2006
 */
public class MergeList{
    private  Scanner inFile;
    private String myFile;

    /**
     *  Open a file containing id/inventory pairs of data
     *
     * @param  fileName  File to be opened
     */
    public MergeList(String fileName)
    {
        myFile = fileName;
    }

    /**
     *  Reads a file containing id/inv data pairs. The first line of the
     *  file contains the number of id/inventory integer pairs listed on
     *  subsequent lines.
     *
     * @param  list  Reference to LinkedList to which data will be added
     */
    public void readData(LinkedList <Item> list)
    {
        try
        {
            inFile = new Scanner(new File(myFile));
            while( inFile.hasNextInt())
            {
                int id = inFile.nextInt();
                int inv = inFile.nextInt();
                list.add(new Item(id,inv) );
            }
        }
        catch(IOException e)
        {
            System.out.println(" erroe: " + e.getMessage());
        }
    }

    /**
     *  Prints contents of list
     *
     * @param  list  linked list to be printed
     */
    public void printList(LinkedList <Item> list)
    {

        ListIterator <Item> itr = list.listIterator();
        System.out.printf("%5s%16s","Id","Inventory\n");
        System.out.println();
        while (itr.hasNext() )
        {
            Item lol = itr.next();
            System.out.println(lol.toString());

        }
    }

    /**
     *  Splits listA into two parts. listA retains the first
     *  half of the list, listB contains the last half of
     *  the original list.
     *
     * @param  listA    Original list. reduced by half after split.
     * @param  listB    Contains last half of the original list
     */
    public void split(LinkedList <Item> listA, LinkedList <Item> listB)
    {
        //             LinkedList<Item> itr = listA.listIterator(listA.size());
        //         int end = listA.size();
        //         int mid = listA.size()/2;//8
        //         LinkedList<Item> newList = new LinkedList<Item>();
        //         for (int i = 0;i<= mid; i++)
        //         {
        //             newList.add(i, listA.get(i));
        //         }        
        //         for(int s = mid+1; s < end; s++)
        //         {
        //             listB.add(s, listA.get(s));
        //         }
        //         listA = newList;
        //         
        ListIterator <Item> iter  = listA.listIterator(listA.size()/2);
        while(iter.hasNext() )
        {
            listB.add(iter.next());
            iter.remove();
        } 
    }

    /**
     *  Two linked lists listA and listB are merged into a single
     *  linked list mergedList. They are placed in mergedList starting
     *  with the smallest item on either list and continue working up to
     *  to largest item.
     *
     * @param  listA   LinkedList in nondecreasing order
     * @param  listB   LinkedList in nondecreasing order
     * @return         List  containing all the values from lists listA
     *                 and listB, in nondecreasing order
     */
    public LinkedList<Item> merge(LinkedList <Item> listA,  LinkedList <Item> listB)
    {
        // make sure the target list is empty
        LinkedList <Item> mergedList = new LinkedList <Item>();
        ListIterator <Item> itr1 = listA.listIterator();
        ListIterator <Item> itr2 = listB.listIterator();

        while(itr1.hasNext() && itr2.hasNext() )
        {
            Item compare = itr1.next();
            Item compare2 = itr2.next();
            if(compare.compareTo(compare2) < 0) 
            {
                mergedList.addLast(compare);               
                itr2.previous();
            }
            else
            {
                mergedList.addLast(compare2);
                itr1.previous();
            }
        }
        while(itr2.hasNext() && !itr1.hasNext())
        {
            Item compare2 = itr2.next();
            mergedList.addLast(compare2);
        }
        while(itr1.hasNext() && !itr2.hasNext())
        {
            Item compare = itr1.next();
            mergedList.addLast(compare);
        }
        return mergedList;

        // start at mergedList left and right item
        // continue until either left or right list has no more value to add
        // use <= instead of < so iiiiiiif duplicate take from left so sort is stable

        // One of the next two while loops will execute.  It will be the one with some values
        // left on the list.

    }

    /**
     *  The linked list is returned in sorted order.
     *  Sorted order has the smallest item first and the largest item
     *  last. The ordering is determined by the order defined in the
     *  Comparable class. The method uses the merge sort technique and
     *  must be recursive.
     *
     * @param  listA  LinkedList to be sorted
     * @return        LinkedList in sorted (nondecreasing) order
     */
    public LinkedList<Item> mergeSort(LinkedList <Item> listA)
    {                                
        // Split the list in half.  If uneven then make left one larger.
        //         LinkedList <Item> listB = new LinkedList<Item>();
        // 
        //        split(listA, listB);
        //         if(listA.size()-listB.size()== 0)
        //         {
        // 
        //         }
        //         else if(listA.size()-listB.size()== 1)
        //         {
        //             if(listA.getFirst().compareTo(listB.getFirst())>0)
        //             {
        //                 //                 ListIterator <Item> change = listA.listIterator(listA.indexOf(listA.getFirst()));
        //                 //                 ListIterator <Item> change2 = listB.listIterator(listB.indexOf(listB.getFirst()));
        //                 ListIterator <Item> change =  listA.listIterator();
        //                 Item temp = listA.getFirst();
        //                 change.set(listB.getFirst());
        //                 change.add(temp);
        //                 ret
        //             }            
        //         }
        //         else
        //         {
        //             split(listA, listB);
        // 
        //         }
        //            
        //         return merge(mergeSort(listA), mergeSort(listB));       
        LinkedList <Item> listB = new LinkedList <Item>();
        if (listA == null){
            return null;
        }
        // Don't sort an empty list or a list with one node
        else if (listA.size() <= 1){
            return listA;
        }
        else
        {// Split the list in half.  If uneven then make left one larger.
            split(listA, listB);
            return merge(mergeSort(listA), mergeSort(listB));
        }
    }

    /**
     *  Reverses the order of a list
     *
     * @param  list  LinkedList to be reversed
     * @return       List in reverse order
     */
    public LinkedList reverseList(LinkedList <Item>list)
    {
        ListIterator <Item> itr1 = list.listIterator(list.size());
        LinkedList <Item> reverse = new LinkedList <Item>();
        while(itr1.hasPrevious())
        {
            reverse.add(itr1.previous());
        }
        return reverse;
    }
}
