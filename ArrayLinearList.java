package dataStructures;

// Array implementation of LinearList

public class ArrayLinearList implements LinearList
{
    protected Object[] element; /** Object class is a super class and can represent any user defined data type*/
    protected int size;

    /** constructor to declare a list of array of initial capacity given by user and throws exception is initial capacity < 1*/
    ArrayLinearList(int initialcapacity)
    {
        if(initialcapacity < 1)
            throw new IllegalArgumentException
                ("Initial capacity must by >= 1");
        //size of array is zero by default zero
        element = new Object[initialcapacity];
    }
    
    /**constructor to declare a list of array of default capacity 10 */
    ArrayLinearList()
    {
        this(10);
    }

    /** returns true if list is empty othrewise false */
    public boolean isEmpty() 
    {
        return size==0;
    }

    /**returns the current size of the list */
    public int size()
    {
        return size;
    }

    /**checks the index and the throws exception if the index is not between 0 and size-1 */
    public void checkIndex(int index)
    {
        if(index<0 || index>=size)
            throw new IndexOutOfBoundsException
                ("index= "+index+" size= "+size);
    }

    /**returns the element at the spicified index otherwise throws exception if index is not valid*/
    public Object get(int index)
    {
        //checks the validity of the index
        checkIndex(index);

        return element[index];
    }

    /** Search for specified Element in the list and returns the index otherwise returns -1*/
    public int indexOf(Object theElement)
    {
        // search for theElement in the list
        for(int i=0;i<size;i++)
            if(element[i].equals(theElement))
                return i;

        // returns -1 if element is not found
        return -1;
    }

    /**removes and return the element at the specified index and reduces the size of the list by 1*/
    public Object remove(int index)
    {
        //checks the validity of the index
        checkIndex(index);

        Object removedElement= element[index];

        // moves the list by one place to the left from  index+1 to size
        for(int i=index+1;i<size;i++) // loop started from the index-1 position
            element[i-1]=element[i];

        size--; // reduces the size of the list by 1 because one element is removed
        element[size]=null;  //enables garbage collection

        return removedElement;
    }

    /**inserts the specified element at the specifies index and increases the size of the list by 1 */
    public void add(int index, Object theElement)
    {
        // checkIndex not used because element can also be inserted at the index:size
        if(index<0 || index>size)
            throw new IndexOutOfBoundsException
            ("index= "+index+" size= "+size);

        //size of array is doubled if array has no more space
        if(size==element.length)
            element = ChangeArrayLength.changeLength1D(element, size, 2*size);

            // moves the list by one position to the right from index to the size of the list
        for(int i=size-1;i>=index;i--) // loop started from the end(analogy to the remove method) and not from the index so that same element is not copied to the whole list
            element[i+1]=element[i];
            
            element[index]=theElement; // inserts the element
            size++; // increases the size by 1

    }

    /**returns a string of list elements seperated by comma*/
    public String toString()
    {
        StringBuffer s = new StringBuffer("[");

        for(int i=0;i<size;i++)
            if(element[i]==null)
                s.append("null, ");
            else
                s.append(element[i].toString()+", ");

        //to remove last ", "(comma and space)
        if(size>0)
            s.delete(s.length()-2,s.length());

        s.append("]");

        // to return a string with s as initialization
        return new String(s);
    }

    /**main method */
    public static void main(String [] args)
    {
        // creates a list [1,2,3,4,5]

        //default constructor invoked
        LinearList x = new ArrayLinearList();

        // to check add method
        x.add(0, new Integer(5));
        x.add(0, new Integer(4));
        x.add(0, new Integer(3));
        x.add(0, new Integer(2));
        x.add(0, new Integer(1));

        //to print the list of elements
        System.out.println("Elements in the list are: "+x);

        // to check size method
        System.out.println("Size of list is: "+x.size());

        // to check is empty
        if(x.isEmpty())
            System.out.println("List is empty");
        else
            System.out.println("List is not empty");

        // to check get method
        System.out.println("Element at the index 3 is: "+x.get(3));

        // to check indexOf method
        if(x.indexOf(10)>0)
            System.out.println("Index of the Element is: "+x.indexOf(10));
        else
            System.out.println("Element not found.");

        // to check remove method
        System.out.println("Element removed is: "+x.remove(2));

        System.out.println("Elements in the list are: "+x);

    }



}
