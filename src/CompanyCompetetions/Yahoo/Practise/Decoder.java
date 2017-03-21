package CompanyCompetetions.Yahoo.Practise;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Nikhil on 2/28/2017 3:01 PM.
 */
public class Decoder {
    public static void main(String[] args) {
        //input: string "1234"
        //output: All possible decoded character combinations
        //1 => 'a', '2' => 'b', '10' => 'j', '20' => 't', '26' => 'z'
        //Sample output:
        //  a,b,c,d
        //  1,2,3,4
        //  a,w,d
        //  1,23,4
        //  l,c,d
        //  12, 3,4
        String input = "1234";

        decodeNumbersToAllPossibleAlphabets(input);
        decodeNumbersToAllPossibleAlphabets("1111");

    }

    private static void decodeNumbersToAllPossibleAlphabets(String input) {

        for (int i = 0; i < input.length(); ++i) {
            System.out.print((char) (input.charAt(i) - 49 + 'a') + " ");
        }
        System.out.println();

        //Set<Integer> set = new HashSet<>();
        int window = 0;
        for (int i = 0; i < input.length() - 1; ) {
            String output = "";
            boolean valid = true;
            if (window != i) {
                while (i != window) {
                    //System.out.print((char) (input.charAt(i) - 49 + 'a') + ",");
                    output = output + (char) (input.charAt(i) - 49 + 'a') + " ";
                    i++;
                }
            }
            int value = Integer.parseInt(input.substring(window, window + 2));
            if (value < 27) {
                //set.add(value);
                //System.out.print((char)(value + 'a' -1) + " ");
                output = output + (char) (value + 'a' - 1) + " ";
                if (i + 2 < input.length()) {
                    for (int j = i + 2; j < input.length(); ++j) {
                        //System.out.print((char)(input.charAt(j) - 49 + 'a') + ",");
                        output += (char) (input.charAt(j) - 49 + 'a') + " ";
                    }
                }
                i = 0;
                window += 1;
            } else {
                valid = false;
                break;
            }
            if (valid) {
                System.out.println(output);
            }
            //System.out.println();
        }
    }

    private static Set<String> test2(String pre, String input) {
        Set<String> set = new HashSet<>();
        ArrayList<String> list = new ArrayList<>();
        if (input.length() == 0) {
            set.add(pre);
            list.add(pre);
            return set;
        }
        if (input.charAt(0) == '0') {
            return set;
        }

        set.addAll(test2(pre + (char) (input.charAt(0) - '1' + 'a'), input.substring(1)));
        list.addAll(test2(pre + (char) (input.charAt(0) - '1' + 'a'), input.substring(1)));

        if (input.length() >= 2 && input.charAt(0) == '1') {
            set.addAll(test2(pre + (char) (10 + input.charAt(1) - 'a' + '1'), input.substring(2)));
            list.addAll(test2(pre + (char) (10 + input.charAt(1) - 'a' + '1'), input.substring(2)));
        }

        if (input.length() >= 2 && input.charAt(0) == '2' && input.charAt(1) < '7') {
            set.addAll(test2(pre + (char) (20 + input.charAt(1) - 'a' + '1'), input.substring(2)));
            list.addAll(test2(pre + (char) (20 + input.charAt(1) - 'a' + '1'), input.substring(2)));

        }
        return set;

    }

}
