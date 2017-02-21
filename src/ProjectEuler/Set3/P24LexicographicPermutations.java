package ProjectEuler.Set3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;
import static java.lang.System.out;

/**
 * Created by Nikhil on 2/7/2017 8:02 AM.
 */
public class P24LexicographicPermutations {
    public static void main(String[] args) throws IOException {
        String input = "abcdefghijklm";
        List<String> map = generatePermutation(input);
        System.out.println(map);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        int T = parseInt(reader.readLine());
        while (T-- > 0) {
            int N = parseInt(reader.readLine());
            int result = 1;
            out.println("result = " + result);
        }
    }

    private static List<String> generatePermutation(String input) {
        List<String> map = new ArrayList<>();
        generatePermutationRec(map, "", input.toLowerCase());
        return map;
    }

    private static void generatePermutationRec(List<String> map, String pre, String input) {
        if (input.length() == 0) {
            map.add(pre);
            System.out.println(pre);

        } else {
            for (int i = 0; i < input.length(); i++) {
                generatePermutationRec(map, pre + input.charAt(i), input.substring(0, i) + input.substring(i + 1));
            }
        }
    }
}
