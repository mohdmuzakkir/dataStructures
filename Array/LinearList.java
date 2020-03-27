package dataStructures;

/** interface for LinearList to be implemented in Arrays, Linked List, etc */

public interface LinearList 
{
    public boolean isEmpty();
    public int size();
    public Object get(int index);
    public int indexOf(Object theElement);
    public Object remove(int index);
    public void add(int index, Object theElement);
    public String toString();
    
}
