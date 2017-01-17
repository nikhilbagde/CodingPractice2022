package DataStructure.Heaps;

import javax.swing.text.html.HTMLDocument;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by Nikhi on 12/8/2016 4:57 AM.
 */
public class MinIntHeap {
    private int capacity = 10;
    private int size = 0;

    int[] items = new int[capacity];

    private void ensureCapacity(){
        if(size == capacity){
            items = Arrays.copyOf(items, capacity*2);
            capacity *= 2;
        }
    }
    private void swap(int indexOne, int indexTwo){
        int temp = items[indexOne];
        items[indexOne] = items[indexTwo];
        items[indexTwo] = temp;
    }
    public int peek(){
        if(size ==0) throw new IllegalArgumentException();
        return items[0];
    }

    public int poll(){
        if(size == 0) throw new IllegalArgumentException();
        int root = items[0];
        items[0] = items[size-1];
        size--;
        heapifyDown();
        return root;
    }
    private void heapifyDown(){
        int index = 0;
        //check left child is smaller than current index
        //if yes then check with right child
        while(hasLeftChild(index)){         //index*2+1 < size Once we reach last node we don't have to check for any further. Hence condition < size()
            //at one level down -> get Left child and Right Child and see which is smaller
            //which is smaller left or right ?
            int smallerChildIndex = getLeftChildIndex(index);

            //if right exists and its less than left
            if(hasRightChild(index) && rightChild(index) < leftChild(index)){
                smallerChildIndex = getRightChildIndex(index);
            }
            //compare current with smallest from left or right then swap index
            if(items[index] > items[smallerChildIndex]){
                swap(index, smallerChildIndex);
            } else {
                break;
            }
            //update index for while loop. MOVE DOWN. L or R
            index = smallerChildIndex;
        }

    }
    public void add(int item){
        ensureCapacity();
        items[size] = item;
        size++;
        heapifyUp();
    }
    private void heapifyUp(){
        //get Last element
        // As long as there is a parent item present && parent is greater than me.
        //get its parent element and check of its smaller than parent
        //if yes then swap.
        int index = size - 1;
        while(hasParent(index) && parent(index) > items[index]){
            swap(getParentIndex(index), index);
            //update index
            index = getParentIndex(index);
        }

    }
    private int getLeftChildIndex(int parentIndex){ return 2*parentIndex+1;}
    private int getRightChildIndex(int parentIndex){ return 2*parentIndex+2;}
    private int getParentIndex(int childIndex){ return (childIndex-1)/2;}

    private boolean hasLeftChild(int index){return getLeftChildIndex(index)< size;}
    private boolean hasRightChild(int index){return getRightChildIndex(index)< size;}
    private boolean hasParent(int index){return getParentIndex(index)>= 0;}

    private int leftChild(int index){ return items[getLeftChildIndex(index)];}
    private int rightChild(int index){ return items[getRightChildIndex(index)];}
    private int parent(int index){ return items[getParentIndex(index)];}

}
