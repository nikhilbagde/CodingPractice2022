package OTT.P7_GeeksForGeeks.DataStructure.LinkedList.Set1;

import java.util.LinkedList;

/**
 * Created by Nikhil on 2/22/2017 5:21 PM.
 */
public class P7LengthOfList {
    static Node head;

    public static void main(String[] args) {
        /* 1->3->5->7->2->null */
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(3);
        list.add(5);
        list.add(7);
        list.add(9);
        list.add(2);
        list.add(4);
        lengthOflist(list);
    }

    private static int lengthOflist(LinkedList list) {
        if (head == null) return 0;
        Node current = head;
        int count = 0;
        while (current != null) {
            current = current.next;
            ++count;
        }
        return count;
    }

    private static int lengthOfListRec(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + lengthOfListRec(node.next);
    }

    private static void add(int data) {
        Node node = new Node(data);
        node.next = head;
        head = node;
    }
}
