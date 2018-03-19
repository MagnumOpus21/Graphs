import graph.*;

public class Driver {
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(1, 2, 5);
        graph.addEdge(2, 3, 10);
        graph.addEdge(1, 3, 11);
        graph.addEdge(3, 5, 25);
        graph.addEdge(1, 4, 1);
        graph.addEdge(2, 5, 10);
        graph.display();
        graph.Djikstra(1);
        graph.getPathCost().forEach(System.out::println);
    }
}
