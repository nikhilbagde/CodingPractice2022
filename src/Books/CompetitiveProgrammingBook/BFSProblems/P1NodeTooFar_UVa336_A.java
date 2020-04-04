package Books.CompetitiveProgrammingBook.BFSProblems;

import java.util.*;

/**
 * Created by Nikhil on 2/17/2017 3:29 AM.
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=272
 */
public class P1NodeTooFar_UVa336_A {
    private static Scanner scanner = new Scanner(System.in);
    private static int totalNodes;

    public static void main(String[] args) throws Exception {
        while (scanner.hasNext()) {
            Network network = input();
            query(network);
        }
    }

    public static Network input() throws Exception {
        totalNodes = scanner.nextInt();
        Network network = new Network();
        while (totalNodes-- > 0)
            network.addEdge(scanner.nextInt(), scanner.nextInt());
        return network;
    }

    public static void query(Network network) {

        int caseCount = 1;
        while (true) {
            int startNode = scanner.nextInt();
            int TTL = scanner.nextInt();
            if (startNode == 0 && TTL == 0) break;
            System.out.println("Case " + caseCount++ + ": " + network.getUnvisitedCountBFS(startNode, TTL) + " nodes not reachable from node " + startNode + " with TTL = " + TTL + ".");
        }
    }

}

class Network {

    private static int MAX_NODES = 30;
    //private Map<Nodes, TreeSet<Nodes>> adjacencyMap;  // = new Nodes[MAX_NODES];
    private Map<Nodes, LinkedList<Nodes>> adjacencyMap;  // = new Nodes[MAX_NODES];
    private Map<Integer, Nodes> vertexMap;  // = new Nodes[MAX_NODES];

    private int currentCapacity = 0;
    private boolean isDirected = false;
    private int numberEdges = 0;

    //private int numberVertices = 0;

    public Network() {
        adjacencyMap = new HashMap<>();
        vertexMap = new HashMap<>();
    }

    void addEdge(int start, int end) {
        Nodes u = null, v = null;
        u = !vertexMap.containsKey(start) ? addVertex(start) : vertexMap.get(start);
        v = !vertexMap.containsKey(end) ? addVertex(end) : vertexMap.get(end);

        assert u != null && v != null;
        adjacencyMap.get(u).add(v);
        if (!isDirected) adjacencyMap.get(v).add(u);

        //Other way, keep adjacency list in node class itself.
        /*assert u != null;
        u.adjacencyList.add(v);
        assert v != null && !isDirected;
        v.adjacencyList.add(u);*/
    }

    Nodes addVertex(int value) {
        Nodes nodes = new Nodes(value);
        vertexMap.put(value, nodes);

        //adjacencyMap.put(nodes, new TreeSet<>());     //to use TreeSet Node class should implement Comparator. ugghh!
        adjacencyMap.put(nodes, new LinkedList<>());
        numberEdges++;
        return nodes;
    }

    int getUnvisitedCountBFS(int value, int TTL) {
        int result = 0;
        Nodes start = vertexMap.get(value);

        Set<Nodes> visited = new HashSet<>();
        Queue<Nodes> queue = new LinkedList<>();
        Queue<Integer> expireTime = new LinkedList<>();

        queue.offer(start);
        expireTime.offer(TTL);
        while (!queue.isEmpty()) {
            Nodes current = queue.poll();
            int currentExpireTime = expireTime.poll();

            if (currentExpireTime != 0) {
                visited.add(current);
                for (Nodes child : adjacencyMap.get(current)) {
                    if (!visited.contains(child)) {
                        visited.add(child);
                        queue.offer(child);
                        expireTime.offer(currentExpireTime - 1);
                    }
                }
            } else {
                //return result = countUnvisited(visited, vertexMap);
                return result = vertexMap.size() - visited.size();
            }
        }
        return result;
    }

    private int countUnvisited(Set<Nodes> visited, Map<Integer, Nodes> nodeMap) {
        int result = 0;
        for (Nodes node : nodeMap.values()) {
            if (visited.contains(node)) result++;
        }
        return nodeMap.size() - result;
    }

    static class Nodes {
        int value;
        int TTL;

        //List<Nodes> adjacencyList;
        Nodes(int value) {
            this.value = value;
            //adjacencyList = new LinkedList<>();
        }
    }
}

/*
16
10 15 15 20 20 25 10 30 30 47 47 50 25 45 45 65
15 35 35 55 20 40 50 55 35 40 55 60 40 60 60 65
35 2 35 3 0 0
14
1 2 2 7 1 3 3 4 3 5 5 10 5 11
4 6 7 6 7 8 7 9 8 9 8 6 6 11
1 1 1 2 3 2 3 3 0 0
 */


/*
Graph:
1. Create a Adjacency Map data structure: Map : [ Vertex, LinkedList ]
2. Create a Vertex Map : [ Integer : Vertex ]


Construct Graph:
    1. Get two integers,
        1. if vertex already present in VertexMap : directly get vertex node for that integer
        2. else ADD a new Vertex.

            [ADD New Vertex
            1. create new Vertex
                    Create New Vertex
                        1. Node class will have int: value
            2. Store it in VertexMap : [Integer: Vertex]
            3. Add Vertex and New LinkedList to "AdjacencyMap"
            4. Increment total number of edges.
            5. Return newly created Vertex/Node.]

        3. Check Both newly created or already created u and v nodes are not empty
        4. If not, Get Access AdjacencyMap and Get LinkedList of First Node/Vertex and Store other vertex to this linkedList
                    Do same for other vertex and store first vertex to its LinkedList.

 */