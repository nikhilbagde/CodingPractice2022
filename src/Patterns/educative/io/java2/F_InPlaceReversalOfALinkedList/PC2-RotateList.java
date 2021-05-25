package Patterns.educative.io.java2.F_InPlaceReversalOfALinkedList;

class ListNode1 {
    int value = 0;
    ListNode2 next;

    ListNode1(int value) {
        this.value = value;
    }
}

class RotateList {

    public static ListNode2 rotate(ListNode2 head, int rotations) {
        // TODO: Write your code here
        if (head == null || rotations == 0) return head;
        ListNode2 prev = null, curr = head, start = head;
        int len = 1;
        while (head.next != null) {
            head = head.next;
            len++;
        }
        int rot = len - rotations % len;
        if (rot == len) return curr;
        while (rot > 0) {
            prev = curr;
            curr = curr.next;
            rot--;
        }
        head.next = start;
        prev.next = null;
        return curr;
    }

    public static void main(String[] args) {
        ListNode2 head = new ListNode2(1);
        head.next = new ListNode2(2);
        head.next.next = new ListNode2(3);
        head.next.next.next = new ListNode2(4);
        head.next.next.next.next = new ListNode2(5);
        head.next.next.next.next.next = new ListNode2(6);

        ListNode2 result = RotateList.rotate(head, 3);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}