package dataStructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ChainWithIterator implements LinearList
{
    protected ChainNode firstNode;
    protected int size;

    public ChainWithIterator(int initailCapacity)
    {

    }

    public ChainWithIterator()
    {
        this(0);
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
                ("Index= " +index+ " Size= "+size);
    }

    public Object get(int index)
    {
        checkIndex(index);

        ChainNode currentNode = firstNode;
            for(int i=0;i<index;i++)
                currentNode = currentNode.next;

        return currentNode.element;
    }

    public int indexOf(Object theElement)
    {
        ChainNode currentNode = firstNode;
        int index = 0;
        while(currentNode != null && !currentNode.element.equals(theElement))
        {
            currentNode = currentNode.next;
            index++;
        }

        if(currentNode == null)
            return -1;
        else
            return index;
    }

    public Object remove(int index)
    {
        checkIndex(index);

        Object removedElement;
        
        if(index == 0)
        {
            removedElement = firstNode.element;
            firstNode = firstNode.next;
        }
        else
        {
            ChainNode p = firstNode;
                for(int i=0;i<index-1;i++)
                    p=p.next;

            removedElement = p.next.element;
            p.next = p.next.next;
        }
        size--;

        return removedElement;
    }

    public void add(int index, Object theElement)
    {
        if(index<0 || index>size)
            throw new IndexOutOfBoundsException
                ("Index= " +index+ " Size= "+size);

        if(index == 0)
            firstNode = new ChainNode(theElement, firstNode);
        else
        {
            ChainNode q = firstNode;
                for(int i=0;i<index-1;i++)
                    q = q.next;

            q.next = new ChainNode(theElement,q.next);
        }

        size++;
    }

    public String toString()
    {
        StringBuffer s = new StringBuffer("[");

        ChainNode currentNode = firstNode;
        while(currentNode != null)
        {
            if(currentNode.element == null)
                s.append("null, ");
            else
                s.append(currentNode.element.toString() +", ");

        currentNode = currentNode.next;
        }

        s.delete(s.length()-2, s.length());
        s.append("]");

        return new String(s);
    }

    /** returns an iterator type object */
    public Iterator iterator()
    {
        return new ChainIterator();
    }

    /** class that implements the interface iterator */
    private class ChainIterator implements Iterator
    {
        private ChainNode nextNode; // data field or member

        public ChainIterator()
        {
            nextNode = firstNode;
        }

        /** checks if there is an unexamined element left in the list  */
        public boolean hasNext()
        {
            return nextNode != null;
        }

        /** retruns an unexamined element in the list */
        public Object next()
        {
            if(nextNode != null) //checks if there is an unexamined element in the list
            {
                Object removedElement = nextNode.element;
                nextNode = nextNode.next; // moves to the next unexamined element
                return removedElement;
            }
            else
                 throw new NoSuchElementException("No next element");
        }

        /** remove menthod optional not implemented */
        public void remove()
        {
            throw new UnsupportedOperationException
                ("remove not supported");
        }

    }

    public static void main(String[] args)
    {
        LinearList x = new Chain(4);

        // checks add method
        x.add(0, new Integer(4));
        x.add(0, new Integer(3));
        x.add(0, new Integer(2));
        x.add(0, new Integer(1));

        Iterator y = x.iterator();

        while(y.hasNext())
        {
            System.out.println(y.next());
        }

    }
}