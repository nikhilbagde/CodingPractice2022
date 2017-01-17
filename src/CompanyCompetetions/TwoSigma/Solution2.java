package CompanyCompetetions.TwoSigma;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Nikhi on 12/4/2016.
 * TEst case 1 -6 passed , 7-10 time out
 */
public class Solution2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.next();
        getCountPallindromSubString(string);
    }
    //aabaa
    static int getCountPallindromSubString(String str) {
        Set<String> set = new HashSet<>();
        for (int from = 0; from < str.length(); from++) {
            for (int to = from + 1; to <= str.length(); to++) {
                String subString = str.substring(from, to);
                if(!set.contains(subString) && new StringBuilder(subString).reverse().toString().equals(subString)){
                    set.add(subString);
                }
            }
        }
        return set.size();
    }
}
