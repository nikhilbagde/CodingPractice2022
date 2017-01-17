package Algorithm.Search;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Nikhi on 9/23/2016.
 * https://www.hackerrank.com/challenges/pairs
 * Given  integers, count the number of pairs of N integers whose difference is K.
 */
public class Pairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // total number of integers
        int K = sc.nextInt(); // fixed difference
        int [] a = new int[N];
        for(int i = 0; i<N ; i++){
            a[i] = sc.nextInt();
        }
        int counter = 0;
        if(N<= (int)Math.pow(10,5) && K> 0 && K < (int)Math.pow(10,9)){

            /*for(int i =0; i<N-1 ; i++){  //iterate i from 0 to 3 < [n=4 (N-1)] (1 5 3 4 2 )
                for(int j = i+1; j<N ; j++){ //iterate J from i to N-1 (means 4)
                    if(Math.abs(a[i]-a[j])==K){
                        counter++;
                    }
                }
            }*/

            //Following approach works only on sorted array
            Arrays.sort(a);
            int i =0, j=1; //, counter = 0;
            while(j<N){
                int diff = a[j] - a[i];
                //idea is to take different
                //then check difference with K value
                if(diff == K){  // if diffrence of max - min == k means good counter ++
                    counter++;  // also j++ and hence all elements are unique so i++ also
                    j++;
                }else if(diff > K){ //if diff is greater than k, meanning max - min = diff < k  5 - 1= 4, 4>2, means ,
                    // we need to pull up min value, just increment i
                    i++;
                }else if(diff < K){ //pull up the max value  2 -1 = 1 < 2 make 2-> 3, j++
                    j++;
                }
            }

        }

        System.out.print(counter);

    }
}
