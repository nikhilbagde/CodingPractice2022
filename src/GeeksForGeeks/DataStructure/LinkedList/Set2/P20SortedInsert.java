package GeeksForGeeks.DataStructure.LinkedList.Set2;

/**
 * Created by Nikhil on 2/23/2017 7:31 AM.
 * HEAD->2->5->7->10->15->NULL Insert 9, Insert 1, Insert 20.
 */
public class P20SortedInsert {
    static Node head;

    private static Node insertInSortedList(int value) {
        if (head == null) return null;
        if (value < head.data) {
            Node node = new Node(value);
            node.next = head;
            head = node;
        }
        Node current = head;
        while (current.next != null && value < current.next.data)
            current = current.next;

        Node node = new Node(value);
        node.next = current.next;       //always first change the next point of temp node.
        current.next = node;            //then modify next pointer of node in case.

        return head;
    }
}
