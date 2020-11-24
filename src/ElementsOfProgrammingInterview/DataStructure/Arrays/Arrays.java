package ElementsOfProgrammingInterview.DataStructure.Arrays;

import java.util.stream.IntStream;

public class Arrays {
    public static void main(String[] args) {
        int[] arr_int = new int[20];
        int[] arr_int_2 = new int[]{1, 2, 3, 4, 5, 6, 7};

        int[] arr_clone = arr_int_2.clone();

        //Java 8
        int[] arr_int_3 = IntStream.range(0, 100).toArray();
        int[] arr_int_4 = IntStream.rangeClosed(0, 100).toArray();
        int[] arr_int_5 = IntStream.of(0, 100, 200, 400).toArray();
        int[] arr_int_6 = IntStream.of(0, 100, 200, 400).sorted().toArray();

        String[] arr_string = new String[4];
        String[] arr_string_2 = {"a", "ba", "bac"};
        String[] arr_string_3 = new String[]{"a", "ba", "bac"};

        String first = arr_string_2[2];
        IntStream intStream = first.chars();
        System.out.println("intStream = " + intStream);

        char[] arr_char = first.toCharArray();
        System.out.println("arr_char = " + arr_char);
        char character = first.charAt(1);

        String[] arr_split = first.split("a");
        System.out.println("arr_split = " + arr_split);

        String second = first.replace("a", "aa");
        System.out.println("second = " + second);

        String third = first.replaceAll("a", "aa");
        System.out.println("third = " + third);

        String fourth = first.substring(0, 1);
        System.out.println("fourth = " + fourth);

        int reuslt = first.compareTo(arr_string_2[1]);
        int index = first.indexOf("b");

        String fifth = first.concat(second);
        System.out.println("fifth = " + fifth);

        int index2 = first.codePointAt(0);

    }
}
