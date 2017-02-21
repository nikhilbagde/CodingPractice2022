package ProjectEuler.Set1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Nikhil on 1/29/2017 4:39 AM.
 */
public class P7The100001stPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        final int MAX = 1000007;
        boolean[] isPrime = new boolean[MAX];

        for (int i = 0; i < MAX; i++)  isPrime[i]= true;

        for (int i = 2; i < MAX; i++) {
            if(isPrime[i]){
                for (int j=i+i; j < MAX; j=j+i) {
                    isPrime[j] = false;
                }
            }
        }
        List<Integer> primeList = new ArrayList<>();
        for (int i = 2; i < MAX; i++) {
            if(isPrime[i]) primeList.add(i);
        }


        while(T-- > 0) {
            int N = scanner.nextInt();
            System.out.println("result = " + primeList.get(N-1)); //just get ith valued primed so just store it to arrayList
                                                                    // and use get function to computer ith prime number from start.
        }
    }
}
