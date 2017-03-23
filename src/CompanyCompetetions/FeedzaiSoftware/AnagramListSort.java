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
            System.out.println("Unhandled exception!");
        }
    }

    /*
    car cheating dale deal lead listen silent teaching
     */
    static String[] friendlyWords(String[] input) {
        Map<String, Set<String>> map = new TreeMap<>();

        for (String string : input) {
            char[] temp = string.toCharArray();
            Arrays.sort(temp);
            String key = String.valueOf(temp);

            if (map.containsKey(key)) continue;

            Set<String> set = new TreeSet<>();
            for (String string2 : input) {
                if (!string.equals(string2) && string.length() == string2.length() && isAnagram(string, string2)) {
                    set.add(string);
                    set.add(string2);
                }
            }
            if (!set.isEmpty()) {
                map.put(key, set);
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