package GeeksForGeeks.JavaReview.Advance.Streams;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Nikhil on 1/8/2017 3:03 PM.
 */
public class Streams {
    //Generic Print
    public static <N> void p(N type){
        System.out.println(type);
    }
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1,2,3,4,5,56,6);

        //Itermediate operations
        //1. map(predicate)
        List<Integer> resultList1 = list1.stream().map(x->x*x).collect(Collectors.toList());  //this is collector not collections.
        p(resultList1);

        //2.filter
        List<String> list2 = Arrays.asList("one", "two", "three", "four");
        List<String> resultList2 = list2.stream().filter(s -> s.contains("o")).collect(Collectors.toList());
        p(resultList2);

        //3.sort
        List<String> list3 = Arrays.asList("S","P","J","E","K","U","C","N","S");
        List<String> resultList3 = list3.stream().sorted().collect(Collectors.toList());
        p(resultList3);

        //Terminal Operations
        //1.collect
        List<Integer> list4 = Arrays.asList(12,2,33,33,4,5,56,6);
        Set<Integer> resultSet1 = list4.stream().collect(Collectors.toSet());  //this is collector not collections.
        p(resultSet1);



        Stream<String> emptyStream = Stream.empty();
        Stream<Integer> streamOfOne = Stream.of(1);
        Stream<Integer> streamOfArray = Stream.of(1,2,4,5,6);

        //Stream of Odd numbers
        Stream<Double> randomStream = Stream.generate(Math::random);
        Stream<Integer> oddNumber = Stream.iterate(1, n -> n + 2 );


        /**
         * Terminal Operations
         */
        //1. count()   REDUCTION  = YES
        List<String> list = Arrays.asList("one", "two","three");

        Stream<String> scount =  Stream.of("one", "two","three");
        Stream<String> streamFromList = list.stream();

        System.out.println(scount.count());

        //2. min()  REDCUTION = YES
        Stream<String> s = Stream.of("monkey","ape","bonobo");
        Optional<String> min = s.min((a,b)-> a.length()-b.length());
        min.ifPresent(System.out::println);

        Optional<?> sizeOfEmptyStream=  Stream.empty().min((s1,s2)-> 0);
        System.out.println(sizeOfEmptyStream.isPresent());


        //3. FindAny(), finaAll()
        Stream<String> sfind = Stream.of("AnimalOne", "AnimalTwo", "AnimalThree");
        Stream<String> sinfinite = Stream.generate( () -> "AnimalFour");

        sfind.findAny().ifPresent(System.out::println);
        sinfinite.findAny().ifPresent(System.out::println);


        //4. anyMatch(), allMatch(), noneMatch()  -- Not a reduction since not necessary it will go through whole stream date.
        // This example checks whether animal names begin with letters:
        List<String> list5 = Arrays.asList("monkey", "2", "chimp");
        Stream<String> infinite = Stream.generate(() -> "chimp");
        Predicate<String> pred = x -> Character.isLetter(x.charAt(0));
        System.out.println(list5.stream().anyMatch(pred)); // true
        System.out.println(list5.stream().allMatch(pred)); // false
        System.out.println(list5.stream().noneMatch(pred)); // false
        System.out.println(infinite.anyMatch(pred)); // true


        //5. forEach()
        Stream<String> stream1 = Stream.of("one", "two","three");
        stream1.forEach(System.out::print);  //onetwothree


        //6. reduce()   its a reduction

        //traditional way
        String[] array = new String[] { "w", "o", "l", "f" };
        String result = "";
        for (String st: array) result = result + st;
        System.out.println(result);

        //with lambda
        Stream<String> stream = Stream.of("w", "o", "l", "f");
        String word = stream.reduce("", (p, c) -> p + c);
        System.out.println(word); // wolf

        //method reference
        Stream<String> stream9 = Stream.of("w", "o", "l", "f");
        String word1 = stream9.reduce("", String::concat);
        System.out.println(word); // wolf

        //reduction of multiply all objects in stream
        Stream<Integer> muliply = Stream.of(2,6,2,68,4,21);
        int multipledValue = muliply.reduce(1, (a,b) -> a*b);

        //7. collect

        Stream<String> stream11 = Stream.of("w", "o", "l", "f");
        TreeSet<String> set = stream11.collect(TreeSet::new, TreeSet::add,
                TreeSet::addAll);
        System.out.println(set); // [f, l, o, w]

        Stream<String> stream12 = Stream.of("w", "o", "l", "f");
        TreeSet<String> set1 = stream12.collect(Collectors.toCollection(TreeSet::new));
        System.out.println(set1); // [f, l, o, w]

        //If we didn’t need the set to be sorted, we could make the code even shorter:
        Stream<String> stream13 = Stream.of("w", "o", "l", "f");
        Set<String> set3 = stream13.collect(Collectors.toSet());
        System.out.println(set3); // [f, w, l, o]


        /**
         * Using Common Intermediate Operations
         */

        //1. filter()
        Stream<String> s12 = Stream.of("monkey", "gorilla", "bonobo");
        s12.filter(x -> x.startsWith("m")).forEach(System.out::print); // monkey

        //2.distinct()
        Stream<String> s13 = Stream.of("duck", "duck", "duck", "goose");
        s13.distinct().forEach(System.out::print); // duckgoose

        //3. limit() and skip()
        /**
         * Stream<T> limit(int maxSize)
         * Stream<T> skip(int n)
         */
        Stream<Integer> s14 = Stream.iterate(1, n -> n + 1);
        s14.skip(5).limit(2).forEach(System.out::print); // 67

        //4. map()
       /* As an example, this code converts a list of String objects to a list of Integer s representing
        their lengths:*/
        Stream<String> s15 = Stream.of("monkey", "gorilla", "bonobo");
        s15.map(String::length).forEach(System.out::print); // 676
        s15.map(n -> n.length()).forEach(System.out::print);
        /*Remember that String::length is shorthand for the lambda x -> x.length() , which
        clearly shows it is a function that turns a String into an Integer .*/

        // 5. flatMap()
        List<String> zero = Arrays.asList();
        List<String> one = Arrays.asList("Bonobo");
        List<String> two = Arrays.asList("Mama Gorilla", "Baby Gorilla");
        Stream<List<String>> animals = Stream.of(zero, one, two);
        animals.flatMap(l -> l.stream()).forEach(System.out::println);
        /*Here’s the output:
        Bonobo
        Mama Gorilla
        Baby Gorilla
        As you can see, it removed the empty list completely and changed all elements of each
        list to be at the top level of the stream.*/

        //6. sorted()
        Stream<String> s16 = Stream.of("brown-", "bear-");
        s16.sorted().forEach(System.out::print); // bear-brown-

        Stream<String> s17 = Stream.of("brown bear-", "grizzly-");
        s17.sorted(Comparator.reverseOrder())
                .forEach(System.out::print); // grizzly-brown bear-

        //7. peek()
        /*The most common use for peek() is to output the contents of the stream as it goes by.
        Suppose that we made a typo and counted bears beginning with the letter g instead of b .
                We are puzzled why the count is 1 instead of 2. We can add a peek() to fi nd out why:*/
        Stream<String> stream18 = Stream.of("black bear", "brown bear", "grizzly");
        long count = stream18.filter(s19 -> s19.startsWith("g"))
                .peek(System.out::println).count(); // grizzly
        System.out.println(count); // 1




        /*Putting Together the Pipeline
        Streams allow you to use chaining and express what you want to accomplish rather than
        how to do so. Let’s say that we wanted to get the first two names alphabetically that are
        four characters long. In Java 7, we’d have to write something like the following:*/

        List<String> list6 = Arrays.asList("Toby", "Anna", "Leroy", "Alex");
        List<String> filtered = new ArrayList<>();
        for (String name: list6) {
            if (name.length() == 4) filtered.add(name);
        }
        Collections.sort(filtered);
        Iterator<String> iter = filtered.iterator();
        if (iter.hasNext()) System.out.println(iter.next());
        if (iter.hasNext()) System.out.println(iter.next());

        /*This works. It takes some reading and thinking to figure out what is going on. The problem
        we are trying to solve gets lost in the implementation. It is also very focused on the how
        rather than on the what. In Java 8, the equivalent code is as follows:*/
        List<String> list7= Arrays.asList("Toby", "Anna", "Leroy", "Alex");
        list7.stream().filter(n -> n.length() == 4).sorted()
                .limit(2).forEach(System.out::println);
        /*Before you say that it is harder to read, we can format it:*/
        list7.stream().filter(n -> n.length() == 4)
                .sorted()
                .limit(2)
                .forEach(System.out::println);
        /*The difference is that we express what is going on. We care about String objects of
        length 4. Then we then want them sorted. Then we want to first two. Then we want to
        print them out. It maps better to the problem that we are trying to solve, and it is simpler
        because we don’t have to deal with counters and such.*/
    }
}
