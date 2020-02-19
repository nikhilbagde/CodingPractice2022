package Books.Java8Lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Exercise3 {
    public static void main(String[] args) {

        //map
        List<String> collected =
                Stream.of("a", "b", "hello")
                        .map(String::toUpperCase)
                        .collect(toList());
        System.out.println(collected);

        //filters
        List<String> beginningWithNumber =
                Stream.of("a", "1abc", "abc1")
                        .filter(str -> Character.isDigit(str.charAt(0)))
                        .collect(toList());

        System.out.println(beginningWithNumber);

        //flatmap  combining streams
        List<Integer> combined =
                Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4))
                        .flatMap(num -> num.stream())
                        .collect(toList());

        System.out.println(combined);

        //reduce
        int count = Stream.of(1, 2, 3)
                .reduce(0, (accumulator, element) -> accumulator + element);
        System.out.println(count);
    }
}
