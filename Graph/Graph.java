package dataStructures;

import java.util.*;

/**
 * Graph
 */
public abstract class Graph {

    public abstract int vertices();
    public abstract int edges();
    public abstract boolean existsEdge(int i, int j);
    public abstract void putEdge(Object theEdge);
    public abstract void removeEdge(int i, int j);
    public abstract int degree(int i);
    public abstract int inDegree(int i);
    public abstract int outDegree(int i);

    // creates an iterator for vertex i
    public abstract Iterator iterator(int i);
}