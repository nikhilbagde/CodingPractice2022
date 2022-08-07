package OTT.P7_GeeksForGeeks.DataStructure.LinkedList.Set2;

/**
 * Created by Nikhil on 2/23/2017 9:41 AM.
 */
public class P23IntersectingPointOfTwoLinkedList {
    static Node head;

    private static Node intersectingNode(Node head1, Node head2) {
        int count1 = getCount(head1);
        int count2 = getCount(head2);

        int diff = Math.abs(count1 - count2);

        Node current1 = head1;
        Node current2 = head2;

        if (count1 > count2) {
            while (diff-- > 0 /*&& current!=null && current.next!=null*/) {
                current1 = current1.next;
            }
        } else {
            while (diff-- > 0 /*&& current!=null && current.next!=null*/) {
                current2 = current2.next;
            }
        }
        while (current1.data != current2.data) {
            current1 = current1.next;
            current2 = current2.next;
        }

        return current1;
    }

    private static int getCount(Node head) {
        Node current = head;
        int result = 0;
        while (current != null) {
            ++result;
            current = current.next;
        }
        return result;
    }
}
