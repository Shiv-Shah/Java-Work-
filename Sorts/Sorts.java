
import java.util.*;

public class Sorts
{
    private long mySteps;   // disregard this for now

    public Sorts()
    {
        mySteps = 0;    // disregard this for now
    }

    public void bubbleSort(ArrayList <Comparable> list)
    {
        for(int h = 0; h < list.size() ;h++){
            for(int i = 0; i < list.size()-h-1; i++){
                if(list.get(i).compareTo(list.get(i+1)) > 0)
                {
                    Comparable temp = list.get(i);
                    list.set(i, i+1);
                    list.set(i+1,temp);
                    mySteps++;
                }
                // do et you fool
            }
        }

    }

    /**
     *  Description of the Method
     *
     * @param  list  reference to an array of integers to be sorted
     */
    public void selectionSort(ArrayList <Comparable> list)
    {
        Comparable temp;
        int min;

        for (int outer = 0; outer < list.size() - 1; outer++)
        {
            min = outer;
            for (int inner = outer + 1; inner < list.size(); inner++)
            {
                if (list.get(inner).compareTo(list.get(min))  <0)
                    min = inner;  // a new smallest item is found

            }
            //swap list[outer] & list[min]
            temp = list.get(outer);
            list.set(outer, list.get(min));
            list.set(min, temp);
        }
    }
    
    public void selectionSort2(ArrayList<Comparable> list, int first,  int last)
    {
        Comparable temp;
        int mid = (first + last)/2;
        int min;

        for (int outer = 0; outer < list.size() - 1; outer++)
        {
            min = outer;
            for (int inner = outer + 1; inner < list.size(); inner++)
            {
                if (list.get(inner).compareTo(list.get(min))  <0)
                    min = inner;  // a new smallest item is found

            }
            //swap list[outer] & list[min]
            temp = list.get(outer);
            list.set(outer, list.get(min));
            list.set(min, temp);
        }
    }

    /**
     *  Description of the Method
     *
     * @param  list  reference to an array of integers to be sorted
     */
    public void insertionSort(ArrayList <Comparable> list)
    {

        Comparable temp;
        for(int h=0;h<list.size();h++){
            int pos = h;
            Comparable key = list.get(pos);
            while (pos > 0 && list.get(pos - 1).compareTo (key)>0)
            {                
                list.set(pos, list.get(pos - 1));
                pos--;
            }
            list.set(pos,  key);
        }
    }

    //  Recursively divides a list in half, over and over. When the
    //  sublist has one or two values, stop subdividing.
    public void mergeSort(ArrayList <Comparable> a, int first, int last)
    {
        // we'll do this next week!

        if (last-first==0)
        {
            //do nothing
        } else if (last-first==1)
        {
            if(a.get(first).compareTo (a.get(last) )> 0)
            {
                Comparable temp = a.get(first);
                a.set(first,a.get(last));
                a.set(last,temp);

            }
        }
        else
        {    // recursion, divide list into two halves
            int mid =(first + last) /2;
            mergeSort(a,first,mid);
            mergeSort(a,mid+1,last);
            merge(a,first,mid,last);
            mySteps++;
        }

    }

    // creates a copy of ArrayList list called temp, and uses temp’s values to properly merge(sort) list
    // from first to last 
    public void merge(ArrayList<Comparable> list, int first, int mid, int last)
    {
        List <Comparable> copy= new ArrayList <Comparable>();
        for(Comparable temp : list)
        {
            copy.add(temp);
        }
        int index = first;
        int index2 = mid+1;

        for(int i = first; i<= last; i++)
        {

            if(index>mid)
            {
                list.set(i,copy.get(index2));
                index2++;
            }
            else if(index2>last)
            {
                list.set(i,copy.get(index));
                index++;
            }
            else if(copy.get(index).compareTo(copy.get(index2))<0)

            {
                list.set(i,copy.get(index));
                index++;;
            }
            else
            {
                list.set(i,copy.get(index2));
                index2++;
            }
        }
    }

    public void quickSort (ArrayList <Comparable> list, int first, int last)
    {
        int g = first, h = last;
        int midIndex = (first + last) / 2;
        Comparable dividingValue = list.get(midIndex);
        do{
            while (list.get(g).compareTo(dividingValue) < 0) g++;
            while (list.get(h).compareTo(dividingValue) > 0) h--;
            if (g <= h){
                Comparable temp = list.get(g);
                list.set(g,list.get(h));
                list.set(h,temp);
                mySteps++;
                g++;
                h--;
            }
        }while (g < h);
        if (h > first) quickSort (list,first,h);
        if (g < last) quickSort (list,g,last);
    }

    public void mergeSort2(ArrayList <Comparable> a, int first, int last)
    {

        int mid = (first + last) / 2;
        selectionSort2 (a, first, mid);
        selectionSort2(a, mid+1, last);
        merge(a, first, mid, last);
    }

    /**
     *  Accessor method to return the current value of steps
     *
     */
    public long getStepCount()
    {
        return mySteps;
    }

    /**
     *  Modifier method to set or reset the step count. Usually called
     *  prior to invocation of a sort method.
     *
     * @param  stepCount   value assigned to steps
     */
    public void setStepCount(long stepCount)
    {
        mySteps = stepCount;
    }   

}
