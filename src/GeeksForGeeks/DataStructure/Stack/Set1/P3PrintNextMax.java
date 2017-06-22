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
        int[] input = {8,11,6,9,5};
        check(input);
    }

    private static void check(int[] input){
        int current = 0, index=0;
        boolean noNextMax = false;
        int[] result = new int[input.length+1];
        while(!noNextMax && current < input.length-1){        //8      11 6 9
            int next = current+1;
            while(!noNextMax && next<input.length){   //11  6
                if(input[current]<input[next]){                               //True
                    System.out.println(input[current]);                        //8
                    result[index++]= input[current];
                    current=next;                                       //current=1
                    //System.out.println("Debug1");
                    break;
                }
                if(next == input.length-2){//9true
                    noNextMax = true;
                }
                next++;                  //9
            }
            //System.out.println("Debug2");
            //current++;
        }
        System.out.println("Left to Right");

        int last = input.length-1;
        boolean noPrevMax = false;
        while(!noPrevMax && last >= 0){
            int prev = last-1;
            while(!noPrevMax && prev >= 0){
                if(input[last]<input[prev]){
                    System.out.println(input[last]);
                    result[index++]= input[last];
                    last=prev;    //
                    break;
                }
                if(prev==1){
                    noPrevMax = true;
                }
                prev--;
            }
            //last--; BUG
        }

    }
}
