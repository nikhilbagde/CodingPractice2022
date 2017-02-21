package DataStructure.MyDataStructures.Graphs;

import java.util.*;

/**
 * Created by Nikhil on 2/14/2017 10:09 PM.
 * 0: 1
 * 1: 2
 * 2: 0, 3
 * 3: 2
 * 4: 6
 * 5: 4
 * 6: 5
 */
public class Graph {
    //Options: can create array of nodes

    private Node[] nodesArray;
    private HashMap<Integer, Node> nodesMap = new HashMap<Integer, Node>();

    private Node getNode(int id) {
        return nodesMap.get(id);
    }

    public void addEdge(int source, int destination) {
        Node s = getNode(source);
        Node d = getNode(destination);
        s.adjacentList.add(d);
    }

    public boolean hasPathDFS(int source, int destination) {
        Node s = getNode(source);
        Node d = getNode(destination);

        Set<Integer> visited = new HashSet<>();
        return hasPathDFS(s, d, visited);
    }

    private boolean hasPathDFS(Node source, Node destination, Set<Integer> visited) {
        if (visited.contains(source.id)) return false;
        visited.add(source.id);

        if (source == destination) return true;

        for (Node child : source.adjacentList) {
            if (hasPathDFS(child, destination, visited)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasPathBFS(int source, int destination) {
        return hasPathBFS(getNode(source), getNode(destination));
    }

    private boolean hasPathBFS(Node source, Node destination) {
        Queue<Node> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(source);
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();

            if (currentNode == destination) return true;         // found node, there is a path

            if (visited.contains(currentNode.id)) continue;      // already visited.

            visited.add(currentNode.id);                        // mark visited.

            for (Node child : currentNode.adjacentList) {        // do for all children and add to queue.
                queue.add(child);
            }
        }
        return false;
    }

    private void genericBFS(Node source, Node Destination) {
        Queue<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        Map<Node, Node> parent = new HashMap<>();

        queue.offer(source);
        parent.put(source, null);

        while (!queue.isEmpty()) {
            Node vertex = queue.poll();
            processVertexEarly(vertex);

            visited.add(vertex);

            for (Node child : vertex.adjacentList) {
                if (child.state != State.Processing) {     //!visited.contains(child)
                    processEdge(vertex, child);
                }
                if (child.state != State.Visited) {
                    queue.offer(child);
                    child.state = State.Visited;
                    parent.put(child, vertex);
                }
            }
            processVertexLate(vertex);
        }
    }

    private void processVertexEarly(Node vertex) {
        vertex.state = State.Processing;
        System.out.println("Processing Vertex Early" + vertex);
    }

    private void processEdge(Node vertex, Node child) {
        child.state = State.Processing;
        vertex.state = State.Processing;
        System.out.println("Processing Edge" + vertex + " " + child);
    }

    private void processVertexLate(Node vertex) {
        System.out.println("Processing Vertex Late" + vertex);
    }

    enum State {Unvisited, Processing, Visited}

    public static class Node {
        // What it contains ?: Say int value
        State state;
        // What are its adjacent nodes ? :
        // Array, ArrayList, LinkedList
        LinkedList<Node> adjacentList = new LinkedList<>();
        private int id;

        private Node(int id) {
            this.id = id;
            state = State.Unvisited;
        }
    }
}
