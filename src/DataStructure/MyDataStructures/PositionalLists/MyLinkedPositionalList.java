package DataStructure.MyDataStructures.PositionalLists;

/**
 * Created by Nikhi on 12/15/2016 1:39 PM.
 */
public class MyLinkedPositionalList<E> implements PositionalList<E> {

    // instance variables of the LinkedPositionalList
    private Node<E> head;
    private Node<E> tail;
    private int size = 0;

    MyLinkedPositionalList(){
        head = new Node<E>(null, null, null);
        tail = new Node<E>(null, head, null);           // trailer is preceded by header
        head.setNext(tail);                                  // header is followed by trailer
    }

    private static class Node<E> implements Position<E>{
        private E element;
        private Node<E> prev;
        private Node<E> next;

        public Node(E e, Node<E> p, Node<E> n){
            element = e;
            prev = p;
            next = n;
        }

        @Override
        public E getElement() throws IllegalStateException {
            if(next == null) throw new IllegalStateException("Position No Longer Valid");
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }

    // private utilities

    /**
     * Validates the position and returns it as a node.
     */
    private Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if (!(p instanceof Node)) throw new IllegalArgumentException("Invalid p");
        Node<E> node = (Node<E>) p; // safe cast
        if (node.getNext() == null) // convention for defunct node
            throw new IllegalArgumentException("p is no longer in the list");
        return node;

    }

    /**
     * Returns the given node as a Position (or null, if it is a sentinel).
     */
    private Position<E> position(Node<E> node) {
        if (node == head || node == tail)
            return null; // do not expose user to the sentinels
        return node;

    }
    // public accessor methods

    public int size() {
        return size;
    }

    /**
     * Tests whether the linked list is empty.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the first Position in the linked list (or null, if empty).
     */
    public Position<E> first() {
        return position(head.getNext());

    }

    /**
     * Returns the last Position in the linked list (or null, if empty).
     */
    public Position<E> last() {
        return position(tail.getPrev());

    }

    /**
     * Returns the Position immediately before Position p (or null, if p is first).
     */
    public Position<E> before(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return position(node.getPrev());

    }

    /**
     * Returns the Position immediately after Position p (or null, if p is last).
     */
    public Position<E> after(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return position(node.getNext());

    }

    @Override
    public Position<E> addFirst(E e) {
        return null;
    }

    @Override
    public Position<E> addLast(E e) {
        return null;
    }

    @Override
    public Position<E> addBefore(E e, Position<E> p) throws IllegalArgumentException {
        return null;
    }

    @Override
    public Position<E> addAfter(E e, Position<E> p) throws IllegalArgumentException {
        return null;
    }

    @Override
    public E set(E e, Position<E> p) throws IllegalArgumentException {
        return null;
    }

    @Override
    public E remove(Position<E> p) throws IllegalArgumentException {
        return null;
    }
}
