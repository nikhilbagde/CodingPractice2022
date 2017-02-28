package GeeksForGeeks.DataStructure.LinkedList.Set2;

/**
 * Created by Nikhil on 2/23/2017 9:59 AM.
 */
public class P25RemoveDuplicatesFromSortedList {
    static Node head;

    private static void removeDuplicate(Node head) {
        if (head == null) return;

        Node current = head;
        while (current != null && current.next != null) {
            if (current.data == current.next.data) {
                current.next = current.next.next;
            }
            current = current.next;
        }
    }
}
