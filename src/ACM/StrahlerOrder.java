package ACM;

import java.util.*;

/**
 * Created by Nikhi on 11/7/2016.
 */
public class StrahlerOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dataSet = scanner.nextInt();

        for (int i = 0; i < dataSet; i++) {
            int k_dataSetNum = scanner.nextInt();
            int totalNodes = scanner.nextInt();
            int totalEdge = scanner.nextInt();

            int[][] matrix = new int[totalNodes+1][totalNodes+1];
            for (int j = 1; j < totalNodes; j++) {
                for (int k = 1; k < totalNodes; k++) {
                    matrix[j][k] = 0;
                }
            }
            for (int j = 0; j < totalEdge ; j++) {
                int row = scanner.nextInt();
                int col = scanner.nextInt();
                matrix[row][col] = 1;
            }

            //print matrix
            /*for (int j = 1; j < totalNodes+1; j++) {
                for (int k = 1; k < totalNodes+1; k++) {
                    System.out.print(matrix[j][k]);
                }
                System.out.println();
            }*/
            int[] orderList = new int[totalNodes+1];
            for (int j = 1; j < orderList.length+1; j++) {
                orderList[i] = 0;
            }
            findMaxDegree(matrix, orderList, matrix.length-1);
        }
    }
    public static List<Integer> findParents(int[][] adjacencyMatrix, int nodeIndex){
        List<Integer> parentList = new ArrayList<>();
        for (int row = 1; row <= adjacencyMatrix.length ; row++) {
            if(adjacencyMatrix[row][nodeIndex] == 1 ) parentList.add(row);
        }
        return parentList;
    }
    public static int findMaxDegree(int[][] matrix, int[] orderList, int mouth){
        //if(mouth > 1){
            int degree = 0;
        for (int row = 1; row <= matrix.length+1 ; row++) {
            List<Integer> parentList = findParents(matrix, mouth);
            for (Integer n : parentList) {

            }
        }

        if(mouth < 2){
            return 1;
        }else{
            return Math.max(findMaxDegree(matrix, orderList, mouth-1),  findMaxDegree(matrix, orderList, mouth-2));
        }
            /*for (int row = 1; row <= matrix.length+1 ; row++) {
                if(row == mouth){
                    return 1;
                    //return orderList[mouth] == 0 ? 0 : orderList[mouth] ;
                }
                if(matrix[row][mouth] == 0 ){
                    continue;
                }
                if(matrix[row][mouth] == 1){
                    int newDegree = findmaxDegree(matrix, orderList, row);
                    if(newDegree == orderList[mouth]){                      //if there was already a edge
                        orderList[mouth] = newDegree + 1;                   //
                    }else {
                        orderList[mouth] = newDegree > orderList[mouth] ? newDegree : orderList[mouth];
                    }
                }else{
                    return 1;   //source found in-degree = 1
                }

            }*/
        //}
        //return degree;
    }
}
