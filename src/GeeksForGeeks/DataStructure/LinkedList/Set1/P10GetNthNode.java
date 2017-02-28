package GeeksForGeeks.DataStructure.LinkedList.Set1;

/**
 * Created by Nikhil on 2/22/2017 6:31 PM.
 */
public class P10GetNthNode {
    static Node head;

    private static Node getNthNode(int position) {
        int count = 0;
        if (head == null) return null;

        Node current = head;
        while (current != null) {
            if (count-- == position) return current;
            current = current.next;
        }
        return null;
    }
}
