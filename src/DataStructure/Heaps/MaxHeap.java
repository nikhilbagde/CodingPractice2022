package DataStructure.Heaps;

/**
 * Created by Nikhi on 12/8/2016 7:16 PM.
 */
public class MaxHeap {
    private int capacity = 10;
    private int size = 0;
    private int[] items = new int[capacity];

    private  void ensureCapacity(){
        if(size == capacity){
            items = java.util.Arrays.copyOf(items, capacity*2);
            capacity = capacity *2;
        }
    }
    /*private int getLeftChildIndex(int index){return index*2+1};
    private int getRightChildIndex(int index){return index*2+2};
    private int getParentIndex(int index){return (index-1)/2};
    */
    public int poll(){
        if(size==0) throw new IllegalArgumentException();
        int item = items[0];
        items[0] = items[size-1];
        size--;
        heapifyDown();
        return item;
    }
    public void offer(int item){
        add(item);
    }
    public void add(int item){
        ensureCapacity();
        items[size] = item;
        size++;
        heapifyUp();
    }
    private void heapifyUp(){
        int index = size -1;
        if(hasParent(index) && parent(index) < items[index]){
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }
    private void swap(int indexOne, int indexTwo){
        int temp = items[indexOne];
        items[indexOne] = items[indexTwo];
        items[indexTwo] = temp;
    }
    private void heapifyDown(){
        int index = 0;
        //check left child is smaller than current index
        //if yes then check with right child
        while(hasLeftChild(index)){         //index*2+1 < size Once we reach last node we don't have to check for any further. Hence condition < size()
            //at one level down -> get Left child and Right Child and see which is smaller
            //which is smaller left or right ?
            int greaterChildIndex = getLeftChildIndex(index);

            //if right exists and its larger than left
            if(hasRightChild(index) && rightChild(index) > leftChild(index)){
                greaterChildIndex = getRightChildIndex(index);
            }
            //compare current with largest from left or right then swap index
            if(items[index] < items[greaterChildIndex]){
                swap(index, greaterChildIndex);
            } else {
                break;
            }
            //update index for while loop. MOVE DOWN. L or R
            index = greaterChildIndex;
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
