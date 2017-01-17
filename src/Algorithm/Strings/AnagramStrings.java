package Algorithm.Strings;

import java.util.Arrays;

/**
 * Created by Nikhil on 1/12/2017 7:18 PM.
 */
public class AnagramStrings {
    public static void main(String[] args) {
        testAnagram();
    }
    public static boolean isAnagram(String first, String second){
        char[] firstArray = first.toLowerCase().toCharArray();
        char[] secondArray = second.toLowerCase().toCharArray();

        Arrays.sort(firstArray);
        Arrays.sort(secondArray);
        System.out.println(Arrays.equals(firstArray, secondArray));

        return Arrays.equals(firstArray, secondArray);

    }
    private static boolean isAnagram2(String a, String b){
        if(a.length() != b.length()){
            return false;
        }
        char [] aArray = a.toLowerCase().toCharArray();
        b = b.toLowerCase();

        for(char c: aArray){
            int index = b.indexOf(c);
            if(index != -1){
                b = b.substring(0, index) + b.substring(index+1);
            }else{
                return false; //doesnt have that char.
            }
        }
        return b.isEmpty();
    }
    private static void testAnagram(){
        assert (isAnagram("Army","Mary"));
        assert (isAnagram("Loop","pool"));
        assert (isAnagram("one","eno"));
        assert (isAnagram("two","three"));
        assert (isAnagram("Army","Mary"));
    }
}
