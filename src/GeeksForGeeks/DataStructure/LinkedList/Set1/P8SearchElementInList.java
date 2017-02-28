package GeeksForGeeks.DataStructure.LinkedList.Set1;

/**
 * Created by Nikhil on 2/22/2017 5:36 PM.
 */
public class P8SearchElementInList {
    static Node head;

    private static boolean searchInList(int value) {
        Node current = head;

        while (current != null && current.data != value) {
            current = current.next;
        }
        return current != null;

    }

    private static boolean searchInList(int value, Node node) {
        if (node == null) return false;
        if (node.data == value) return true;
        else return searchInList(value, node.next);
    }
}
