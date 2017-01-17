package CrackingTheCodingInterview.Chapter1ArrayAndString;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Nikhil on 1/16/2017 12:38 PM.
 * Assume you have a method isSubstring which checks if one word is a substring
    of another. Given two strings, si and s2, write code to check Ifs2 is a rotation of si
    using only onecalltoisSubstring (e.g., "waterbottLe" is a rotation of "erbottLewat").
 */
public class Question8IsSubString {
    public static void main(String[] args) {
        String a = "waterbottle";
        String b = "erbottlewat";
        int rotationPoint = 3;

        boolean result  = isSubStringAfterRoate(a,b,rotationPoint);
        System.out.println(result);
    }
    private static boolean isSubStringAfterRoate(String a, String b, int rotationPoint){
        if(a.length() == b.length() && a.length() >0){
            String XY = a + a;      //waterbottlewaterbottle
            return isSubString(XY, b, rotationPoint);
        }
        return false;
    }
    private static boolean isSubString(String XY, String b, int rotationPoint){
        for (int i = 0; i < XY.length()/2; i++) {
            String subString = XY.substring(i, b.length()+i);
            if(subString.equals(b))
                return true;
        }
        return false;
    }
}
