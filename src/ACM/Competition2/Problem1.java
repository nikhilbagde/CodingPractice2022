package ACM.Competition2;

import java.util.*;

import static java.lang.System.in;

/**
 * Created by Nikhil on 2/28/2017 7:30 PM.
 */
public class Problem1 {
    public static void main(String[] args) {
        String base = "TTT,TTH,THT,THH,HTT,HTH,HHT,HHH";

        String[] baseArray = base.split(",");
        HashSet<String> set = new HashSet<>(Arrays.asList(baseArray));
        System.out.println(Arrays.toString(baseArray));
        System.out.println(set);


        String test = "HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH";
        Scanner scanner = new Scanner(in);
        int T = scanner.nextInt();

        while (T-- > 0) {
            int count = scanner.nextInt();
            String input = scanner.next();

            Map<String, Integer> map = new LinkedHashMap<>();
            map.put("TTT", 0);
            map.put("TTH", 0);
            map.put("THT", 0);
            map.put("THH", 0);
            map.put("HTT", 0);
            map.put("HTH", 0);
            map.put("HHT", 0);
            map.put("HHH", 0);

            System.out.print(count + " ");
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                int localCount = 0;
                for (int i = 0; i < input.length() - 2; ++i) {
                    if (entry.getKey().equals(input.substring(i, i + 3))) {
                        ++localCount;
                    }
                }
                System.out.print(localCount + " ");
            }
            System.out.println();
        }
    }
}
