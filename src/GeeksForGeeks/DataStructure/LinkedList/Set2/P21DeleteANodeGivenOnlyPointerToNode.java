package GeeksForGeeks.DataStructure.LinkedList.Set2;

/**
 * Created by Nikhil on 2/23/2017 8:28 AM.
 */
public class P21DeleteANodeGivenOnlyPointerToNode {
    static Node head;

    private static void deleteANode(Node node) {
        //this node is pointer to given node and not head.
        //head is not available lets say.

        if (node == null || node.next == null) {
            return;
        }
        node.data = node.next.data;
        node.next = node.next.next;
    }
}
