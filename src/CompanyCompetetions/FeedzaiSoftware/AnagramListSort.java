package CompanyCompetetions.FeedzaiSoftware;

import java.util.*;

import static java.lang.System.in;

/**
 * Created by Nikhil on 3/22/2017 4:49 PM.
 */

/**
 * Two words are called friendly if the letters of the first can be rearranged to produce the second (e.g., "silent" and "listen" are friendly).
 * Write a program that given a set of words prints out all friendly words. Each set of friendly words should be printed on a separate line.
 * Words without friends should not be printed. The output should be alphabetically ordered (across lines and within each line).
 *
 * @return An array with each line of the output. Each line should have already the friendly words. (eg.: the first line of the example output is "cheating teaching"
 */
public class AnagramListSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(in);
        String[] a = null;

        try {
            a = scanner.nextLine().split(" ");
        } catch (Exception e) {

        }
        try {
            for (String words : friendlyWords(a)) {
                System.out.println(words);
            }
        } catch (Exception e) {
            System.out.println("Unhandled execption!");
        }
    }

    /*
    car cheating dale deal lead listen silent teaching
     */
    static String[] friendlyWords(String[] input) {
        List<String> arrayList = Arrays.asList(input);
        Map<String, Set<String>> map = new TreeMap<>();

        for (String string : arrayList) {
            char[] temp = string.toCharArray();
            Arrays.sort(temp);
            if (map.containsKey(String.valueOf(temp))) continue;

            Set<String> set = new TreeSet<>();
            for (String string2 : arrayList) {
                if (!string.equals(string2) && string.length() == string2.length() && isAnagram(string, string2)) {
                    set.add(string);
                    set.add(string2);
                }
            }
            if (!set.isEmpty()) {
                char[] temp1 = string.toCharArray();
                Arrays.sort(temp1);
                map.put(String.valueOf(temp1), set);
            }
            set = null;
        }
        //System.out.println(map);
        //System.out.println(map.values());

        //System.out.println("required output");
        String[] result = new String[input.length];
        int index = 0;
        for (Set<String> set : map.values()) {
            for (String string : set) {
                System.out.print(string + " ");
                result[index++] = string;
            }
            System.out.println();
        }
        System.out.println();

        return result;
    }

    private static void sort(List<String> list) {
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareToIgnoreCase(o2);
            }
        });
    }

    public static boolean isAnagram(String first, String second) {
        char[] firstArray = first.toLowerCase().toCharArray();
        char[] secondArray = second.toLowerCase().toCharArray();

        Arrays.sort(firstArray);
        Arrays.sort(secondArray);
        //System.out.println(Arrays.equals(firstArray, secondArray));

        return Arrays.equals(firstArray, secondArray);

    }
}

/*
Output :
cheating teaching
dale deal lead
listen silent
 */