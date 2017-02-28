package GeeksForGeeks.DataStructure.LinkedList.Set1;

/**
 * Created by Nikhil on 2/22/2017 6:38 PM.
 */
public class P13NthNodeFromEnd {
    static Node head;

    private static Node NthNodeFromLast(Node head, int index) {
        if (head == null) return null;

        Node first = head, second = head;
        int count = index;
        //make one pointer to run till that index e.g. 7th for 10 Nodes.
        while (count-- > 0) {
            first = first.next;
        }

        while (first != null) {
            second = second.next;
            first = first.next;
        }
        return second;
    }
}
