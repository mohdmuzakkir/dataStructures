package dataStructures;

import java.util.EmptyStackException;

// this class implements Stack by extending ArrayLinearList and implementing
public class DerivedArrayStack extends ArrayLinearList implements Stack
{
    // constructors

    public DerivedArrayStack(int initialCapacity) // this constructor invokes the constructor of super class ArrayLinearList
    {                                             // which allocates an array of type Object with capacity or length initialCapacity
        super(initialCapacity);
    }

    public DerivedArrayStack() // this contructor invokes the first constructor with an actual parameter value of 10
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
        if(isEmpty()) // throws an exception if the Stack is empty
            throw new EmptyStackException();

        return get(size()-1); // size() method of ArrayLinearList is invoked
    }

    /** inserts an element at the top of the Stack */
    public void push(Object theElement)
    {
        add(size(), theElement); // add() and size() method of ArrayLinearList is invoked
    }

    /** removes and returns the element at the top of the Stack */
    public Object pop()
    {
        if(empty()) // throws an exception if the stack is empty
            throw new EmptyStackException();

        return remove(size()-1); // remove() and size() method of ArrayLinearList is invoked
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