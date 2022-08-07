package OTT.P6_HackerRank.Recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nikhi on 4/20/2017.
 */
public class GrayCode1 {
    public static void main(String[] args) {
        String input = "abcd";
        generateAllPossibilities(input);
    }

    private static void generateAllPossibilities(String input) {
        int length = input.length();
        length =  (int) Math.pow(length, 2);
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < length; i++) {
            list.add(Integer.toBinaryString(i));
        }
        System.out.println(list);
    }
}
