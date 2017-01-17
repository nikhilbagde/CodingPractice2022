package Algorithm.DynamicProgramming.OptimalSubStructure.BottomUp;

import java.util.*;

/**
 * Created by Nikhil on 12/28/2016 1:51 PM.
 */
public class FloydAllPairShortestPath {
    private static Scanner scanner = new Scanner(System.in);
    private static int[][] distance;
    private static int[][] path;
    public static void main(String[] args) {
        inputWeights(welcomeMessage());
        removeCycles();
        floydAlgorithm();
        printShortestPathSpecific();
        printAllPairShortestPath();
    }
    private static int welcomeMessage(){
        System.out.println("All Pair Shortest Path: Floyd Algorithm");
        System.out.println("Enter total Number of Vertex");
        return scanner.nextInt();
    }
    private static void inputWeights(int totalVertex){
        System.out.println("Enter Distances between vertices, row to col | (No edge put 999)");
        distance = new int[totalVertex+1][totalVertex+1];
        for (int row = 1; row <= totalVertex; row++){
            for (int col = 1; col <= totalVertex; col++) {
                if(row!= col) {
                    System.out.println("Distance between vertex " + row + " to vertex " + col );
                    int weight = scanner.nextInt();
                    //distance[row][col] = weight <0 ? 0 : (weight == 999 ? Integer.MAX_VALUE : weight);
                    distance[row][col] = weight <0 ? 0 : weight; //O for negative edges.
                } else {
                    distance[row][col] = 0;
                }
            }
        }
        printMatrix("Given Matrix", distance);
    }
    private static void removeCycles(){
        for (int row = 1; row < distance.length; row++) {
            for (int col = row; col < distance.length; col++) {
                if(col!=row && (distance[row][col]!= 999 && distance[col][row]!= 999)){
                    //means cycle found keep minimum one and replace other with int max.
                    //Indicating no edge.
                    if(distance[row][col] < distance[col][row]){
                        distance[col][row] = 999;
                    }else{
                        distance[row][col] = 999;
                    }
                }
            }
        }
        printMatrix("After Removing Cycles",distance);
    }

    private static void printMatrix(String name, int [][] Matrix) {
        System.out.println("\nPrinting, " + name + ":");
        System.out.print("\n\t");
        for (int label = 1; label < Matrix.length; label++) {
            System.out.print(label + "\t\t");
        }
        System.out.println();
        for (int dash = 0; dash < 45; dash++) {
            System.out.print("-");
        }
        System.out.println();
        for (int row = 1; row < Matrix.length; row++) {
            System.out.print(row + " |\t");
            for (int col = 1; col < Matrix.length; col++) {
                //System.out.print(Matrix[row][col] > Integer.MAX_VALUE-1000 ? 999 : (Matrix[row][col])== 0 ? "-" : Matrix[row][col] );
                System.out.print((Matrix[row][col])== 0 ? "-" : Matrix[row][col]);
                System.out.print("\t\t");
            }
            System.out.println();
        }
        System.out.println("\n");
    }
    private static void floydAlgorithm(){
        path = new int[distance.length][distance.length];
        for (int mid = 1; mid < distance.length; mid++) {
            for (int start = 1; start < distance.length; start++) {
                for (int end = 1; end < distance.length; end++) {
                    if(start!= end && distance[start][mid] + distance[mid][end] < distance[start][end]){
                        distance[start][end] = distance[start][mid] + distance[mid][end];
                        path[start][end] = mid;
                    }
                }
            }
            //printMatrix("After Floyd Algorithm\n Distances of All Pairs", distance);
        }
        printMatrix("After Floyd Algorithm\n Distances of All Pairs", distance);
        printMatrix("After Floyd Algorithm\n Shortest Paths", path);
    }
    private static void printShortestPathSpecific(){
        System.out.println("Find Shortest Path");
        System.out.println("Enter Starting Vertex");
        int start = scanner.nextInt();
        System.out.println("Enter Ending Vertex");
        int end = scanner.nextInt();
        if(start >= distance.length || end >= distance.length) {
            System.out.println("Wrong Vertex Entered ");
            //throw new IllegalArgumentException("\"Wrong Vertex Entered \"");
            return;
        }
        System.out.print("Path = " + start + "->");
        printShortestPathRec(start,end);
        System.out.println(end);
        System.out.println("Weight = " + distance[start][end]);

    }
    private static void printShortestPathRec(int start, int end){
        if(path[start][end]!=0){                //2->1      2->5->1
            printShortestPathRec(start, path[start] [end]);    //2, path[2][5] (4)
            System.out.print(path[start][end]+"->");
            printShortestPathRec(path[start][end], end);
        }
        //return 0;
    }
    private static void printAllPairShortestPath(){
        System.out.println("\n\tAll Pair Shortest Paths");
        for (int start = 1; start < path.length; start++) {
            for (int end = 1; end < path.length; end++) {
                if(start==end) continue;
                System.out.print("Path ("+start+" to "+end+") = " + start + "->");
                printShortestPathRec(start, end);
                System.out.println(end);
                System.out.println("Weight = " + (distance[start][end] == 999 ? "No Edge" : distance[start][end]) );
            }
            System.out.println();
        }
    }

}
/*
Input:
Vertices =  5
1 999 1 5 9 3 2 999 999 999 4 999 999 999 2 3 3 999 999 999

Algorithm takes O(n) = n^3 (FIXED)

0   1   999 1   5
9   0   3   2   999
999 999 0   4   999
999 999 2   0   3
3   999 999 999 0
 */