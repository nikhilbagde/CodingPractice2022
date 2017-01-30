package CrackingTheCodingInterview.Chapter2LinkedList;

import DataStructure.LinkedList.SLLNode;

/**
 * Created by Nikhil on 1/27/2017 12:27 AM.
 * Sum Lists: You have two numbers represented by a linked list, where each node contains a single
 * digit. The digits are stored in reverse order, such that the 1 's digit is at the head of the list. Write a
 * function that adds the two numbers and returns the sum as a linked list.
 * EXAMPLE
 * Input: (7-> 1 -> 6) + (5 -> 9 -> 2).That is,617 + 295.
 * Output: 2 -> 1 -> 9. That is, 912.
 * FOLLOW UP
 * Suppose the digits are stored in forward order. Repeat the above problem.
 * EXAMPLE
 * Input:(6 -> 1 -> 7) + (2 -> 9 -> 5).That is,617 + 295.
 * Output: 9 - > 1 -> 2. That is, 912.
 * Hints: #7,   = One way to convert list to integer and add and then back to list.
 *        #30,  = Other way to use recursive method.
 *        #71,  = Consider case when size of two linked list is not same
 *        #95,  = Solve for example
 *        #109  = If not same length, modify linked list by padding with zero at front of max unit place.
 * Page 105 : SOlt: 250
 */
public class P5SumLists {

    //Approach 1
    // 617  = 7->1->6       length 3        can add zero at head to make it equal length.
    // 1912 = 2->1->9->1    length 4
    // 2529
    private static int sumLists(SLLNode head1, SLLNode head2){
        return sumListsRec(head1, head2,0, new StringBuilder());
    }
    private static int sumListsRec(SLLNode head1, SLLNode head2, int carry, StringBuilder finalSum){
        if(head1==null && head2==null) return 0;
        if(head1==null) return Integer.valueOf(finalSum.append(head2.data+carry).toString());/*totalSum + getSumofSingleList(head2);*/
        if(head2==null) return Integer.valueOf(finalSum.append(head1.data+carry).toString());/*totalSum + getSumofSingleList(head1);*/

        int totalSum = head1.data + head2.data;
        carry = totalSum>=10 ? totalSum / 10 : 0;

        finalSum.append(totalSum%10);
        sumListsRec(head1.next, head2.next, carry, finalSum);
        return Integer.parseInt(finalSum.reverse().toString());

    }
    private static int getSumOfSingleList(SLLNode head){
        int sum = 0;
        SLLNode node = head;
        while(node!=null){
            sum = sum + node.data;
            node = node.next;
        }
        return sum;
    }

    //Approach 2
    // 617  = 7->1->6       length 3        can add zero at head to make it equal length.
    // 1912 = 2->1->9->1    length 4
    // 2529
    //first add, then recurse.
    private static SLLNode sumListsWorking(SLLNode head1, SLLNode head2, int carry){
        if(head1==null && head2==null && carry==0) return null;                         //Base condition when we dont have anything to add

        int value = (head1!=null ? head1.data : 0) + (head2!=null? head2.data : 0) + carry; // add head 1,2 values  + carry

        SLLNode resultHead = new SLLNode();                                             //store addition result in new node.
        resultHead.data = value %10;        //value can be two digit, %10 to get unit digit.

        if(head1!=null || head2 !=null){                                                //check null
            SLLNode nextNode =
                    sumListsWorking(head1==null ? null : head1.next,
                            head2==null ? null: head2.next,
                            value>10? 1:0);  //
            resultHead.next = nextNode;                                                 //pass their next values and carry | check equation.
        }
        return resultHead;                 //return head        we always return head.
    }

    public static void main(String[] args) {
    }

    //If number are in same order
    //1234 = 1->2->3->4
    //+567 = 0->5->6->7     (will have to append zeros
    // res = 1->8->0->1
    //first recurse then add.
    private static SLLNode sumListSameOrder(SLLNode head1, SLLNode head2){
        int l1 = length(head1);
        int l2= length(head2);
        if(l1<l2) head1 = padZeros(head1, l2-l1);
        else head2 = padZeros(head2, l1-l2);

        SumWrapper sum = addListsRec(head1, head2);

        if(sum.carry==0){                               //no carry return the result head node
            return sum.currentSumNode;
        }else {
            SLLNode carryNode = new SLLNode(sum.carry); //carry is there then return carry node by appending it at front of sumWrapper.node.
            if(sum.currentSumNode!=null) carryNode.next = sum.currentSumNode;
            return carryNode;
        }
    }
    static class SumWrapper{                //b/c we wanted to store sum and carry also hence encapsulate both in a class.
        public SLLNode currentSumNode = null;
        public int carry = 0;
    }
    private static SumWrapper addListsRec(SLLNode head1, SLLNode head2){
        //go till top of stack when both last node next are found null then create SumWrapper Object and return it doing anything.
        if(head1==null && head2 ==null){        //b/c both are of same size now.
            return new SumWrapper();
        }
        //go till end | top of stack.
        SumWrapper sumWrapper =  addListsRec(head1.next, head2.next);

        //now add unit place numbers and carry if any.
        int currentSum = head1.data + head2.data + sumWrapper.carry;

        SLLNode currentNewhead = new SLLNode(currentSum);
        if(sumWrapper.currentSumNode !=null)
            currentNewhead.next = sumWrapper.currentSumNode;

        sumWrapper.currentSumNode = currentNewhead;             //we are returning sumWrapper so store 1.currentSum and 2. carry to it. and return.
        sumWrapper.carry = currentSum/10;
        return sumWrapper;

    }
    private static int length(SLLNode head){
        if(head ==null) return 0;
        SLLNode node = head;
        int legnth = 0;
        while(node!=null){
            legnth++;
            node = node.next;
        }
        return legnth;
    }
    private static SLLNode padZeros(SLLNode head, int zeroCount){
        SLLNode newHead = head;
        for (int i = 1; i <= zeroCount; i++) {
            newHead = appendAtFront(newHead, 0);
        }
        return newHead;
    }
    private static SLLNode appendAtFront(SLLNode head, int value){
        SLLNode newHead = new SLLNode(value);
        if(head!=null) newHead.next = head;
        return newHead;
    }
}
