package dataStructures;

class ChainNode
{
    // data members will be visible to all the classes within the package
    Object element;
    ChainNode next;

    // package visible constructors
    ChainNode()
    {
        // default values of element and next will be set to null
    }

    ChainNode(Object element)
    {
        this.element = element; //default value of next will be set to null
    }

    ChainNode(Object element,ChainNode next)
    {
        this.element = element;
        this.next = next;
    }

}