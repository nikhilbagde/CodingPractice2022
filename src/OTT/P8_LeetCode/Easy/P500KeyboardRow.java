package LeetCode.Easy;

import java.util.*;
import java.util.stream.Stream;

/**
 * Created by Nikhil on 3/29/2017 11:39 PM.
 */
public class P500KeyboardRow {
    public static void main(String[] args) {
        String[] words = {"Hello", "Alaska", "Dad", "Peace"};
        System.out.println(Arrays.deepToString(findWords(words)));
    }

    private static String[] findWords(String[] words) {
        String[] all = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        List<Set<Character>> list = new ArrayList<>();
        for (String s : all) {
            Set<Character> set = new TreeSet<>();
            for (char c : s.toLowerCase().toCharArray()) {
                set.add(c);
            }
            list.add(set);
        }
        System.out.println(list);

        List<String> result = new ArrayList<>();
        for (String word : words) {
            char[] temp = word.toLowerCase().toCharArray();
            Set<Character> setB = new TreeSet<>();

            for (char c : temp) {
                setB.add(c);
            }
            System.out.println(setB);
            for (Set<Character> setLarge : list) {
                Set<Character> setSmall = new HashSet<>(setB);
                setSmall.removeAll(setLarge);
                if (setSmall.isEmpty()) {
                    result.add(word);
                    break;
                }
            }
        }

        return result.toArray(new String[result.size()]);
    }

    private static String[] findWords2(String[] words) {
        return Stream.of(words)
                .filter(s ->
                        s.toLowerCase()
                                .matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*"))
                .toArray(String[]::new);
    }
}
/*
Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.
 */
