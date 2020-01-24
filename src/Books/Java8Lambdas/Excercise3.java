package Books.Java8Lambdas;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Excercise3 {
    public static void main(String[] args) {

        //map
        List<String> collected =
                Stream.of("a","b","hello")
                    .map(String::toUpperCase)
                    .collect(Collectors.toList());
        System.out.println(collected);

        //filters
        List<String> beginningWithNumber =
                Stream.of("a", "1abc", "abc1")
                        .filter(str -> Character.isDigit(str.charAt(0)))
                        .collect(Collectors.toList());
    }
}
