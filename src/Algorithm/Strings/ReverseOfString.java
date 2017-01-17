package Algorithm.Strings;

import javax.lang.model.element.NestingKind;

/**
 * Created by Nikhil on 1/12/2017 8:47 PM.
 */
public class ReverseOfString {
    public static void main(String[] args) {
        reverseLibrary("Nikhil");
        reverseIteration("Nikihl");
        reverseRecursion("Nikhil");
    }
    private static String reverseLibrary(String a){
        System.out.println(new StringBuilder(a).reverse().toString());
        return new StringBuilder(a).reverse().toString();
    }
    private static String reverseIteration(String a){
        char[] chars = a.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = chars.length-1; i >= 0; i--) {
            stringBuilder.append(chars[i]);
        }
        System.out.println(stringBuilder.toString());
        return stringBuilder.toString();
    }
    private static String reverseRecursion(String a){
        System.out.println(reverseRecursionRec(a));
        return "";
    }
    private static String reverseRecursionRec(String a){
        if(a.length()<2){
            return a;
        }


        return reverseRecursionRec(a.substring(1)) + a.charAt(0);
    }

}
