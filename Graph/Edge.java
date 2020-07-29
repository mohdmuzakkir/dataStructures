package dataStructures;

// Graph class uses the data type Edge.
// Its lone data member is vertex1 and vertex2 of type int and they represent endpoints of an edge.
public class Edge {
    int vertex1;
    int vertex2;

    public Edge(int v1, int v2){
        vertex1 = v1;
        vertex2 = v2;
    }

    public String toString(){
        return "(" + String.valueOf(vertex1) + ", " + String.valueOf(vertex2) + ")";
    }
}