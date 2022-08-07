package OTT.P7_GeeksForGeeks.DataStructure.LinkedList.Set2;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Nikhil on 2/23/2017 11:01 AM.
 */
public class P26RemoveDuplicateFromUnSortedList {
    static Node head;

    private static void removeDuplicatesFromUnSorted(Node head) {
        if (head == null) return;

        Node current = head;
        Node prev = null;
        Set<Node> set = new HashSet<>();

        while (current != null) {
            if (!set.contains(current)) {
                set.add(current);
            } else {
                prev.next = current.next;
            }
            prev = current;
            current = current.next;
        }
    }
}
