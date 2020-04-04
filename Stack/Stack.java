package dataStructures;

// interface to implement Stack data structure
public interface Stack
{
    public boolean empty();
    public Object peek();
    public void push(Object theElement);
    public Object pop();
}