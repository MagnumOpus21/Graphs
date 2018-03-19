import java.util.List;

public class Node {
    int from;
    List<Edges> edgesList;

    public Node(int i, List<Edges> edgesList) {
        this.from = i;
        this.edgesList = edgesList ;
    }
}
