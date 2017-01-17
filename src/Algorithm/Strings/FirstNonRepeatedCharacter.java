package Algorithm.Strings;

import java.util.*;

/**
 * Created by Nikhil on 1/12/2017 8:23 PM.
 */
public class FirstNonRepeatedCharacter {
    public static void main(String[] args) {
        getFirstNonRepeatedChar("abcdefghija");
        getFirstNonRepeatedChar2("abcdefghija");
    }
    /*Space Complexity = O (n) , Time : O(n) */
    private static char getFirstNonRepeatedChar(String a){
        char[] chars = a.toCharArray();
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char c: chars) {
            map.put(c , map.containsKey(c) ? map.get(c) +1 : 1);
        }
        for ( Map.Entry<Character, Integer> entrySet : map.entrySet()) {
            if(entrySet.getValue() == 1){
                return entrySet.getKey();
            }
        }
        throw new RuntimeException("Didn't find any non repeated Character");
    }
    /*Reduced space complexity + Time : O(n) */
    private static char getFirstNonRepeatedChar2(String a){
        Set<Character> set = new HashSet<>();
        List<Character> list = new ArrayList<>();

        for (char c: a.toCharArray()) {
            if(set.contains(c)){
                continue;
            }
            if(list.contains(c)){
                list.remove(c);
                set.add(c);
            }else {
                list.add(c);
            }
        }
        return list.get(0);
    }
}
