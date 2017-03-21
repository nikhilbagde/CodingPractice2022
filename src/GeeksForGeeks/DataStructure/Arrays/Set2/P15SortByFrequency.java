package GeeksForGeeks.DataStructure.Arrays.Set2;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by Nikhil on 2/27/2017 9:10 PM.
 * {2, 3, 2, 4, 5, 12, 2, 3, 3, 3, 12}, then modify the array to {3, 3, 3, 3, 2, 2, 2, 12, 12, 4, 5}.
 */
public class P15SortByFrequency {
    static SortNode root = null;

    public static void main(String[] args) {

        int[] array = {2, 3, 2, 4, 5, 12, 2, 3, 3, 3, 12};      // expected output {3, 3, 3, 3, 2, 2, 2, 12, 12, 4, 5}.

        for (int value : array) {
            insert(value);
        }
        preOrder(root);

        //way to just create a pro queue and let it sort max count.
        PriorityQueue<SortNode> priorityQueue = new PriorityQueue<>((o1, o2) -> o1.count > o2.count ? -1 : (o1.count < o2.count ? 1 : 0));
        preOrder(root, priorityQueue);
        int[] result = printQueue(priorityQueue, array.length);
        System.out.println("Arrays.toString(result) = " + Arrays.toString(result));

        //doesn't work
        Object[] arrayN = priorityQueue.toArray();
        /*for (SortNode node: (SortNode[]) arrayN) {
            System.out.println("value = " + node.value + " count = " + node.count);
        }*/
        /*System.out.println("Arrays.deepToString(arrayN) = " + Arrays.deepToString(arrayN));*/

    }

    //problem can be solved by sorting (n log n)
    //can be solved in (log n) using BST insertion.
    public static void insert(int value) {
        if (root == null) {
            root = new SortNode(value);
        } else {
            root = insertRec(root, value);
        }
    }

    private static SortNode insertRec(SortNode root, int value) {
        if (value < root.value) {
            if (root.left == null) {
                root.left = new SortNode(value);
            } else {
                root.left = insertRec(root.left, value);
            }
        } else if (value > root.value) {
            if (root.right == null) {
                root.right = new SortNode(value);
            } else {
                root.right = insertRec(root.right, value);
            }
        } else if (root.value == value) {
            root.count++;
        }
        return root;
    }

    public static void preOrder(SortNode root) {
        if (root != null) {
            System.out.println("root.value = " + root.value + " root.count = " + root.count);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public static PriorityQueue<SortNode> preOrder(SortNode root, PriorityQueue<SortNode> priorityQueue) {
        if (root != null) {
            System.out.println("root.value = " + root.value + " root.count = " + root.count);
            priorityQueue.offer(root);
            preOrder(root.left, priorityQueue);
            preOrder(root.right, priorityQueue);
        }
        return priorityQueue;
    }

    public static int[] printQueue(PriorityQueue<SortNode> priorityQueue, int size) {
        System.out.println("Another way\n\n\n");
        int[] array = new int[size];
        int index = 0;
        while (!priorityQueue.isEmpty()) {
            SortNode node = priorityQueue.poll();
            for (int i = 0; i < node.count; ++i) {
                array[index++] = node.value;
            }
            System.out.println("node.value = " + node.value + " count = " + node.count);
        }
        return array;
    }

    static class SortNode {
        int value, count;
        boolean moreThanOne;
        SortNode left, right;

        SortNode(int value) {
            this.value = value;
            this.count = 1;
            this.moreThanOne = false;
            this.left = this.right = null;
        }
    }
}
