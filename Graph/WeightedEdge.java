package dataStructures;

// Graph class uses the data type EdgeNode.
// Its lone data member is vertex1, vertex2 of type int and weight of type Object.
public class WeightedEdge {
    Object weight;
    int vertex1;
    int vertex2;

    public WeightedEdge(int v1, int v2, Object theWeight){
        vertex1 = v1;
        vertex2 = v2;
        weight = theWeight;
    }

    public String toString(){
        return "(" + String.valueOf(vertex1) + ", " + String.valueOf(vertex2) + ", " +weight.toString() + ")";
    }
}