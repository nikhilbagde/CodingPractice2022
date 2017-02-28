package GeeksForGeeks.DataStructure.LinkedList.Set1;

/**
 * Created by Nikhil on 2/22/2017 6:47 PM.
 */
public class P15FrequencyOfNode {
    static Node head;

    private static int frequencyOfNode(Node node) {
        int frequency = 0;
        Node current = head;
        while (current != null) {
            if (current.data == node.data) ++frequency;
            current = current.next;
        }
        return frequency;
    }
}
