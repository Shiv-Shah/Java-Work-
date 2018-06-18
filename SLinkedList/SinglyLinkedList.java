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
public class SinglyLinkedList{
    private ListNode first;  // first element  
    private int numberNodes;
    private ListNode last;
    /**
     *  Constructor for the SinglyLinkedList object
     *  Generates an empty list.
     */
    public SinglyLinkedList(){
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
        first = new ListNode(value, first);
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
            last = new ListNode(value,last);
            first = last;

        }
        else
        {
            //             ListNode matt = new ListNode(
            ListNode matt = new ListNode(value,null);
            last.setNext(matt);
            last = matt;

        }
    }

    public int size()
    {
        ListNode temp = first;
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
        ListNode temp = first;// start from the first node
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

        ListNode temp = first;  // start from the first node
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
                ListNode temp = first;
                ListNode temp2 = temp;            
                temp = temp.getNext();
                while(temp != null)
                {                
                    if(((Item)temp.getValue()).compareTo(value) >= 0 )
                    {
                        ListNode newNode = new ListNode(value,temp);
                        temp2.setNext(newNode);   
                        return;
                    }    
                    else
                    {
                        temp2=temp;
                        temp = temp.getNext();

                    }
                }
            }

        }    
        else
        {
            throw new NoSuchElementException();
        }
    }

    public ListNode find(Item value)
    {
        if(value == null)
        {
            throw new NoSuchElementException();
        }
        ListNode temp = first;
        while(temp != null)
        {
            if(((Item)temp.getValue()).equals(value))
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
            }
        }
        return null;

    }

    public void printBackwards()
    {
        printBackward(first);

    }

    public void printBackward(ListNode node)
    {
        if(node == null)
        {
            return;
        }
        printBackward(node.getNext());
        System.out.println((Item)node.getValue() + " ");
    }

    public boolean remove(Item value)
    {
        if(value != null)
        {
            ListNode temp = first;
            ListNode temp2 = temp;
            Item next;
            Item next2;   
            Item next3; 
            if(temp == null)
            {
                return false;
            }
            else
            {
                next = (Item)temp.getValue();
                temp.getNext();                
                next2 = (Item)temp2.getValue();
            }
            while(temp != null)
            {                
                if(next.equals(value))
                {    

                    if(next.equals((Item)first.getValue()))
                    {
                        first = first.getNext();
                    }           
                    else if(next.equals((Item)last.getValue()))
                    { 
                        last = temp2;
                        temp2.setNext(null);
                    }

                    else
                    {
                        temp2.setNext(temp.getNext());
                        temp = null;
                    }
                    return true;                        
                }    
                else
                {
                    temp = temp.getNext();
                    temp2 = temp2.getNext();
                    if(temp == null)
                    {
                        return false;
                    }
                    else
                    {
                        next = (Item)temp.getValue();
                        next2 = (Item)temp2.getValue();
                    }
                }
            }
            if(size() == 1 && next.equals(value))
            {
                clear();
            }
        }    
        return false;
    }

    public void clear()
    {
        //         ListNode temp = first;
        //         while(temp!= null )
        //         {
        //             remove((Item)temp.getValue());
        //             temp = temp.getNext();
        // 
        //         }
        //         remove((Item)last.getValue());
        first = null;
        last = null;
    }
}
