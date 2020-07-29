package dataStructures;

import java.util.*;

public class AdjacencyDigraph {
    // data members
    int n; // number of vertices
    int e; // number of edges
    boolean[][] a;

    // constructors
    public AdjacencyDigraph(int theVertices){
        if(theVertices < 0)
            throw new IllegalArgumentException("number of vertices must be > 0");

        n= theVertices;
        a = new boolean[n+1][n+1];
        // default values of e=0 and a[i][j]=false
    }

    // constructor for default 0 vertex graph
    public AdjacencyDigraph(){
        this(0);
    }

    // methods
    public int vertices(){
        return n;
    }

    public int edges(){
        return e;
    }

    // returns true if edge exist otherwise false
    public boolean existsEdge(int i, int j){
        if(i<1 || i>n || j<1 || j>n)
            return false;
        else
            return a[i][j];
    }

    // inserts an edge between the vertices
    public void putEdge(Object theEdge){
        Edge edge = (Edge) theEdge;
        int v1 = edge.vertex1;
        int v2 = edge.vertex2;

        if(v1<1 || v2<1 || v1>n || v2>n || v1==v2)
            throw new IllegalArgumentException("(" + v1 + "," + v2 + ") are not permissible edges");
        
        if(!a[v1][v2]){ 
            a[v1][v2] = true;
            e++; // increases the number of edge by 1
        }
    }

    //removes the edge between vertex i and j
    public void removeEdge(int i, int j){
        if(i>=1 && j>=1 && i<=n && j<=n && a[i][j]){
            a[i][j] = false;
            e--; // if edge exist decrease it by 1
        }
    }

    public int degree(int i){
        throw new NoSuchMethodError();
    }

    //returns the number of outdegree of vertex i
    public int outDegree(int i){
        if(i<1 || i>n)
            throw new IllegalArgumentException("no such vertex: "+i);

        int count=0; // to count the number of outdegree
        for(int j=1; j<=n; j++)
            if(a[i][j])
                count++;

        return count;
    }

    //returns the number of indegree of vertex i
    public int inDegree(int i){
        if(i<1 || i>n)
            throw new IllegalArgumentException("no such vertex: "+i);

        int count=0;
        for(int j=1; j<=n; j++)
            if(a[j][i])
                count++;

        return count;
    }

    // output the adjacency matrix
   public void output()
   {
      for (int i = 1; i <= n; i++){
         for (int j = 1; j <= n; j++){
            if (a[i][j]) 
               System.out.print("1 ");
            else
               System.out.print("0 ");
         }
         System.out.println();
      }
   }

   public Iterator iterator(int i) {
       if(i<1 || i>n)
            throw new IllegalArgumentException("no such vertex: "+i);

        return new VertexIterator(i);
   }

   private class VertexIterator implements Iterator{
        // data member
        private int v; // vertex being iterated
        private int nextVertex; // next adjacent vertex

        // constructor
        public VertexIterator(int i){
            v = i;
            // finds the next adjacent vertex
            for(int j=1; j<=n; j++)
                if(a[i][j]){
                    nextVertex = j;
                    return;
                }

            // if no adjacent vertex
            nextVertex = n+1;
        }

        // methods
        public boolean hasNext(){
            return nextVertex <= n;
        }

        public Object next(){
            if(nextVertex <= n){
                int u = nextVertex;

                for(int j=u+1; j<=n; j++)
                    if(a[v][j]){
                        nextVertex = j;
                        return new EdgeNode(u);
                    }

                // if there is no next vertex
                nextVertex = n+1;
                return new EdgeNode(u);
            }

            else
                throw new NoSuchElementException("no next vertex");
        }

        public void remove(){
            throw new UnsupportedOperationException();
        }
    }

   public static void main(String [] args)
   {
      AdjacencyDigraph g = new AdjacencyDigraph(4);

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