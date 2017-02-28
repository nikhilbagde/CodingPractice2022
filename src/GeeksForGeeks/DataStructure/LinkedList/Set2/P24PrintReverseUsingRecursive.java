package GeeksForGeeks.DataStructure.LinkedList.Set2;

/**
 * Created by Nikhil on 2/23/2017 9:56 AM.
 */
public class P24PrintReverseUsingRecursive {
    static Node head;

    private static void printReverseRec(Node head) {
        if (head == null) return;

        printReverseRec(head.next);
        System.out.println(head.data + " ");
    }
}
