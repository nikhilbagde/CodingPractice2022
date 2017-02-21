package ProjectEuler.Set3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import static java.lang.System.in;

/**
 * Created by Nikhil on 2/6/2017 4:09 AM.
 * You are given around five-thousand first names,
 * begin by sorting it into alphabetical order.
 * Then working out the alphabetical value for each name,
 * multiply this value by its alphabetical position in the list to obtain a name score.
 * For example, when the list in sample is sorted into alphabetical order,
 * PAMELA, which is worth , is the  name in the list. So, PAMELA would obtain a score of .
 * You are given  queries, each query is a name, you have to print the score.
 */
public class P22NamesScores {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        int N = Integer.parseInt(reader.readLine());
        Map<String, Integer> map = new TreeMap<>();
        while (N-- > 0) {
            String name = reader.readLine();
            map.put(name, getCharSumValue(name));
        }

        Map<String, Integer> rankMap = new LinkedHashMap<>();
        int rank = 1;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            rankMap.put(entry.getKey(), rank++);
        }

        int T = Integer.parseInt(reader.readLine());
        while (T-- > 0) {
            String name = reader.readLine();
            System.out.println(rankMap.get(name) * map.get(name));
        }

    }

    private static int getCharSumValue(String name) {
        int result = 0;
        char[] array = name.toCharArray();
        for (char ch : array) {
            result += (ch - 'A') + 1;      //A=65
        }
        return result;
    }
}

