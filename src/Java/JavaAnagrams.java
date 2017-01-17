package Java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Nikhi on 11/17/2016.
 * https://www.hackerrank.com/challenges/java-anagrams
 * 1. Arrays.equals( Arraya, Arrayb) checks if both array are same including duplicates, hence first sort them
 *
 * Two strings  and  are called anagrams if they consist same characters, but may be in different orders.
 * So the list of anagrams of  is .
 * Sample Input=
 * anagram
 * margana
 * Sample Output 0
 * Anagrams
 */
public class JavaAnagrams {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Notice at start only I changed to to lower case.

        String a = sc.next().toLowerCase();
        String b = sc.next().toLowerCase();

        //Then convert to char Array
        char [] aa = a.toCharArray();
        char [] bb = b.toCharArray();

        //Then Sort (n log n)
        Arrays.sort(aa);
        Arrays.sort(bb);

        //2nd
        //System.out.println(Arrays.equals(aa,bb) ? "Anagrams" : "Not Anagrams" );
        //1st
        //System.out.println(checkAnagrams(a,b) ? "Anagrams" : "Not Anagrams");

        //3rd Appraich O(n)
        System.out.println(checkAnagramsEfficient(a,b) ? "Anagrams" : "Not Anagrams");

    }
    public static boolean checkAnagrams(String a, String b){
        if(a.length()!= b.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {

            if(!map.containsKey(a.charAt(i))){
                map.put(a.charAt(i), 1);
            }else{
                map.put(a.charAt(i), map.get(a.charAt(i))+1);
            }
        }
        for (int i = 0; i < b.length(); i++) {
            if(!map.containsKey(b.charAt(i))) return false;
        }
        return true;
    }
    public static boolean checkAnagramsEfficient(String a, String b){
        int [] array = new int[128];
        //Remember to convert String to lower case otherwise Hello hello test would fail.
        // Then next convert to charArray simply.
        //Set 1 to char location in array
        for (char c : a.toLowerCase().toCharArray()) {
            //characters are nothing but the integers,
            //Get that char, at same value of array's location set it to 1.
            array[(int)c]++;
            //int value = (int) c;
            //array[value] = 1;

        }

        //Unset that 1 of same character location of another array.
        for (char c : b.toLowerCase().toCharArray()) {
            array[(int) c]--;
        }

        for (int i = 0; i < array.length; i++) {
            if(array[i] != 0)
                return false;
        }
        return true;

    }
}
