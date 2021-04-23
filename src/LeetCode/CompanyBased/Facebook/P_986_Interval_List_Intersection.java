package LeetCode.CompanyBased.Facebook;

public class P_986_Interval_List_Intersection {
    public static void main(String[] args) {

        int[][] A = {{0,2},{5,10},{13,23},{24,25}};
        int[][] B = {{1,5},{8,12},{15,24},{25,26}};
        int[][] result = intervalIntersection(A,B);
    }

    public static int[][] intervalIntersection(int[][] A, int[][] B) {
       int i=0, j=0;

       //creating list because we need to return List in int[][] we make it we need fixed size which we dont have.
        // Hence intermediate solution to create a list and then make it as 2d Array.
       java.util.List<int[]> List = new java.util.ArrayList<>();

       while(i< A.length && j< B.length){
           int[] first = A[i];
           int[] second = B[j];

           int lowerMax = Math.max(first[0], second[0]);
           int upperMin = Math.min(first[1], second[1]);

           //IMPORTANT: check if lower is smaller than upper then only add it to the intersection.
           if(lowerMax<= upperMin){
               int [] intersection = {lowerMax, upperMin};
               List.add(intersection);
           }

           int max1 = first[1], max2 = second[1];
           if(max1<max2){
               i++;
           }else {
               j++;
           }
       }
        int[][] result = new int[List.size()][2];
        for (int k = 0; k < List.size(); k++) {
            int [] temp = List.get(k);
            result[k][0] = temp[0];
            result[k][1] = temp[1];
        }

        return result;
    }
}
