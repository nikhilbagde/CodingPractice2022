package Books.B4_Java8Lambdas;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exercise1 {
    public static void main(String[] args) {
        Function<Long, Long> add = x -> x + 1;
        //Function<Long,Long> add2 = (x , y ) -> x + 1;     // Wont compile as expected number of paramters are 1
        //Function<Long,Long> add3 = x -> x ==1;            // returning boolean

        Runnable helloWorld = () -> System.out.println("Hello World");

        List<String> collected = Stream.of("a", "b", "hello").map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(collected);
    }
}
