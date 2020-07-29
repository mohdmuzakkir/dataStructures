package dataStructures;

import java.util.*;

public class AdjacencyWGraph extends AdjacencyWDigraph{

    // constructors
    public AdjacencyWGraph(int theVertices){
        super(theVertices);
    }

    public AdjacencyWGraph(){
        this(0);
    }


    // methods

    // inserts an edge between the vertices
    public void putEdge(Object theEdge){
        WeightedEdge edge = (WeightedEdge) theEdge;
        int v1 = edge.vertex1;
        int v2 = edge.vertex2;

        if(v1<1 || v2<1 || v1>n || v2>n || v1==v2)
            throw new IllegalArgumentException("(" + v1 + ", " + v2 + ") are not permissible edges");
        
        if(a[v1][v2] == null) // increases the number of edge by 1 if the edge does not exist already
            e++;
        
        a[v1][v2] = edge.weight;
        a[v2][v1] = edge.weight;
    }

    //removes the edge between vertex i and j
    public void removeEdge(int i, int j){
        if(i>=1 && j>=1 && i<=n && j<=n && a[i][j] != null){
            e--; // if edge exist decrease it by 1
            a[i][j] = null;
            a[j][i] = null;
        }
    }

    public int degree(int i){
        if(i<1 || i>n)
            throw new IllegalArgumentException("no such vertex: "+i);

        int count=0; // to count the number of outdegree
        for(int j=1; j<=n; j++)
            if(a[i][j] != null)
                count++;

        return count;
    }
    
    public int outDegree(int i){
        return degree(i);
    }

    public int inDegree(int i){
        return degree(i);
    }

    public static void main(String[] args) {
        AdjacencyWGraph g = new AdjacencyWGraph(5);

        g.putEdge(new WeightedEdge(2, 4, Integer.valueOf(1)));
        g.putEdge(new WeightedEdge(1, 3, Integer.valueOf(2)));
        g.putEdge(new WeightedEdge(2, 1, Integer.valueOf(3)));
        g.putEdge(new WeightedEdge(1, 4, Integer.valueOf(4)));
        g.putEdge(new WeightedEdge(5, 4, Integer.valueOf(5)));
    
        System.out.println("The graph is");
        g.output();

        System.out.println("existsEdge(3,1) = " + g.existsEdge(3,1));
        System.out.println("existsEdge(1,3) = " + g.existsEdge(1,3));
        System.out.println("inDegree(3) = " + g.inDegree(3));
        System.out.println("outDegree(1) = " + g.outDegree(1));
        System.out.println("Edges = " + g.edges());
        System.out.println();

        g.removeEdge(2,1);
        System.out.println("The graph after deleting (2,1) is");
        g.output();
        System.out.println();

        // test iterator
        Iterator iter = g.iterator(4);
        System.out.println("Edges out of vertex 4 are");
        while (iter.hasNext())
        {
            WeightedEdgeNode w = (WeightedEdgeNode) iter.next();
            System.out.println("(4, " + w + ")");
        }
    }
}