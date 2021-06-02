package Patterns.educative.io.java1;

class ListNode1 {
    int value = 0;
    ListNode1 next;

    ListNode1(int value) {
        this.value = value;
    }
}
public class F_InPlaceReversalLinkedList {

    public  static ListNode1 reverseList(ListNode1 head) {
        ListNode1 curr = head;
        ListNode1 prev = null;
        while(curr!=null){
            ListNode1 next = curr.next;
            curr.next = prev;
            prev= curr;
            curr = next;
        }
        return prev;
    }
    public static ListNode1 reverseBetweenTwoMiddleNodes(ListNode1 head, int p, int q) {
        if (p == q) return head;        //if both numbers are same then there is nothing to reverse.

        ListNode1 headCopy = head;
        ListNode1 prev = null, curr = head;

        //iterate till first p location. keeping prev node
        int i = 1;
        while (curr != null & i < p) {
            prev = curr;
            curr = curr.next;
            i++;
        }

        //Store perv and curr pointers to start and end.
        ListNode1 start = prev;
        ListNode1 end = curr;

        //from given p location to q location, (q-p+1) times iterate over a loop and reverse all nodes.
        prev = null;
        for (i = 0; curr != null & i < q-p+1; i++) {
            ListNode1 next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        //prev pointer will be starting pointer of reversed list, set it to next of start.
        if (start != null) start.next = prev;
        else headCopy = prev;

        end.next = curr;        //didn't get this part.
        return headCopy;

        /*
          1->2->3->4->5->6->null   p=3 q=5
initially : prev = 2 , curr = 3
                start = 2, end = 3

                Notice after we reverse the linked-list we need to first reverse inner sublist: 3->4->5 ->6 (q-p"+1")   to 5->4->3->
                                                                                                                                                prev = 5
                                                                                                                                                curr = 6
                we need to short circuit it with original list.                                                                   ^
                1] 2-> (Start) -> should be 5      1->2->5->                                                                    |
                hence start.next = prev                                                                                                    |
                2]  for the next part we want, 5->4->3->   three to point to 6                                    |
                we had stored 3 as end pointers -> next of this would be current pointer 6           |
                Hence end.next = curr;
         */
    }
    public static ListNode1 reverseEveryKNodes(ListNode1 head, int k) {
        if (head == null || k <= 1) return head;
        ListNode1 prev = null, curr = head;
        ListNode1 start = prev, end = curr;
        while (true) {
            start = prev;
            end = curr;
            for (int i = 0; i < k && curr != null; i++) {
                ListNode1 temp = curr.next;
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

    public static ListNode1 reverseEveryKAlternateNodes(ListNode1 head, int k) {
        if (head == null || k <= 1) return head;
        ListNode1 prev = null, curr = head;
        ListNode1 start = prev, end = curr;
        boolean reverse = true;
        while (true) {
            start = prev;
            end = curr;
            if (reverse) {
                reverse = false;
                for (int i = 0; curr != null && i < k; i++) {
                    ListNode1 temp = curr.next;
                    curr.next = prev;
                    prev = curr;
                    curr = temp;
                }
                if (start != null) start.next = prev;
                else head = prev;
                end.next = curr;
                prev = end;
                if (curr == null) break;
            } else {
                reverse = true;
                ListNode1 temp = curr;
                for (int i = 0; curr != null && i < k; i++) {
                    prev = curr;
                    curr = curr.next;
                }
                if (curr == null) {
                    curr = temp;
                    break;
                }
            }
        }
        return head;
    }

    public static ListNode1 rotateListToRightByKNodes(ListNode1 head, int rotations) {
        if (head == null || rotations == 0) return head;
        ListNode1 prev = null, curr = head, start = head;
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
        ListNode1 head = new ListNode1(2);
        head.next = new ListNode1(4);
        head.next.next = new ListNode1(6);
        head.next.next.next = new ListNode1(8);
        head.next.next.next.next = new ListNode1(10);

        ListNode1 result = F_InPlaceReversalLinkedList.reverseList(head);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}
