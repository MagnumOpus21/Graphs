package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;


public class Graph {
    int vertices;
    List<Node> nodes;
    List<Boolean> visited;
    List<Integer> pathCost;

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    public List<Boolean> getVisited() {
        return visited;
    }

    public void setVisited(List<Boolean> visited) {
        this.visited = visited;
    }

    public List<Integer> getPathCost() {
        return pathCost;
    }

    public void setPathCost(List<Integer> pathCost) {
        this.pathCost = pathCost;
    }

    public Graph(int vertices) {
        this();
        this.vertices = vertices;
        nodes = new ArrayList<>();
        visited = new ArrayList<>();
        pathCost = new ArrayList<>();
        for (int i = 0; i < this.vertices; i++) {
            nodes.add(i, new Node(i, new ArrayList<>()));
            visited.add(false);
            pathCost.add(Integer.MAX_VALUE);
        }
    }

    Graph() {
        this.vertices = 0;
        nodes = null;
        visited = null;
        pathCost = null;
    }

    public void addEdge(int from, int to, int weight) {
        Node temp = nodes.get(from - 1);
        Node otemp = nodes.get(to - 1);
        List<Edges> tempEdge = temp.edgesList;
        List<Edges> otempEdge = otemp.edgesList;
        tempEdge.add(new Edges(to - 1, weight)); // A ---> B
        temp.edgesList = tempEdge;
        otempEdge.add(new Edges(from - 1, weight)); // B ---> A
        otemp.edgesList = otempEdge;
    }

    public void Djikstra(int source) {
        this.pathCost.set(source - 1, 0);
        PriorityQueue<QueueElement> nodePriorityQueue = new PriorityQueue<QueueElement>((QueueElement n1, QueueElement n2) -> {
            return (n1.weight <= n2.weight) ? -1 : 1;
        });
        nodePriorityQueue.add(new QueueElement(source - 1, pathCost.get(source - 1)));
        while (nodePriorityQueue.size() >= 1) {
            QueueElement current = nodePriorityQueue.poll();
            this.visited.set(current.element, true);
            Node currentElement = this.nodes.get(current.element);
            if (currentElement.edgesList.size() == 0)
                continue;
            currentElement.edgesList.forEach((edges -> {
                int nDistance = current.weight + edges.weight;
                if (nDistance < this.pathCost.get(edges.to)) {
                    this.pathCost.set(edges.to, nDistance);
                    nodePriorityQueue.add(new QueueElement(edges.to, this.pathCost.get(edges.to)));
                }
            }));
        }
    }

    public void display() {
        for (int i = 0; i < this.vertices; i++) {
            Node current = nodes.get(i);
            if (current.edgesList.size() == 0) {
                System.out.println("No edges for " + current.from);
                continue;
            }
            current.edgesList.forEach((edge) -> {
                System.out.println((current.from + 1) + " goes to :");
                System.out.println("To: " + (edge.to + 1) + " Weight:" + edge.weight);
            });
        }
    }
}
