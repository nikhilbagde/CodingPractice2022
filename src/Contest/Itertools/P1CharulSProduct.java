package Contest.Itertools;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import static java.lang.System.in;

/**
 * Created by Nikhil on 2/14/2017 9:48 AM.
 * Charul likes to play with list of numbers.
 * She gives you two list of numbers c1=(a1,a2,…,an) and c2=(b1,b2,…,bn) .
 * Product of these lists is a single number ,calculated as a1b1+a2b2+…+anbn .
 * She allows you to permute the elements of each list as you wish .
 * You have to choose two permutations such that the product of your two new lists is the smallest possible,
 * and output that minimum product.
 * Input Format
 * The first line contains integer number n.
 * The next two lines contain n integers each,
 * giving the elements of c1 and c2 respectively  Constraints
 */
public class P1CharulSProduct {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(in);
        int T = scanner.nextInt();
        long[] array1 = new long[T];
        long[] array2 = new long[T];

        for (int i = 0; i < T; ++i) {
            array1[i] = scanner.nextInt();
        }
        for (int i = 0; i < T; ++i) {
            array2[i] = scanner.nextInt();
        }

        /*System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));*/

        Long[] _array1 = new Long[array1.length];
        Long[] _array2 = new Long[array2.length];
        for (int i = 0; i < T; ++i) {
            _array1[i] = array1[i];
        }
        for (int i = 0; i < T; ++i) {
            _array2[i] = array2[i];
        }
        Arrays.sort(_array1, Collections.reverseOrder());
        Arrays.sort(_array2);
        long minProduct = 0;
        for (int i = 0; i < T; ++i) {
            minProduct += _array1[i] * _array2[T - 1 - i];
        }
        System.out.println(minProduct);
    }
}
