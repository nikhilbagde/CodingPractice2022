package Books.CrackingTheCodingInterview.Chapter4TreeGraph;

/**
 * Created by Nikhil on 2/15/2017 12:55 AM.
 * Build Order: You are given a list of projects and a list of dependencies (which is a list of pairs of
 * projects, where the second project is dependent on the first project). All of a project's dependencies
 * must be built before the project is. Find a build order that will allow the projects to be built. If there
 * is no valid build order, return an error.
 * EXAMPLE
 * Input:
 * projects: a, b, c, d, e, f
 * dependencies: (a, d), (f, b), (b, d), (f, a), (d, c)
 * Output: f, e, a, b, d, c
 * Hints:
 * #26, - create a graph where node is project and edge between A to B when B depends upong A.
 * #47, - Look at graph is there any node we can build first.
 * #60, - First add node with no dependencies meaning no incoming edge.
 * #85, - One you build it, you can delete outgoing edge of that node and build rest of graph
 * #125, - Another Approach to try DFS and what is relation of DFS and build order?
 * #133 - When used DFS, go till last node, once we reach last node, we know that this node was one which was build last,
 * what does it means to node before this node.?
 */
public class P7BuildOrder {
}
