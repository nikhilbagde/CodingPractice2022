package Books.ElementsOfProgrammingInterview.DataStructure.Ch_18_GreedyAlgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P1_OptimalAssignment {

    public static void main(String[] args) {
        int [] task = { 5 , 2 , 4, 6 , 1 , 4};
        List<int[]> optimal = findOptimalAssignment(task);
        //System.out.println("optimal = " + optimal);
        //optimal.forEach(a -> Arrays.stream(a).forEach(aa -> {System.out.print(aa + ",");}));
        optimal.forEach(a -> {System.out.println(Arrays.toString(a));});

        /*for( int[] a :  optimal){
            Arrays.toString(a);
        }*/
    }

    public static List<int[]> findOptimalAssignment(int [] task){
        Arrays.sort(task);          // n log n
        List<int[]> optimalList = new ArrayList<>();
        for( int i = 0, j = task.length-1; i< j; i++, j--){
            int [] pair = {task[i], task[j]};
            optimalList.add(pair);
        }
        return optimalList;
    }

}
