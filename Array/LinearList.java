package dataStructures;

/**ChainNode class creates a node with data and link elment in a node */

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
