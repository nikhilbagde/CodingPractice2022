package Patterns.educative.io.java2.F_InPlaceReversalOfALinkedList;

class ListNode2 {
    int value = 0;
    ListNode2 next;

    ListNode2(int value) {
        this.value = value;
    }
}

class ReverseEveryKElements1 {

    public static ListNode2 reverse(ListNode2 head, int k) {
        // TODO: Write your code here
        if (head == null || k <= 1) return head;
        ListNode2 prev = null, curr = head;
        ListNode2 start = prev, end = curr;
        while (true) {
            start = prev;
            end = curr;
            for (int i = 0; i < k && curr != null; i++) {
                ListNode2 temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
            if (start != null) start.next = prev;
            else head = prev;

            end.next = curr;
            prev = end;
            if (curr == null) break;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode2 head = new ListNode2(1);
        head.next = new ListNode2(2);
        head.next.next = new ListNode2(3);
        head.next.next.next = new ListNode2(4);
        head.next.next.next.next = new ListNode2(5);
        head.next.next.next.next.next = new ListNode2(6);
        head.next.next.next.next.next.next = new ListNode2(7);
        head.next.next.next.next.next.next.next = new ListNode2(8);

        ListNode2 result = ReverseEveryKElements1.reverse(head, 3);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}