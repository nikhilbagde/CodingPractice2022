package Algorithm.WarmUp;

import java.io.*;
import java.lang.reflect.Array;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *  https://www.hackerrank.com/challenges/birthday-cake-candles/problem
 * Created by nbagde on 8/16/2018.
 */
public class P9_BirthdayCakeCandles {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args)  throws IOException{

        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();


        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");           // /u0085 NEXT LINE, /u2029 - PARAGRAPH SEPARATOR , /u2028 LINE SEPARATOR

        int[] array = new int[n];
        String[] items = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");           // /u0085 NEXT LINE, /u2029 - PARAGRAPH SEPARATOR , /u2028 LINE SEPARATOR


            for (int i = 0; i < n; i++) {
                int item = Integer.parseInt(items[i]);
                array[i] = item;
            }
            int result = birthdayCakeCandles2(array);

        System.out.println(result);
        /*bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedWriter.close();*/
        scanner.close();

    }

    /**
     *  O(n) solution
     * @param array
     * @return
     */
    static int birthdayCakeCandles2(int[] array){
        if(array.length> 100000) return 0;
        if(array.length == 1) return 1;

        int max = array[0], count = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i]>10_000_000 || array[i]<1){
                return 0;
            }
            if(array[i]>max){
                max = array[i];
                count = 1;
            }else if(array[i]==max){
                count++;
            }
        }
        return count;
    }

    /**
     * Using streams
     * @param array
     * @return
     */
    static int birthdayCakeCandles3(int[] array){

        //IntStream intStream = IntStream.of(array);
        IntStream stream = IntStream.of(array);
        //Map<Integer, List<Integer>> collect = stream.mapToObj(s -> new Integer(s)).collect(Collectors.groupingBy( s-> s));
        //Map<Integer, List<Integer>> collect = stream.mapToObj(s -> new Integer(s)).collect(Collectors.groupingBy( s-> s, Collectors.toList()));
        //TreeMap<Integer, List<Integer>> ourMap = new TreeMap<> (Collections.reverseOrder());
        Supplier<TreeMap<Integer, List<Integer>>> sup = () -> new TreeMap<> (Collections.reverseOrder());

        //TreeMap<Integer, List<Integer>> collect2 = stream.mapToObj(s -> new Integer(s)).collect(Collectors.groupingBy(s->s, sup,  Collectors.toList())    );
        int result;
        try{
            //result = stream.filter(o -> {if(o>100000 && o<1)  throw new InvalidParameterException(); return true;   }).mapToObj(s -> new Integer(s)).collect(Collectors.groupingBy(s->s, sup,  Collectors.toList())    ).firstEntry().getValue().size();
            result = stream.filter(o -> {
                if (o > 100000 && o < 1)
                    throw new InvalidParameterException();
                return true;
            }).mapToObj(s -> new Integer(s)).collect(
                    Collectors.groupingBy(s -> s, () -> new TreeMap<>(Collections.reverseOrder()), Collectors.toList()))
                    .firstEntry().getValue().size();
        }catch( InvalidParameterException e){
            result = 0;
        }
        System.out.println("Oneliner = " + result );
        /*System.out.println(collect2);
        System.out.println(collect2.firstEntry().getValue().size());*/

        //Function<Integer,List<Integer>>
        return result;

    }




}


/*
You are in charge of the cake for your niece's birthday and have decided the cake will have one candle for each year of her total age. When she blows out the candles, she’ll only be able to blow out the tallest ones. Your task is to find out how many candles she can successfully blow out.

For example, if your niece is turning  years old, and the cake will have  candles of height , , , , she will be able to blow out  candles successfully, since the tallest candles are of height  and there are  such candles.

Function Description

Complete the function birthdayCakeCandles in the editor below. It must return an integer representing the number of candles she can blow out.

birthdayCakeCandles has the following parameter(s):

ar: an array of integers representing candle heights
Input Format

The first line contains a single integer, , denoting the number of candles on the cake.
The second line contains  space-separated integers, where each integer  describes the height of candle .

Constraints

Output Format

Print the number of candles that can be blown out on a new line.

Sample Input 0

4
3 2 1 3
Sample Output 0

2
Explanation 0

We have one candle of height , one candle of height , and two candles of height . Your niece only blows out the tallest candles, meaning the candles where . Because there are  such candles, we print  on a new line.
 */