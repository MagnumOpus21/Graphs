public class Driver {
    public static void main(String[] args) {
        Graph graph = new Graph(3);
        graph.addEdge(1, 2, 5);
        graph.addEdge(2, 3, 10);
        graph.addEdge(1, 3, 11);
        graph.display();
    }
}
