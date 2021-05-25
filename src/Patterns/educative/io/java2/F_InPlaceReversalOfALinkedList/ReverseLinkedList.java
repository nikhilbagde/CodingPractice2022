package Patterns.educative.io.java2.F_InPlaceReversalOfALinkedList;

class ListNode3 {
    int value = 0;
    ListNode3 next;

    ListNode3(int value) {
        this.value = value;
    }
}

class ReverseLinkedList {

    public static ListNode3 reverse(ListNode3 head) {
        // TODO: Write your code here
        ListNode3 prev = null;
        ListNode3 curr = head;
        while (curr != null) {
            ListNode3 next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    }

    public static void main(String[] args) {
        ListNode3 head = new ListNode3(2);
        head.next = new ListNode3(4);
        head.next.next = new ListNode3(6);
        head.next.next.next = new ListNode3(8);
        head.next.next.next.next = new ListNode3(10);

        ListNode3 result = ReverseLinkedList.reverse(head);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}