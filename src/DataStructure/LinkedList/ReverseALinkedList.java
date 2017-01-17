package DataStructure.LinkedList;


/**
 * Created by Nikhil on 1/13/2017 12:19 PM.
 */
public class ReverseALinkedList {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.add(1);         list.add(2);         list.add(3);         list.add(4);         list.add(5);
        list.add(6);         list.add(7);
        reverse(list);
    }
    private static void reverse(MyLinkedList linkedList){
        if(linkedList.head == null){
            return;
        }else{
            SLLNode current = linkedList.head;
            SLLNode prev = null;
            while(current!=null){
                SLLNode next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
            linkedList.head = prev;

        }

    }

}
