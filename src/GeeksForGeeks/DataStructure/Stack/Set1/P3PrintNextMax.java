package GeeksForGeeks.DataStructure.Stack.Set1;

import java.util.Stack;

/**
 * Created by Nikhil on 2/23/2017 10:59 PM.
 */
public class P3PrintNextMax {
    private static void printNextMax(int[] array) {
        for (int row = 0; row < array.length; ++row) {
            boolean isGreaterPresent = false;
            for (int col = row + 1; col < array.length; ++col) {
                if (array[row] < array[col]) {
                    System.out.println(array[row] + " - " + array[col]);
                    isGreaterPresent = true;
                    break;
                }
            }
            if (!isGreaterPresent) {
                System.out.println(array[row] + " - " + -1);
            }
        }
    }

    //not working!
    private static void printNextMaxUsingStack(int[] array) {
        Stack<Integer> stack = new Stack<>();
        stack.push(array[0]);

        for (int i = 1; i < array.length; ++i) {
            int current = array[i];
            if (!stack.isEmpty()) {
                int element = stack.pop();
                while (element > current) {
                    System.out.println(element + " " + current);
                    if (stack.isEmpty()) break;
                    element = stack.pop();
                }
                if (element < current) {
                    stack.push(element);
                }
            }
        }

    }

    public static void main(String[] args) {
        int[] array = new int[4];
        array[0] = 4;
        array[1] = 5;
        array[2] = 2;
        array[3] = 25;
        printNextMax(array);

        System.out.println("Second way");
        printNextMaxUsingStack(array);
    }
}
