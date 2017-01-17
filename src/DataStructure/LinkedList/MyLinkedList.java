package DataStructure.LinkedList;
import java.util.Hashtable;

/**
 * Created by Nikhil on 8/14/2016.
 */
public class MyLinkedList extends java.util.LinkedList {
    public SLLNode head;

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.add(1);         list.add(2);         list.add(3);         list.add(4);         list.add(5);
        list.add(6);         list.add(7);

        MyLinkedList list2 = new MyLinkedList();
        list2.add(1);         list2.add(2);        list2.add(3);         list2.add(4);         list2.add(5);
        list2.add(6);         list2.add(7);

        System.out.println("Before Swap node");
        list.printList();

        list.swapNodes(3,4);

        System.out.println("After Swap node");
        list.printList();

        System.out.println("Before Reverse");
        list.printList();

        list.reverse(list);

        System.out.println("After Reverse");
        list.printList();


        System.out.println("Merging Two Lists");
        MyLinkedList mergedList = new MyLinkedList();
        mergedList.head = list.mergeLists(list.head, list2.head);
        mergedList.printList();

        MyLinkedList list3 = new MyLinkedList();
        list3.add(1);         list3.add(2);         list3.add(3);         list3.add(4);         list3.add(5);         list3.add(6);
        list3.add(6);
        System.out.println("Testing MyLinkedList for Cycle");

        if(list3.hasCycle(list3.head)){
            System.out.println("No Cycle");
        }else{
            System.out.println("Cycle Exist");
        }


        /*Two linked list with merged node, find that node */
        MyLinkedList list4 = new MyLinkedList();
        list4.add(1); list4.add(2); list4.add(3); list4.add(4);
        MyLinkedList list5 = new MyLinkedList();
        list5.add(1); list5.head.next = list4.head.next.next;

        System.out.println("Finding Merge SLLNode");
        int data = findMergeNode(list4.head, list5.head);
        System.out.println("Merged SLLNode is " + data);

    }
    public static int findMergeNode(SLLNode headA, SLLNode headB) {
        SLLNode tempA = headA;
        SLLNode tempB = headB;
        int counterA = 0;
        while(tempA!=null){
            counterA++;
            tempA = tempA.next;
        }
        int counterB = 0;
        while(tempB!=null){
            counterB++;
            tempB = tempB.next;
        }

        if(counterA < counterB){
            tempA = headB;
            tempB = headA;
        }

        tempA = headA;
        tempB = headB;
        SLLNode resetBackToHead = tempA;

        while(tempB!= null){
            tempA = resetBackToHead;
            while(tempA!=null){
                if(tempA == tempB){
                    return tempA.data;
                }
                tempA = tempA.next;
            }

            tempB = tempB.next;
        }
        return tempA.data;
    }

    public boolean hasCycle(SLLNode head){
        SLLNode temp = head;
        Hashtable<SLLNode, Integer> linkedList = new Hashtable<>();
        while(temp!=null){
            //linkedList.put(temp, temp.hashCode());
            if(!linkedList.containsKey(temp)) {
                linkedList.put(temp, temp.hashCode());
                temp = temp.next;
            }else{
                return false;
            }
        }
        return true;
    }
    public SLLNode mergeLists(SLLNode headA, SLLNode headB){

        if(headA == null){
            return headB;
        }else if(headB== null){
            return headA;
        }

        SLLNode temp;
        if(headA.data <= headB.data){
            temp = headA;
            temp.next = mergeLists(headA.next, headB);
        }else{
            temp = headB;
            temp.next = mergeLists(headA, headB.next);
        }
        return temp;
    }
    public void reverse(MyLinkedList list){

        if(list.head == null){
            return;
        }else {
            SLLNode current = list.head;
            SLLNode previous = null;
            while(current!=null){
                //1. Store next pointer
                SLLNode next = current.next;
                //2. Change next to previous
                current.next = previous;
                //3. move current to previous for all nodes
                previous = current;
                //4. move forward, (incrementer)
                current = next;
            }
            //5. At last we need to put head node to last node
            head = previous;
        }
    }
    public void swapNodes( int x, int y){
        if(x == y)
            return;

        /*
        Search for x and keep track of prev and current node.
         */
        SLLNode prevX = null, currX = head;
        while (currX!= null && currX.data!=x){
            prevX = currX;
            currX = currX.next;
        }
        /*
        Search for y and keep track of prev and current node.
         */

        SLLNode prevY = null, currY = head;
        while (currY!= null && currY.data!=y){
            prevY = currY;
            currY = currY.next;
        }

        if(currX==null  || currY== null){
            return ;
        }

        /*
        If either of node currX or CurrY is HEAD
        Otherwise, Take previous node of both nodes, and put each node to previous of Other node.
        Indirectly we are swapping previous node of both target nodes
        */
        if(prevX == null){
            head = currY;
        }else{
            prevX.next = currY;
        }

        if(prevY == null){
            head = currX;
        }else{
            prevY.next = currX;
        }

        /*
        Swap next pointers of both X and Y node
        */

        SLLNode temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;
    }
    public void add(int data){
        if(head== null){
            SLLNode node = new SLLNode(data);
            head = node;
        }else{
            SLLNode node = new SLLNode(data);
            SLLNode temp = head;

            while(temp.next!=null){
                temp = temp.next;
            }
            temp.next = node;
        }
    }
    public void printList(){
        SLLNode node = head;
        while(node!=null){
            System.out.print(node.data + "->");
            node = node.next;
        }
        System.out.println("NULL");
    }


}
