package OTT.P6_HackerRank.Implementation.Easy;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/circular-array-rotation/problem
 */
public class P16_CircularArrayRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sizeOfarray = scanner.nextInt();
        int rotationCount = scanner.nextInt();
        int numberOfQueries = scanner.nextInt();
        int [] array = new int[sizeOfarray];
        for (int i = 0; i < sizeOfarray; i++) {
            array[i] = scanner.nextInt();
        }
        int [] queries = new int[numberOfQueries];
        for (int i = 0; i < numberOfQueries; i++) {
            System.out.println();
        }
       // circularArrayRotation(array, rotationCount, queries);

    }
    static int[] circularArrayRotation(int[] a, int rotationCount, int[] queries) {
        int [] answer =  new int[queries.length];

        if(rotationCount==0){
            //circularArrayRotationUtil(queries,a,)
        }
        if(rotationCount<a.length){

        }else if(rotationCount== a.length){

        }else {

        }


        return answer;
    }

}
