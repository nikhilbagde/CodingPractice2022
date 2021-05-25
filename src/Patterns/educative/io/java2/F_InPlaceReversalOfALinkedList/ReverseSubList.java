package Patterns.educative.io.java2.F_InPlaceReversalOfALinkedList;

class ListNode4 {
    int value = 0;
    ListNode4 next;

    ListNode4(int value) {
        this.value = value;
    }
}

class ReverseSubList {

    public static ListNode4 reverse(ListNode4 head, int p, int q) {
        // TODO: Write your code here
        if (p == q) return head;
        ListNode4 headCopy = head;
        ListNode4 prev = null, curr = head;
        int i = 1;
        while (curr != null & i < p) {
            prev = curr;
            curr = curr.next;
            i++;
        }
        ListNode4 start = prev;
        ListNode4 end = curr;
        prev = null;
        for (i = 0; curr != null & i < q-p+1; i++) {
            ListNode4 temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        if (start != null) start.next = prev;
        else headCopy = prev;
        end.next = curr;
        return headCopy;
    }

    public static void main(String[] args) {
        ListNode4 head = new ListNode4(1);
        head.next = new ListNode4(2);
        head.next.next = new ListNode4(3);
        head.next.next.next = new ListNode4(4);
        head.next.next.next.next = new ListNode4(5);

        ListNode4 result = ReverseSubList.reverse(head, 2, 4);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}