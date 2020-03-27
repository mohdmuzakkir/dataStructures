package dataStructures;

/**ChainNode class creates a node with data and link elment in a node */
class ChainNode
{
    // data members will be visible to all the classes within the package
    Object element; // data element
    ChainNode next; // link element

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
