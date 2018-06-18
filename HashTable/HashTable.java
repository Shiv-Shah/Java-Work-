/**
 *  Description of the Class
 *
 * @author     G. Peck
 * @created    July 18, 2002
 *
 * Modified by Jason Quesenberry and Nancy Quesenberry
 * February 9, 2006 
 */
import java.util.*;

public class HashTable
{
    private int size;
    private int capacity;
    private ListNode[] myHashTable;

    public HashTable()
    {
        size = 0;
        capacity = 600;
        myHashTable = new ListNode[capacity];    
    }

    public HashTable(int numSlots)
    {
        size = 0;
        capacity = numSlots;
        myHashTable = new ListNode[capacity];
    }

    public int getSize()
    {
        return size;
    }

    public int getCapacity()
    {
        return capacity;
    }
    
    public void add(Object obj)
    {
        // add to array in location determined by call to hashCode()  
        if (obj!=null)
        {
            int temp = obj.hashCode();
            ListNode temp2 = new ListNode(obj);
            if(myHashTable[temp]!=null)
            {
                ListNode check = myHashTable[temp];
                while(check.getNext() != null)
                {
                    check = check.getNext();
                }
                check.setNext(temp2);
            }

            else
            {
                myHashTable[temp]=temp2;
            }
            size++;
        }
        else
        {
            return;
        }
    }

    public Object find(Comparable target) 
    {

        // will attempt to find idToFind in table, if found return inv amount,
        // else return null  (use hashCode to find location, if it's in there)

        //why does it want me to return an object when it says return the inv which is an int

        int temp = target.hashCode();
        ListNode look = myHashTable[temp];
        Item check;
        if(look == null)
        {
            return null;
        }
        else
        {
            while(look != null)
            {
                check = (Item)look.getValue();
                if(check.getId()== ((Item)target).getId())
                {
                    return check;
                }
                else
                {
                    look=look.getNext();
                }
            }
        }

        return null;
    }

    public int getNumberOfNulls()
    {
        int temp = 0;
        for(int i = 0; i < myHashTable.length;i++)
        {
            if(myHashTable[i] == null)
            {
                temp++;
            }
        }
        return temp;
    }

    public int getLongestList()
    {
        int temp = 0;
        int temp2 = 0;
        ListNode karel;
        for(int i = 0; i < myHashTable.length;i++)
        {
            temp2 = 0;
            karel = myHashTable[i];
            while(karel!=null)
            {
                // increment temp2 until its over
                temp2++;
                karel = karel.getNext();

            }
            if(temp2 > temp)
            {
                temp = temp2;
            }

        }

        return temp;
    }
}