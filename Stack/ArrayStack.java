package dataStructures;

import java.util.EmptyStackException;

// this class implements the interface Stack without extending class ArrayLinearList and defining each method of interface on their own
class ArrayStack implements Stack
{
    // data members
    Object[] stack; // array of objects
    int top; // top of Stack

    // constructors
    public ArrayStack(int initialCapacity)
    {
        stack = new Object[initialCapacity];
        top = -1;
    }

    public ArrayStack()
    {
        this(10);
    }

    // methods

    public boolean empty()
    {
        return top == -1;
    }
    
    public Object peek()
    {
        if(empty())
            throw new EmptyStackException();

        return stack[top];
    }

    public void push(Object theElement)
    {
        if(top == stack.length-1)
            stack = ChangeArrayLength.changeLength1D(stack, stack.length, 2*stack.length); // increases the size of array if the stack is full

        top++;
        stack[top] = theElement;
    }

    public Object pop()
    {
        if(empty())
            throw new EmptyStackException();

        Object topElement = stack[top];
        stack[top--] = null; // enable garbage collection

        return topElement;
    }

    public static void main(String[] args)
    {
        ArrayStack s = new ArrayStack();

        // push opration
        s.push(new Integer(5));
        s.push(new Integer(4));
        s.push(new Integer(3));
        s.push(new Integer(2));
        s.push(new Integer(1));

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