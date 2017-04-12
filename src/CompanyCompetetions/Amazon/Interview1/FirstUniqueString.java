package CompanyCompetetions.Amazon.Interview1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Nikhil on 4/6/2017 6:28 PM.
 */
public class FirstUniqueString {
    public static void main(String[] args) {
        String[] a = {"Nikhil", "Vandana", "Bagde", "Vijay", "Nikhil", "Vandana", "Vandana"};
        System.out.println(findFirstQuniueString(a));
    }

    private static String findFirstQuniueString(String[] a) {
        Set<String> set = new HashSet<>();
        List<String> list = new ArrayList<>();

        for (String s : a) {
            if (set.contains(s)) {
                continue;
            }
            if (list.contains(s)) {
                //list.remove(c);
                list.remove(s);
                set.add(s);
            } else {
                list.add(s);
            }
        }
        return list.get(0);
    }
}
