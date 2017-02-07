package CompanyCompetetions.PayPal.Practice;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/**
 * Created by Nikhil on 2/6/2017 4:42 PM.
 * Problem is to find if two string have same number of characters.
 */
public class P2SameFrequencyOfCharIn2Strings {
    public static void main(String[] args) {
        String one = "Nikhil";
        String two = "LiHkIN";
        System.out.println(checkSameFrequencyOfLetters(one, two));
    }
    private static boolean checkSameFrequencyOfLetters(String one, String two){
        boolean result= true;
        int [] frequencyArray = new int[128];           //assuming there are 128 unique characters.

        for (char ch: one.toLowerCase().toCharArray()) {
            frequencyArray[ch]++;
        }
        for (char ch: two.toLowerCase().toCharArray()) {
            if(--frequencyArray[ch] < 0) return false;
        }
        return result;
    }
}
