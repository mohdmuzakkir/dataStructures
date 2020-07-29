package dataStructures;

// Graph class uses the data type WeightedEdgeNode.
// Its data members are vertex of type int and weight of type Object.
public class WeightedEdgeNode {
    int vertex;
    Object weight;

    public WeightedEdgeNode(int v, Object theWeight){
        vertex = v;
        weight = theWeight;
    }

    public String toString(){
        return String.valueOf(vertex) + " " + weight.toString(); 
    }
}