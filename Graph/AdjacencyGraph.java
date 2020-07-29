package dataStructures;

import java.util.*;

public class AdjacencyGraph extends AdjacencyDigraph {
    // constructors
    public AdjacencyGraph(int theVertices){
        super(theVertices);
    }

    public AdjacencyGraph(){
        this(0);
    }

    // methods

    // inserts an edge between the vertices
    public void putEdge(Object theEdge){
        Edge edge = (Edge) theEdge;
        int v1 = edge.vertex1;
        int v2 = edge.vertex2;

        if(v1<1 || v2<1 || v1>n || v2>n || v1==v2)
            throw new IllegalArgumentException("(" + v1 + ", " + v2 + ") are not permissible edges");
        
        if(a[v1][v2] == false){
            a[v1][v2] = true;
            a[v2][v1] = true;
            e++;
        }
    }

    //removes the edge between vertex i and j
    public void removeEdge(int i, int j){
        if(i>=1 && j>=1 && i<=n && j<=n && a[i][j] == true){
            a[i][j] = false;
            a[j][i] = false;
            e--; // if edge exist decrease it by 1
        }
    }

    public int degree(int i){
        if(i<1 || i>n)
            throw new IllegalArgumentException("no such vertex: "+i);

        int count=0; // to count the number of outdegree
        for(int j=1; j<=n; j++)
            if(a[i][j])
                count++;

        return count;
    }
    
    public int outDegree(int i){
        return degree(i);
    }

    public int inDegree(int i){
        return degree(i);
    }

    public static void main(String [] args)
   {
      AdjacencyGraph g = new AdjacencyGraph(4);
      System.out.println("Edges = " + g.edges());
      System.out.println();

      g.putEdge(new Edge(2, 4));
      g.putEdge(new Edge(1, 3));
      g.putEdge(new Edge(2, 1));
      g.putEdge(new Edge(1, 4));
      g.putEdge(new Edge(4, 2));
      System.out.println("The graph is");
      g.output();
      System.out.println();

      g.removeEdge(2,1);
      System.out.println("The graph after deleting (2,1) is");
      g.output();
      System.out.println();

      System.out.println("existsEdge(3,1) = " + g.existsEdge(3,1));
      System.out.println("inDegree(3) = " + g.inDegree(3));
      System.out.println("outDegree(1) = " + g.outDegree(1));
      System.out.println("Edges = " + g.edges());
      System.out.println();

      // test iterator
      Iterator iter = g.iterator(4);
      System.out.println("Edges incident to vertex 4 are");
      while (iter.hasNext())
      {
         EdgeNode w = (EdgeNode) iter.next();
         System.out.println("(4, " + w.vertex + ")");
      }
   }
}