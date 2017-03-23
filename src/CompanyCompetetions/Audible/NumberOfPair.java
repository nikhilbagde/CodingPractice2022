package CompanyCompetetions.Audible;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Nikhi on 12/1/2016.
 */
public class NumberOfPair {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        long k = in.nextInt();
        numberOfPairs(a, k);
        System.out.println(numberOfPairs2(a, k));

    }
    static int numberOfPairs(int[] a, long k) {
        int counter = 0;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < a.length ; i++){
            for(int j= 0; j< a.length; j++){
                if(i!=j && (a[i]+a[j])  == k){
                    counter++;
                    set.add(i);
                    set.add(j);

                }
            }
        }
        return set.size()/2;
    }

    //O(n)
    private static int findMax(int[] a) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; ++i) {
            max = a[i] > max ? a[i] : max;
        }
        return max;
    }

    private static int numberOfPairs2(int[] a, long k) {
        boolean[] sum = new boolean[(int) k + 1];
        int count = 0;
        for (int i = 0; i < a.length; ++i) {
            int dif = (int) k - a[i];
            if (sum[dif]) {
                count++;
            }
            sum[a[i]] = true;
        }
        return count;
    }
}
/*  6 elements from 1 to 9, k = 47
6
1
3
46
1
3
9
47
 */