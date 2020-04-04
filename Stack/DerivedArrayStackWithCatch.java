package dataStructures;

import java.util.EmptyStackException;

// This class provides an alternative try catch construct in pop and peek method because without check condition also peek and pop would work just fine
// because when pop and peek method invokes add() and get() method of ArrayLinearList it checks index automatically using its checkIndex() method
// but the user DervivedArrayStack might gets confused with the exception thrown by ArrayLinearList class.
// So, if an exception is thrown by ArrayLinearList catch block cathes it and throw EmptyStackException

public class DerivedArrayStackWithCatch extends ArrayLinearList implements Stack
{
    // constructors

    public DerivedArrayStackWithCatch(int initialCapacity) // this constructor invokes the constructor of super class ArrayLinearList
    {                                             // which allocates an array of type Object with capacity or length initialCapacity
        super(initialCapacity);
    }

    public DerivedArrayStackWithCatch() // this contructor invokes the first constructor with an actual parameter value of 10
    {
        this(10);
    }

    // methods

    /** returns true if the Stack is empty otherwise false */
    public boolean empty()
    {
        return isEmpty(); // isEmpty methof of ArrayLinearList is invoked
    }

    /** retruns the element at the top of the Stack */
    public Object peek()
    {
        try
        {
            return get(size()-1); // size() method of ArrayLinearList is invoked
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            throw new EmptyStackException();
        }
    }

    /** inserts an element at the top of the Stack */
    public void push(Object theElement)
    {
        add(size(), theElement); // add() and size() method of ArrayLinearList is invoked
    }

    /** removes and returns the element at the top of the Stack */
    public Object pop()
    {
        try
        {
            return remove(size()-1); // remove() and size() method of ArrayLinearList is invoked
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            throw new EmptyStackException();
        }
    }

    public static void main(String[] args)
    {
        DerivedArrayStack s = new DerivedArrayStack();

        // push opration
        s.push(new Integer(5));
        s.push(new Integer(4));
        s.push(new Integer(3));
        s.push(new Integer(2));
        s.push(new Integer(1));

        // pop operation
        System.out.println(s.pop());

        // peek opration
        System.out.println(s.peek());

    }

}