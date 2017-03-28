package Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
/**
 * Created by Nikhi on 9/30/2016.
 */
public class Streams {
    public static void main(String[] args) {
        System.out.println(
                IntStream.iterate(0, i-> i+1)
                .limit(1000)
                .filter(i -> (i%3 ==0) || (i%5 ==0))
                .sum()
        );
    }

    private static void generateOnetoHunderdNumbersUsingStream() {
        ArrayList<Integer> numbers = new ArrayList<>();
        int[] a = IntStream.iterate(1, i -> i + 1)
                .limit(100).toArray();
        List<Integer> list = Arrays.stream(a).boxed().collect(Collectors.toList());
        System.out.println(list);

    }
}
