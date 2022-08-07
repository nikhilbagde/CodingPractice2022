package OTT.P6_HackerRank.Strings;

import java.util.HashMap;
import java.util.Map;

public class FirstOccurence {
    public static void main(String[] args) {
        String a = "abcdefghijklmnopqrstuvwxyza";

        long startTime = System.nanoTime();
        char answer = findFirstOccurance(a);
        System.out.println(answer == '0' ? "No repeating char present in the string" : answer);
        long stopTime = System.nanoTime();
        System.out.println("Start : " + startTime + "\nStop : " + stopTime + "\nTotal time = " + (stopTime - startTime));

        //Surprising with HashMap Data Structure is faster
        startTime = System.nanoTime();
        answer = findFirstOccuranceWithDataStructure(a, 1);
        System.out.println(answer == '0' ? "No repeating char present in the string" : answer);
        stopTime = System.nanoTime();
        System.out.println("Start : " + startTime + "\nStop : " + stopTime + "\nTotal time = " + (stopTime - startTime));


    }

    private static char findFirstOccurance(String a) {
        if (a.length() == 0) {
            return ' ';
        } else if (a.length() == 1) {
            return a.charAt(0);
        } else {
            int bitTracker = 0;
            for (int i = 0; i < a.length(); i++) {
                int difference = a.charAt(i) - 'A';
                //System.out.println("Difference of "+ a.charAt(i) +"("+ (int)a.charAt(i) +")"+"-"+ "'A'" +"("+ (int)'A' +")"+ "=" + difference);
                if ((bitTracker & (1 << difference)) > 0) {
                    //System.out.println("First repeating character is " + a.charAt(i));
                    return a.charAt(i);
                }
                bitTracker = bitTracker | 1 << difference;
            }

        }
        return '0';
    }

    private static char findFirstOccuranceWithDataStructure(String a, int b) {
        Map<Character, Integer> characterCount = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            if (characterCount.containsKey(a.charAt(i)))
                return a.charAt(i);
            characterCount.put(a.charAt(i), (characterCount.get(a.charAt(i)) == null ? 0 : 1) + 1);
        }
        return '0';
    }
}
