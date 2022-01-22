package WarmUp.List;


/**
 * Defining a class with E type as generic.
 * This E could be of any literal type.
 * @param <E>
 */
public class SinglyLinkedList <E>{

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
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    SinglyLinkedList() {
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
        return head.getElement();
    }
    // get the value of last Node not reference to actual node.
    public E last(){
        if(isEmpty()) return null;
        return tail.getElement();
    }


    //POST methods: addFirst(), addLast(), removeFirst(), removeLast()
    public void addFirst(E element){
        Node temp = new Node(element);
        temp.next = head;
        head = temp;
        if(size==0){
            tail = head;
        }
        size++;
    }

    public void addLast(E element){
        Node temp = new Node(element);
        if(isEmpty()){
            head = temp;
        }
        tail.next = temp;
        tail = temp;
        size++;
    }

    public E removeFirst(){
        if(isEmpty()) return null;
        E element = head.getElement();

        head = head.next;

        if(size == 0){
            tail = null;
        }
        return element;
    }

    //can't complete this, as after removing we don't have prev pointer to move tail!
    public E removeLast(){
        E element = null;
        if(size!=0)
            element = tail.getElement();
        return element;
    }

}

/**
 * 1. create a class of generic E
 * 2. create a inner private class of Node of generic E
 * 3. define constructor
 * 4. getter of E
 * 5. getter of next
 * 6. setter for next
 */
