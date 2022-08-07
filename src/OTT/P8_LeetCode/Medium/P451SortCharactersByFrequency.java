package LeetCode.Medium;

import java.util.*;

/**
 * Created by Nikhil on 4/3/2017 8:55 PM.
 */
public class P451SortCharactersByFrequency {
    public static void main(String[] args) {
        String a = "tree";      //Expected: eetr
        String b = "cccaaa";    //Expected: cccaaa
        String c = "Aabb";      //Expected: bbAa

        frequencySort(c);
    }

    private static String frequencySort(String s) {
        java.util.Map<Character, Integer> map = new java.util.LinkedHashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
        }
        System.out.println(map);

        java.util.Map<Character, Integer> sortedMap = new java.util.LinkedHashMap<>();

        //Sort Map by Value
        map.entrySet().stream()
                .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
                .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));

        System.out.println(sortedMap);

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : sortedMap.entrySet()) {
            int count = entry.getValue();
            while (count-- > 0) {
                System.out.print(entry.getKey());
                sb.append(entry.getKey());
            }
        }

        return sb.toString();
    }

    //Traditional way.
    private static Map<Character, Integer> sortByValue1(Map<Character, Integer> unsorted) {
        //Map to list.  Copy whole map to list of maps.
        List<Map.Entry<Character, Integer>> list =
                new LinkedList<>(unsorted.entrySet());

        Collections.sort(list, (o1, o2) -> -o1.getValue().compareTo(o2.getValue()));
        //Collections.sort(list, Comparator.comparing(Map.Entry::getValue)); JAVA 8

        Map<Character, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Character, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }

    private static Map<String, Integer> sortByValue(Map<String, Integer> unsortMap) {

        // 1. Convert Map to List of Map
        List<Map.Entry<String, Integer>> list =
                new LinkedList<Map.Entry<String, Integer>>(unsortMap.entrySet());

        // 2. Sort list with Collections.sort(), provide a custom Comparator
        //    Try switch the o1 o2 position for a different order
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        // 3. Loop the sorted list and put it into a new insertion order Map LinkedHashMap
        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        /*
        //classic iterator example
        for (Iterator<Map.Entry<String, Integer>> it = list.iterator(); it.hasNext(); ) {
            Map.Entry<String, Integer> entry = it.next();
            sortedMap.put(entry.getKey(), entry.getValue());
        }*/


        return sortedMap;
    }
}
/*
Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input:
"Aabb"

Output:
"bbAa"

Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.
 */