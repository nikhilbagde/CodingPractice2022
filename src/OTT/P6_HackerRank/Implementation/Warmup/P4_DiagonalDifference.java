package OTT.P6_HackerRank.Implementation.Warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * https://www.hackerrank.com/challenges/diagonal-difference/problem
 */

public class P4_DiagonalDifference {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = 0;
        try {
            n = Integer.parseInt(bufferedReader.readLine().trim());
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(Collectors.toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        System.out.println(arr);

        int result = diagonalDifference(arr);
        System.out.println("result = " + result);
    }

    public static int diagonalDifference(List<List<Integer>> list) {
        int sumLeftToBottom = 0;
        int sumRightToBottom = 0;

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                if (i == j)
                    sumLeftToBottom += list.get(i).get(j);

                if (i + j == list.size() - 1)
                    sumRightToBottom = sumRightToBottom + list.get(i).get(j);
                //System.out.println("sumLeftToBottom = " + sumLeftToBottom);
                //System.out.println("sumRightToBottom = " + sumRightToBottom);
            }
        }
        return Math.abs(sumRightToBottom - sumLeftToBottom);
    }
}
