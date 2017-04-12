package CompanyCompetetions.Amazon.Interview1;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Nikhil on 4/6/2017 6:08 PM.
 */
public class FindMostFrequentString {
    public static void main(String[] args) {
        String[] a = {"Nikhil", "Vandana", "Bagde", "Vijay", "Nikhil", "Vandana", "Vandana"};
        System.out.println(getMostFrequentString(a));
    }

    private static String getMostFrequentString(String[] a) {
        java.util.Map<String, Integer> map = new TreeMap<>();
        for (String str : a) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        System.out.println(map);
        Map<String, Integer> sorted = new LinkedHashMap<>();
        map.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEachOrdered(x -> sorted.put(x.getKey(), x.getValue()));

        System.out.println(sorted);

        //get first element of map
        String result = sorted.entrySet().iterator().next().getKey();
        return result;
    }

}
