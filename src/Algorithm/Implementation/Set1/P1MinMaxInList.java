package Algorithm.Implementation.Set1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.in;

/**
 * Created by Nikhil on 2/13/2017 7:27 PM.
 */
public class P1MinMaxInList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(in);
        List<Long> list = new ArrayList<>();
        int numberCount = 5;
        while (numberCount-- > 0)
            list.add(scanner.nextLong());

        Collections.sort(list);
        int min = 0, max = 0;
        for (int index = 0; index < list.size(); ++index) {
            max += index == 0 ? 0 : list.get(index);
            min += index == list.size() - 1 ? 0 : list.get(index);
        }
        System.out.println(min + " " + max);
    }
}
