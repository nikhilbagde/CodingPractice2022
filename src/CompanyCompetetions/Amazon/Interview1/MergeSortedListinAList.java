package CompanyCompetetions.Amazon.Interview1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Nikhil on 4/6/2017 8:02 PM.
 */
public class MergeSortedListinAList {
    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();
        int[] a = {1, 2, 3, 4, 5, 6, 6, 7, 8, 9, 10};
        int[] b = {11, 12, 13, 14, 15, 16, 17, 18, 19};
        int[] c = {21, 22, 23, 24, 25, 26, 27, 28, 29};
        int[] d = {31, 32, 33, 34, 35, 37, 38, 39};

        //not working!
        List<Integer> list1 = java.util.Arrays.asList(a.length);
        List<Integer> list2 = java.util.Arrays.asList(b.length);
        List<Integer> list3 = java.util.Arrays.asList(c.length);
        List<Integer> list4 = java.util.Arrays.asList(d.length);
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        lists.add(list4);

        List<Integer> result = mergeAllLists(lists);
        System.out.println(result);

    }

    private static List<Integer> mergeAllLists(List<List<Integer>> lists) {
        List<Integer> result = new ArrayList<>();
        for (List<Integer> list : lists) {
            result.addAll(list);
        }
        Collections.sort(result);
        return result;
    }
}
