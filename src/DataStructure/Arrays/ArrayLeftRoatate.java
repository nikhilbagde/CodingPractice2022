package DataStructure.Arrays;

import java.util.Scanner;

/**
 * Created by Nikhil on 8/17/2016.
 */
public class ArrayLeftRoatate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int rotation = sc.nextInt();
        int[] array = new int[size];
        for(int i = 0; i<size ; i++){
            array[i] = sc.nextInt();
        }

        for(int i=0; i<rotation; i++){
            int temp = array[0];
            for(int j=0; j<size-1;j++){
                array[j] = array[j+1];
            }
            array[size-1] = temp;
        }

        for(int i=0; i<size; i++){
            System.out.print(array[i] + " ");
        }
    }
}
