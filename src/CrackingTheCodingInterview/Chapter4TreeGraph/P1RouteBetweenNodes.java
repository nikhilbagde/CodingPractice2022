package CrackingTheCodingInterview.Chapter4TreeGraph;

import DataStructure.MyDataStructures.Graphs.Graph;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Nikhil on 2/15/2017 12:34 AM.
 * Given a directed graph, design an algorithm to find out whether there is a route between two nodes.
 * Hints:
 * #127 - DFS or BFS which is better?
 */
public class P1RouteBetweenNodes {
    //private Node[] nodesArray;
    private static HashMap<Integer, Node> map = new HashMap<>();

    public static Collection<Node> getNodes() {
        return map.values();
    }

    public boolean hasPathBFS(Graph graph, Node start, Node destionation) {
        if (start == destionation) return true;

        Queue<Node> queue = new LinkedList<>();

        for (Node node : P1RouteBetweenNodes.getNodes()) {
            node.state = State.unvisited;
        }

        start.state = State.visiting;
        queue.offer(start);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node == destionation) return true;
            node.state = State.visited;

            for (Node child : node.adjacencyList) {
                if (child.state == State.unvisited) { //only if unvisited
                    if (child == destionation) {     //check for deistination arriaved.
                        return true;
                    } else {
                        child.state = State.visiting;
                        queue.offer(child);
                    }
                }
            }
        }
        return false;
    }


    enum State {visited, unvisited, visiting}

    public static class Node {
        int element;
        LinkedList<Node> adjacencyList = new LinkedList<>();
        State state;
    }
}
