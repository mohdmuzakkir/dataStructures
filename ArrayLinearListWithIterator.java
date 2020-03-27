package dataStructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayLinearListWithIterator implements LinearList
{
    protected Object [] element;
    protected int size;

    public ArrayLinearListWithIterator(int initialCapacity)
    {
        if(initialCapacity<1)
            throw new IllegalArgumentException
                ("Initail Capacity must be >= 1");
        
                element = new Object[initialCapacity];
    }

    public ArrayLinearListWithIterator()
    {
        this(10);
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public int size()
    {
        return size;
    }

    public void checkIndex(int index)
    {
        if(index<0 || index>=size)
            throw new IndexOutOfBoundsException
                ("Index= "+index+" Size= "+size);
    }

    public Object get(int index)
    {
        checkIndex(index);

        return element[index];
    }

    public int indexOf(Object theElement)
    {
        for(int i=0;i<size;i++)
            if(element[i].equals(theElement))
                return i;

        return -1;
    }

    public Object remove(int index)
    {
        checkIndex(index);

        Object removedElement = element[index];

        for(int i=index+1;i<size;i++)
            element[i-1]=element[i];

        size--;
        element[size]=null;
        
        return removedElement;
    }

    public void add(int index,Object theElement)
    {
        if(index<0 || index>size)
            throw new IndexOutOfBoundsException
                ("Index= "+index+" Size= "+size);

        if(size == element.length)
            element = ChangeArrayLength.changeLength1D(element, size, 2*size);

        for(int i=size-1;i>=index;i--)
            element[i+1]=element[i];

        element[index]= theElement;
        size++;
    }

    public String toString()
    {
        StringBuffer s = new StringBuffer("[");

        for(int i=0;i<size;i++)
            if(element[i] == null)
                s.append("null, ");
            else
                s.append(element[i].toString() + ", ");

        if(size>0)
           s.delete(s.length()-2, s.length());

        s.append("]");

        return new String(s);
    }

    /**creates and return an Iterator */
    public Iterator iterator()
    {
        return new ArrayLinearListIterator();
    }

    /**class that implements Iterator */
    private class ArrayLinearListIterator implements Iterator
    {
        private int nextIndex; //data member to keep track to next element

        public ArrayLinearListIterator() //default constructor
        {
            //nextIndex will be automatically initialzed with zero
        }

        /**boolean method that returns true if there is a next element in the list */
        public boolean hasNext()
        {
            return nextIndex < size;
        }

        /**method that returns an unexamined element in the list and throws an exception if there are no elements left */
        public Object next()
        {
            if(nextIndex < size)
                return element[nextIndex++];
            else
                throw new NoSuchElementException("No next Element");
        }

        /**optional method not implemented */
        public void remove()
        {
            throw new UnsupportedOperationException
                ("remove not supporeted");
        }

    }

    public static void main(String [] args)
        {
            ArrayLinearListWithIterator x =new ArrayLinearListWithIterator();
            x.add(0, new Integer(0));
            x.add(1, new Integer(1));
            x.add(2, new Integer(2));
            x.add(3, new Integer(3));
            x.add(4, new Integer(4));
            
            Iterator y = x.iterator(); //Iterator method in class ArrayLinearListWithIterator returns an Iterator

            //Output using an Iterator
            while(y.hasNext())
            {
                System.out.println(y.next());
            }
            
        }
}