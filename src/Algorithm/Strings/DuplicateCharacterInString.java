package Algorithm.Strings;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Nikhil on 1/12/2017 6:59 PM.
 */
public class DuplicateCharacterInString {

    public static void main(String[] args) {
        findDuplicate("Programming");
        findDuplicate("Combination");
        findDuplicate("Java");
    }
    public static void findDuplicate(String input){
        char[] array = input.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for (char c: array) {
            if(!map.containsKey(c)){
                map.put(c, 1);
            }else{
                map.put(c, map.get(c)+1);
                //System.out.print(c);
            }
        }
        System.out.println();
        for (Map.Entry<Character, Integer> entry: map.entrySet()) {
            if(entry.getValue() >1){
                System.out.print(entry.getKey());
            }
        }
    }
}
