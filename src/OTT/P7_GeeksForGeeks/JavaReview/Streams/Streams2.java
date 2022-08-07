package OTT.P7_GeeksForGeeks.JavaReview.Streams;

import java.util.Arrays;
import java.util.stream.Stream;
import java.util.*;

public class Streams2 {

	public static void main(String[] args) {
		Stream<String> stream = Stream.empty();
		//System.out.println(stream);
		stream.forEach(System.out::println);
		
		//System.out.println(stream.count());
		
		Stream<Integer> stream2 = Stream.of(1,2,3);
		
		List<String> list = Arrays.asList("Sasd", "Asdas", "asdyhb");
		Stream<String> stream3 = list.stream();
		Stream<String> stream4 = list.parallelStream();
		
		System.out.println(stream3.count());
		
		
		Stream<Double> randon = Stream.generate(Math::random);
		Stream<Integer> oddNumber = Stream.iterate(1, n -> n + 2);
		
		Stream<String> stream5 = list.stream();
		Optional<String> min = stream5.min((s1,s2) -> s1.length()-s2.length());
		min.ifPresent(System.out::println);
		
		Optional<String> max = list.stream().max((s1,s2) -> s1.length() - s2.length());
		max.ifPresent(System.out::println);
		// max is not working out. Dont know how to write that comparator.
		
		
		
		//Reduce
		Stream<String> stream6 = Stream.of("s","a","t","u","r","d");
		System.out.println(stream.reduce("", (s1,s2) -> s1+s2));
		//System.out.println(stream.reduce("", String::concat);
		
		
	}

}
