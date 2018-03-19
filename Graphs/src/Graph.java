import java.util.ArrayList;
import java.util.List;

public class Graph {
    int vertices;
    List<Node> nodes;

    Graph(int vertices) {
        this.vertices = vertices;
        nodes = new ArrayList<>();
        for (int i = 0; i < this.vertices; i++)
            nodes.add(i, new Node(i, new ArrayList<>()));
    }

    public void addEdge(int from, int to, int weight) {
        Node temp = nodes.get(from - 1);
        List<Edges> tempEdge = temp.edgesList;
        tempEdge.add(new Edges(to, weight));
        temp.edgesList = tempEdge;
    }

    public void display() {
        for (int i = 0; i < this.vertices; i++) {
            Node current = nodes.get(i);
            current.edgesList.forEach((edge) -> {
                if (edge == null)
                    System.out.println("No edges for this node" + current);
                else {
                    System.out.println(current.from + " goes to :");
                    System.out.println("To: " + edge.to + " Weight:" + edge.weight);
                }
            });
        }
    }
}
