package dataStructures;

public class ArrayQueue implements Queue
{
    // data members
    Object[] queue;
    int front; // to keep track of front element
    int rear; // to keep track of rear element

    //constructors
    public ArrayQueue(int initialCapacity)
    {
        queue = new Object[initialCapacity+1];
    }

    public ArrayQueue()
    {
        this(10);
    }

    // methods
    public boolean isEmpty()
    {
        return front == rear;
    }

    public Object getFrontElement()
    {
        if(isEmpty())
            return null;
        else
            return queue[(front + 1)%queue.length];
    }

    public Object getRearElement()
    {
        if(isEmpty())
            return null;
        else
            return queue[rear];
    }

    public void put(Object theElement)
    {
        // checks if insering an element fills the array if so then doule the length of the array
        if((rear+1)%queue.length == front)
        {
            // allocate an array of double length
            Object[] newQueue = new Object[2*queue.length];

            // copy the elements of from queue to newQueue
            int start = (front + 1)%queue.length;
            // if there is no wrap around
            if(start<2)
                System.arraycopy(queue, start, newQueue, 0, queue.length-1);

            // if there is a wrap around
            else
            {
                System.arraycopy(queue, start, newQueue, 0, queue.length-start); // to copy elements of second segment into newQueue start from postion zero
                System.arraycopy(queue, 0, newQueue, queue.length-start, rear+1); // to copy elements of first segment into newQueue after first elements are copied
            }

            // now switch to newQueue and set front and rear
            front = newQueue.length-1;
            rear = queue.length-1;
            queue = newQueue;
        }

        rear = (rear+1)%queue.length;
        queue[rear] = theElement;
    }

    public Object remove()
    {
        if(isEmpty())
            return null;

        front = (front + 1)%queue.length;
        Object frontElement = queue[front];
        queue[front] = null;

        return frontElement;
    }

    public static void main(String[] args)
    {
        ArrayQueue q = new ArrayQueue(3);
      // add a few elements
      q.put(Integer.valueOf(1));
      q.put(Integer.valueOf(2));
      q.put(Integer.valueOf(3));
      q.put(Integer.valueOf(4));

      // remove and add to test wraparound array doubling
      q.remove();
      q.remove();
      q.put(Integer.valueOf(5));
      q.put(Integer.valueOf(6));
      q.put(Integer.valueOf(7));
      q.put(Integer.valueOf(8));
      q.put(Integer.valueOf(9));
      q.put(Integer.valueOf(10));
      q.put(Integer.valueOf(11));
      q.put(Integer.valueOf(12));

      // delete all elements
      while (!q.isEmpty())
      {
         System.out.println("Rear element is " + q.getRearElement());
         System.out.println("Front element is " + q.getFrontElement());
         System.out.println("Removed the element " + q.remove());
      }
    }
}