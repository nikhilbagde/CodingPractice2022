package OTT.P6_HackerRank.Implementation.Warmup;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * https://www.hackerrank.com/challenges/compare-the-triplets/problem
 */
public class P2_ComparetheTriplets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> a = Stream.of(scanner.nextLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> b = Stream.of(scanner.nextLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> result = compareTriplets(a, b);
        System.out.println(result);

    }

    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        Integer[] array = new Integer[2];      //had to change this since we are returning List<Integer> -
        Arrays.fill(array, 0);

        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) > b.get(i)) {
                array[0]++;
            } else if (a.get(i) < b.get(i)) {
                array[1]++;
            }
        }
        return Arrays.asList(array);
    }
}
