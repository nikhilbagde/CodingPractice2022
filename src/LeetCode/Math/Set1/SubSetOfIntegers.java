package LeetCode.Math.Set1;

import GeeksForGeeks.JavaReview.ConstructorChaining.A;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Nikhil on 1/21/2017 3:52 PM.
 */
public class SubSetOfIntegers {
    /*
    1. Given a set S of n distinct integers,
    2. there is a relation between Sn and Sn-1.
    3. The subset of Sn-1 is the union of {subset of Sn-1}
    4. and {each element in Sn-1 + one more element}.
    5. Therefore, a Java solution can be quickly formalized.
     */
    private static ArrayList<ArrayList<Integer>> getSubSet(int[] input) {
        if (input == null) return null;
        Arrays.sort(input);                     //it should be sorted.
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for (int element = 0; element < input.length; element++) {
            ArrayList<ArrayList<Integer>> current = new ArrayList<>();

            //get all set which are already present
            for (ArrayList<Integer> list : result) {
                current.add(new ArrayList<>(list));     //create a new arrayList with all those list of element
            }
            //add current ith element to all currently existing list
            for (ArrayList<Integer> lists : current) {
                lists.add(input[element]);
            }
            //add input[element] only as A single set
            ArrayList<Integer> singleSet = new ArrayList<>();
            singleSet.add(input[element]);
            current.add(singleSet);
            result.addAll(current);
        }
        return result;
    }

    private static ArrayList<ArrayList<Integer>> getSubSet2(int[] S) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        Arrays.sort(S);
        for(int i = 0; i < S.length; i++) {
            int curSize = ans.size();
            for (int j = 0; j < curSize; j++) {
                ArrayList<Integer> cur = new ArrayList<>(ans.get(j));
                cur.add(S[i]);
                ans.add(cur);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> result = getSubSet(new int[]{10, 20, 30});
        for (ArrayList<Integer> list : result) {
            System.out.println(list);
        }
        System.out.println("2nd Method");
        ArrayList<ArrayList<Integer>> result1 = getSubSet2(new int[]{10, 20, 30});
        for (ArrayList<Integer> list : result1) {
            System.out.println(list);
        }
    }
}
