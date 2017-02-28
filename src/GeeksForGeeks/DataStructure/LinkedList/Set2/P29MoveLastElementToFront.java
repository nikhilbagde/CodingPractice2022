package GeeksForGeeks.DataStructure.LinkedList.Set2;

/**
 * Created by Nikhil on 2/23/2017 12:20 PM.
 */
public class P29MoveLastElementToFront {
    static Node head;

    private static Node MoveLastToFist(Node head) {
        if (head == null) return null;

        Node current = head;
        Node prev = null;
        while (current.next != null) {
            prev = current;
            current = current.next;
        }
        current.next = head;
        head = current;

        prev.next = null;       //end that loop
        return head;
    }
}
