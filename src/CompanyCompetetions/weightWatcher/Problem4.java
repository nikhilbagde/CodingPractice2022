package CompanyCompetetions.WeightWatcher;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Nikhi on 12/23/2016 8:01 PM.
 */
public class Problem4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //String s = scanner.next();
        String s1 = "A quick brown fox jumps over the lazy dog.";
        String s2 = "ABCDEFGJMOPQRSTUVWXYZ";
        //String s = scanner.nextLine();
        System.out.println(listMissingLetters(s2));
    }
    public static String listMissingLetters(String s){
        String input = s.toLowerCase().replaceAll("\\s+","");
        Map<Character,Boolean> map1 = new HashMap<>();              //using map for faster access o(1)
        StringBuilder stringBuilder = new StringBuilder();          //using string builder for optimizing appending.

        //Create a map for all characters in it.
        for (char i = 'a'; i <=  'z'; i++) {
            map1.put(i, false);
        }
        //"A quick brown fox jumps over the lazy dog.";
        // fill the map for all characters from given string
        for (int i = 0; i < input.length(); i++) {
            if(map1.containsKey(input.charAt(i))){
                map1.put(input.charAt(i), true);
            }
        }
        //Iterate map and check if its not present in map
        //if not make a string out of it as required output.
        for (Map.Entry<Character, Boolean> entry: map1.entrySet()) {
            if(!entry.getValue()){
                stringBuilder.append(entry.getKey());
            }
        }
        return stringBuilder.toString();
    }
}
