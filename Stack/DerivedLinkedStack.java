package dataStructures;

import java.util.EmptyStackException;

// this class implements Stack by extending Chain class and implementing interface Stack
// left end of the chain is used as top of Stack instead the right end to save time.
public class DerivedLinkedStack extends Chain implements Stack
{
    // constructors
    public DerivedLinkedStack(int initialCapacity)
    {
        super(initialCapacity); // invokes the constructor of super class
    }

    public DerivedLinkedStack()
    {
        this(0);
    }

    // methods
    public boolean empty()
    {
        return isEmpty();
    }

    public Object peek()
    {
        if(empty())
            throw new EmptyStackException();

        return get(0);
    }

    public void push(Object theElement)
    {
        add(0, theElement);
    }

    public Object pop()
    {
        if(empty())
            throw new EmptyStackException();

        return remove(0);
    }

    public static void main(String[] args)
    {
        LinkedStack s = new LinkedStack();

        // push opration
        s.push(new Integer(1));
        s.push(new Integer(2));
        s.push(new Integer(3));
        

        // empty method
        if(s.empty())
            System.out.println("Stack is empty");
        else
        System.out.println("Stack is not empty");

        // pop operation
        System.out.println(s.pop());

        // peek opration
        System.out.println(s.peek());

    }
}