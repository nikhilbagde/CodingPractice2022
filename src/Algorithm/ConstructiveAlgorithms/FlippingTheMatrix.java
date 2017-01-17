package Algorithm.ConstructiveAlgorithms;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.*;

/**
 * Created by Nikhi on 12/13/2016 10:20 AM.
 */
public class FlippingTheMatrix {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();

        for (int test = 0; test < testCases; test++) {
            int n = in.nextInt();
            int [][] matrix = new int[2*n][2*n];
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> {
                if(o1>o2) return 1;
                else if(o1<o2) return -1;
                return 0;
            });

            int [] matrixRow = new int[4*n*n];
            int count = 3, index =0;
            for (int row = 0; row < 2*n; row++) {
                for (int col = 0; col < 2*n; col++) {
                    int value = in.nextInt();
                    matrix[row][col] = value;
                    matrixRow[index++] = value;
                    if(count-- >=0)
                        priorityQueue.add(value);

                    if(value > priorityQueue.peek()){
                        priorityQueue.poll();
                        priorityQueue.add(value);
                    }


                }
            }
            Integer[] reverse = new Integer[matrixRow.length];
            for (int i = 0; i < reverse.length; i++) {
                reverse[i] = matrixRow[i];
            }
            Arrays.sort(reverse, Collections.reverseOrder() );

            for ( Integer A: reverse) {
                System.out.println(A);
            }
            int finalSum = 0;
            while(priorityQueue.size()!=0){
                finalSum+= priorityQueue.poll();
            }
            System.out.println(finalSum);

            sortAllCol(matrix);
        }

    }
    private static void sortAllCol(int[][] matrix){
        Integer[] oneCol = new Integer[matrix.length];
        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                oneCol[col] = matrix[col][row];
            }

        }

    }
}
