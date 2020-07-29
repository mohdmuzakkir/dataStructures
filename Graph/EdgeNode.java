package dataStructures;

// Graph class uses the data type EdgeNode.
// Its lone data member is vertex of type int.
public class EdgeNode {
    int vertex;

    public EdgeNode(int v){
        vertex = v;
    }

    public boolean equals(Object x){
        return vertex == ((EdgeNode) x).vertex;
    }

    public String toString(){
        return String.valueOf(vertex);
    }
}