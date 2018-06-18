import java.util.*;
import java.io.*;

/**
 *  Implementation of lists, using singly linked elements.
 *
 * @author     G. Peck
 * @created    April 27, 2002
 *
 * Modified by Jason Quesenberry and Nancy Quesenberry
 * February 9,2006
 */
public class DoublyLinkedList{
    private DListNode first;  // first element  
    private int numberNodes;
    private DListNode last;
    /**
     *  Constructor for the DoublyLinkedList object
     *  Generates an empty list.
     */
    public DoublyLinkedList(){
        first = null;   
        numberNodes = 0;
        last = null;
    }

    /**
     *  Returns the first element in this list.
     *
     * @return  the first element in the linked list.
     */
    public Object getFirst(){
        if (first == null){
            throw new NoSuchElementException();
        }
        else
            return first.getValue();
    }  

    public Object getLast()
    {
        if(last == null)
        {
            throw new NoSuchElementException();
        }
        else
        {
            return last.getValue();
        }
    }

    /**
     *  Inserts the given element at the beginning of this list.
     *
     * @param  value  the element to be inserted at the beginning of this list.
     */
    public void addFirst(Object value){
        // note the order that things happen:
        // head is parameter, then assigned
        first = new DListNode(value, first,null);
        if (last == null){
            last = first;
        }
    }

    public void addLast(Object value)
    // Takes in value, creates a new node, adds the new node
    // at the end of the list.
    {
        //if an empty list then
        //set both first and last to reference the newly constructed node
        // else
        //construct a new node at the end of the list
        if (first ==  null)
        {
            last = new DListNode(value,null,last);
            first = last;

        }
        else
        {
            //             DListNode matt = new DListNode(
            DListNode matt = new DListNode(value,null,last.getPrevious());
            last.setNext(matt);
            last = matt;

        }
    }

    public int size()
    {
        DListNode temp = first;
        while (temp!= null)
        {
            numberNodes++;
            temp = temp.getNext();
        }
        return numberNodes;
    }

    /**
     *  Print the contents of the entire linked list
     */
    public void printList(){
        DListNode temp = first;// start from the first node
        while (temp != null)
        {
            System.out.println(temp.getValue() + " ");
            temp = temp.getNext();// go to next node
        }
    }

    /**
     *  Returns a string representation of this list. The string
     *  representation consists of the list's elements in order,
     *  enclosed in square brackets ("[]"). Adjacent elements are
     *  separated by the characters ", " (comma and space).
     *
     * @return    string representation of this list
     */
    public String toString(){
        String s = "[";

        DListNode temp = first;  // start from the first node
        while (temp != null){
            s += temp.getValue(); // append the data
            temp = temp.getNext();      // go to next node
            if (temp != null)
                s += ", ";
        }
        s += "]";
        return s;
    }  

    public void insert(Item value)
    {
        if(value != null)
        {
            if(first==null || value.compareTo((Item)first.getValue()) <= 0)
            {
                addFirst(value);
            }
            else if(value.compareTo((Item)last.getValue()) >= 0)
            {
                addLast(value);
            }            
            else
            {
                DListNode temp = first;
                DListNode temp2 = first;
                temp = temp.getNext();

                while(temp != null)
                {                
                    if(((Item)temp.getValue()).compareTo(value) >= 0 )
                    {
                        DListNode newNode = new DListNode(value,temp2.getNext(),temp.getPrevious());
                        temp.setPrevious(newNode);
                        temp2.setNext(newNode);
                        return;
                    }    
                    else
                    {
                        temp = temp.getNext();
                        temp2 = temp2.getNext();
                    }
                }
            }
        }    
        else
        {
            throw new NoSuchElementException();
        }
    }

    public DListNode find(Item value)
    {
        if(value == null)
        {
            throw new NoSuchElementException();
        }
        DListNode temp = first;
        Item next = (Item)temp.getValue();
        while(temp != null)
        {
            if(next.equals(value))
            {
                return temp;
            }
            else
            {
                temp = temp.getNext();

                if(temp == null)
                {
                    return null;
                }
                else
                {
                    next = (Item)temp.getValue();
                }
            }
        }
        return null;

    }

    public void printBackwards()
    {
        DListNode temp = last;
        while(temp!= null)
        {
            System.out.print(temp);
            temp = last.getPrevious();
        }

    }

    public boolean remove(Item value)
    {
        if(value!=null)
        {            
            DListNode temp = find(value);
            DListNode temp2 = temp.getNext();
            DListNode temp3 = temp.getPrevious();
            if(temp2 != null && temp3 != null )
            {
                temp = null;
                temp2.setPrevious(temp3);
                temp3.setNext(temp2);
                //                 else if()
                //                 {
                //                     
            }
            else if(temp == first)
            {
                temp =null;
                first = temp2;
            }
            else if(temp == last)
            {
                temp = null;
                last = temp3;
            }
        }
        else 
        {
            return false;
        }
        return false;
    }

    public void clear()
    {
        while(first!= null )
        {
            DListNode temp = first;
            remove((Item)temp.getValue());
        }
    }

}
