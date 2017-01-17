package CompanyCompetetions.HackerRankCompanies.CountSubStringTestCases;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Created by Nikhi on 11/28/2016.
 */
public class CountSubStrings {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println(count(in.next()));

    }
    static int count(String s) {
        List<String> list = new ArrayList<>();
        //creating all possible substrings
        for (int from = 0; from < s.length(); from++) {
            for (int to = from + 1; to <= s.length(); to++) {
            	//equal 1 and 0 meaning size is always even.
                if(s.substring(from, to).length()%2 ==0){
                    //map.put(s.substring(from, to), 0);
                    list.add(s.substring(from, to));
                }
            }
        }
        System.out.println(list);
        List<String> listNew = new ArrayList<>();
        for (String str : list) {
        //it shouldn't be palindrome, handle case like 00,11,0110,1001
        //1010 case where Tweety half are equal handled by its two equal half method.
        // 1000 case is not handled yet             1000 it should not be same.
            if(!isPallindrom(str) && !isTwoEqualHalf(str) && hasSameFirstLetter(str) && hasSameZeroOneCount(str)){     //1010 cases is not solved, done
                listNew.add(str);
            }
        }
        System.out.println(listNew);
        return listNew.size();

    }
    //to handle cases like 00,11,1010 
    private static boolean isPallindrom(String s){
        return s.equals(new StringBuilder(s).reverse().toString());
    }
    private static boolean isTwoEqualHalf(String str){
        return str.substring(0,str.length()/2).equals(str.substring(str.length()/2));
    }
    private static boolean hasSameFirstLetter(String str) {
        return str.length() <= 2 || str.substring(0, str.length() / 2).charAt(0) == (str.substring(str.length() / 2).charAt(0));
    }
    private static boolean hasSameZeroOneCount(String str){       //1000
        int zeroCount = 0, oneCount = 0;
        for (char letter: str.toCharArray()) {
            if(letter == '0') zeroCount++;
            if(letter == '1') oneCount++;
        }
        if(zeroCount == oneCount){
            return true;
        }
        return  false;
    }
}
//Test Cases:
//00110
    /*
    0011
    01
    10
     */

    /*
    10101
    10
    01
    10
    01
     */

    /*
    10001
    10
    01
     */
