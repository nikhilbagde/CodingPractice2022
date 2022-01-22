package WarmUp.List;


/**
 * Defining a class with E type as generic.
 * This E could be of any literal type.
 * @param <E>
 */
public class CircularSinglyLinkedList<E>{

    // Add private inner class
    private static class Node<E> {
        private E element;
        private Node<E> next;

        //Constructor
        public Node(E element){
            this.element = element;
            this.next= null;
        }
        public Node(E element, Node<E> next){
            this.element = element;
            this.next = next;
        }

        //Accessors
        public E getElement(){ return element;}
        public Node<E> getNext() { return next;}

        public void setNext(Node<E> next){
            this.next = next;
        }
        public void setElement(E element){
            this.element = element;
        }
    }

    //Singly Linked list starts here
    private Node<E> tail = null;
    private int size = 0;

    CircularSinglyLinkedList() {
        //default constructor
    }

    //GET methods : getSize(), isEmpty(), first(), last()
    public int getSize(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    // get the value of first Node not reference to actual node.
    public E first(){
        if(isEmpty()) return null;
        return tail.getNext().getElement();
    }
    // get the value of last Node not reference to actual node.
    public E last(){
        if(isEmpty()) return null;
        return tail.getElement();
    }


    //POST methods: addFirst(), addLast(), removeFirst()
    public void addFirst(E element){
        Node newNode = new Node(element);
        if(size==0){
            tail = newNode;
            tail = tail.next;
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
        }
    }

    public void addLast(E element){
        addFirst(element);
        tail = tail.next;
    }

    public E removeFirst(){
      if(isEmpty()) return null;
      Node<E> head = tail.getNext();        //important to create node with <E> or return getElement wont work and expect Object.
      if(head!=tail){
        tail = null;
      } else {
          tail.next = tail.getNext().getNext();
          // or tail.next = head.getNext();
      }
      size--;
      return head.getElement();
    }

    /*public E removeLast(){
        if(isEmpty()) return null;
        if(getSize()==1) {
            Node<E> Onlynode = tail;
            tail = null;
            return Onlynode.getElement();
        } else {
            Node<E> lastNode = tail;
            tail = tail.next;
        }

        size--;
    }*/

}

/**
 * 1. create a class of generic E
 * 2. create a inner private class of Node of generic E
 * 3. define constructor
 * 4. getter of E
 * 5. getter of next
 * 6. setter for next
 */
