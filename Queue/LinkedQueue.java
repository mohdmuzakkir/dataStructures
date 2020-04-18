package dataStructures;

public class LinkedQueue implements Queue
{
    // data members
    ChainNode front;
    ChainNode rear;

    // constructors
    public LinkedQueue(int initialCapacity)
    {}

    public LinkedQueue()
    {
        this(0);
    }

    // methods
    public boolean isEmpty()
    {
        return front == null;
    }

    public Object getFrontElement()
    {
        if(isEmpty())
            return null;
        else
            return front.element;
    }

    public Object getRearElement()
    {
        if(isEmpty())
            return null;
        else
            return rear.element;
    }

    public void put(Object theElement)
    {
        ChainNode p = new ChainNode(theElement, null);

        if(front == null) // if queue is Empty
            front = p;
        else
            rear.next = p;

        rear = p;
    }

    public Object remove()
    {
        if(isEmpty())
            return null;

        Object frontElement = front.element;
        front = front.next;

        if(isEmpty()) // enable garbage collection
            rear = null;

        return frontElement;
    }

    public static void main(String[] args)
    {
        LinkedQueue x = new LinkedQueue(5);

        x.put(Integer.valueOf(5));
        x.put(Integer.valueOf(4));
        x.put(Integer.valueOf(10));
        x.put(Integer.valueOf(15));
        x.put(Integer.valueOf(20));

        System.out.println(x.getFrontElement());
        System.out.println(x.getRearElement());

        while(!x.isEmpty())
        {
            System.out.println(x.remove());
        }
    }
}