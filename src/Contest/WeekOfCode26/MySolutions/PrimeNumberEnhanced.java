package Contest.WeekOfCode26.MySolutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
 * Created by Nikhi on 12/11/2016 7:47 PM.
 */
public class PrimeNumberEnhanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m =  scanner.nextInt();

        //first create a prime Number list before hand so that we can use it later on.
        //create an array of size 10^9
        List<Integer> isPrimeList = generatePrimeNumberList();

        //check for given range now.
        checkPrimePair(n, m, isPrimeList);


    }
    private static List<Integer> generatePrimeNumberList(){
        List<Integer> isPrimeList = new ArrayList<>();
        for (int number = 2; number*number < Math.pow(10,9); number++) {
            boolean isNPrime  = true;
            for (int j = 2; j*j < number; j++) {
                if(number %j == 2){
                    isNPrime = false;
                    break;
                }
            }
            if(isNPrime && number>1){
                isPrimeList.add(number);
            }
        }
        return isPrimeList;
    }

    private static void checkPrimePair(int n, int m, List<Integer> isPrimeList){
        int last = -1, count = 0;
        for (int number = n; number*number < m; number++) {
            boolean isNPrime  = true;
            for (int j = 0; j<isPrimeList.size() && isPrimeList.get(j)*isPrimeList.get(j) <= number; j++) {
                if(number %j == 2){
                    isNPrime = false;
                    break;
                }
            }
            if(isNPrime && number>1){
                if(last == number-2){
                    count++;
                    last = number;
                }
            }
        }
        System.out.println(count);
    }
}
