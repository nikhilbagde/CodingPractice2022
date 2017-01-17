package LeetCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

import static java.util.Map.Entry.comparingByValue;

/**
 * Created by Nikhil on 11/3/2016.
 * https://leetcode.com/problems/sort-characters-by-frequency/
 * Input:
 "tree"

 Output:
 "eert"

 Explanation:
 'e' appears twice while 'r' and 't' both appear once.
 So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 */
public class FrequencySort {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();

        frequencySort(input);
    }
    public static void frequencySort(String input){
        TreeMap<Character,Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < input.length(); i++) {
            if(!(treeMap.containsKey(input.charAt(i)))){
                treeMap.put(input.charAt(i),1);
            }else{
                treeMap.put(input.charAt(i),treeMap.get(input.charAt(i))+1);
            }
        }
        //System.out.println(treeMap);
        inorder(treeMap);
    }
    public static void inorder(TreeMap<Character,Integer> treeMap){
        //System.out.println(treeMap.keySet());
        for(Map.Entry<Character,Integer> entry : treeMap.entrySet()){
            int count = entry.getValue();
            while(count!=0){
                System.out.print(entry.getKey());
                count--;
            }
        }
        /*Map<Character,Integer> sortedMap  = treeMap.entrySet().stream()
                                                    .sorted(Map.Entry.<Character, Integer> comparingByValue().reversed())
                                                    .forEach();
        */

        //Comparator<Map.Entry<Character,Integer>> byValue = (entry1, entry2) -> entry1.getValue().compareTo(entry2.getValue());
        //System.out.println("Printing byValues..\n" + byValue);
        /*for (Map.Entry<Character,Integer> entry : byValue
             ) {

        }*/

    }
}
