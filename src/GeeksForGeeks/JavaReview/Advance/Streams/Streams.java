package GeeksForGeeks.JavaReview.Advance.Streams;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by Nikhil on 1/8/2017 3:03 PM.
 */
public class Streams {
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



    }
}
