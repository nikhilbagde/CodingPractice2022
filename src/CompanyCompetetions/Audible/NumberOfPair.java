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
}
