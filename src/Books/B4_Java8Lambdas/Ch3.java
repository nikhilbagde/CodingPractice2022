package Books.B4_Java8Lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Ch3 {

    public static void main(String[] args) {

        //Common stream APIs

        //1. Collect(Collector.toList()); | (Terminal eager)
        List<String> collected = Stream.of("a", "b", "c")
                .collect(Collectors.toList());      // if I import Collector.toList() statically then I do not have to write Collector here.

        System.out.println(collected);

        //2. map (intermediate - lazy)
        List<String> toUpperCase = Stream.of("a", "b", "hello")
                .map(o -> o.toUpperCase())
                .collect(Collectors.toList());
        System.out.println(toUpperCase);

        //3. filter (Intermediate - lazy)
        List<String> beginningWithNumber =
                Stream.of("a", "1abc", "abc1")
                        .filter(str -> Character.isDigit(str.charAt(0)))
                        .collect(toList());
        System.out.println();

        System.out.println(beginningWithNumber);

        //4. flatMap (Intermediate - lazy)
        List<Integer> combined =
                Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4))
                        .flatMap(num -> num.stream())
                        .collect(toList());

        System.out.println(combined);

        //5. Max and Min (Terminal - Eager)
        /*List<Track> tracks = asList(new Track("Bakai", 524),
                new Track("Violets for Your Furs", 378),
                new Track("Time Was", 451));
        Track shortestTrack = tracks.stream()
                .min(Comparator.comparing(track -> track.getLength()))
                .get();*/

        //6. Reduce (Terminal - Eager)
        int count = Stream.of(1, 2, 3)
                .reduce(0, (accumulator, element) -> accumulator + element);
        System.out.println(count);
    }
}
