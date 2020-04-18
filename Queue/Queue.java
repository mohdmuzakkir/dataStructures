package dataStructures;

public interface Queue
{
    public boolean isEmpty();
    public Object getFrontElement();
    public Object getRearElement();
    public void put(Object theElement);
    public Object remove();
}