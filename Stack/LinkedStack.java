package dataStructures;

import java.util.EmptyStackException;

// this class implements the interface Stack without extending class Chain and defining each method of interface on their own
public class LinkedStack implements Stack
{
    // data members
    protected ChainNode topNode; // to keep track of top element of Stack

    // constructors
    public LinkedStack(int intialCapacity)
    {
        // default value of topNode will be null
    }

    public LinkedStack()
    {
        this(0);
    }

    // methods
    public boolean empty()
    {
        return topNode == null;
    }

    public Object peek()
    {
        if(empty())
            throw new EmptyStackException();

        return topNode.element;
    }

    public void push(Object theElement)
    {
        topNode = new ChainNode(theElement, topNode);
    }

    public Object pop()
    {
        if(empty())
            throw new EmptyStackException();

        Object topElement = topNode.element;
        topNode = topNode.next;
        
        return topElement;
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