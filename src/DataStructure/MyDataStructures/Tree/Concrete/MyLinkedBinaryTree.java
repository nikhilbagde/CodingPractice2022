package DataStructure.MyDataStructures.Tree.Concrete;

import DataStructure.MyDataStructures.PositionalLists.Position;

/**
 * Created by Nikhi on 12/16/2016 9:34 AM.
 */
public class MyLinkedBinaryTree<E> extends MyAbstractBinaryTree<E> {
    //Instance variables
    protected Node<E> root = null;
    private int size = 0;

    public MyLinkedBinaryTree(){}

    //static inner class for SLLNode
    protected static class Node<E> implements Position<E>{
        private E element;

        private Node<E> parent;
        private Node<E> left;
        private Node<E> right;

        public Node(E element, Node<E> parent, Node<E> left, Node<E> right) {
            this.element = element;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        //accesser methods
        public Node<E> getParent(){return parent;}
        public Node<E> getLeft(){return left;}
        public Node<E> getRight(){return right;}
        @Override
        public E getElement() throws IllegalStateException {
            return null;
        }

        //update methods

        public void setElement(E element) {
            this.element = element;
        }

        public void setParent(Node<E> parent) {
            this.parent = parent;
        }

        public void setLeft(Node<E> left) {
            this.left = left;
        }

        public void setRight(Node<E> right) {
            this.right = right;
        }

        //Factory Method to create a new node
        protected Node<E> createNode(E e, Node<E> parent,Node<E> left,Node<E> right){
            return new Node<E>(e, parent,left,right);
        }



    }
}
