package ProjectEuler.Set3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;

/**
 * Created by Nikhil on 2/6/2017 4:54 AM.
 * N = factors sum = N perfect number.
 * deficient if N's factor sum < N
 * abundant if N's factor sum > N
 */
public class P23NonAbundantSums {
    private static final int MAX = 28123;
    private static int[] isAbundant;
    public static void main(String[] args) throws IOException {
        isAbundant = new int[MAX];
        List<Integer> abundant = new ArrayList<>();

        //sum of all factors from 1 to MAX
        for (int numbers = 1; numbers < MAX; numbers++) {
            isAbundant[numbers] = sumOfFactors(numbers) > numbers ? 1 : 0;      //1 = abundant | 0 = not abundant
            if (sumOfFactors(numbers) > numbers) abundant.add(numbers);
        }

        //Test for 12 -> should give 16;
        //System.out.println(sumOfFactors(12));

        //System.out.println(abundant.size());

        /*for (int i = 0; i < MAX; i++) {
            System.out.println(i + " " + (isAbundant[i]==1? "YES" : "NO"));
        }*/
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        int T = parseInt(reader.readLine());
        while (T-- > 0) {
            int N = parseInt(reader.readLine());
            if (N > 28123) {
                System.out.println("YES");
            } else {
                boolean condition = false;
                for (int i = 0; i < abundant.size() && abundant.get(i) < N; i++) {
                    int otherNumber = N - abundant.get(i);       //as 1st abundant No + 2nd abundant No = N
                    if (isAbundant[otherNumber] == 1) {           // found other such number which is also abundant return true.
                        condition = true;
                        break;
                    }
                }
                System.out.println(condition ? "YES" : "NO");
            }
            /*int sum = 0;
            boolean condition = false;
            for (int i = 1; i < N; i++) {
                if(isAbundant[i]==1){
                    sum += i;
                }
                if(sum == N) condition = true;
            }
            out.println(condition? "YES":"NO");*/
        }
    }

    private static int sumOfFactors(int number) {
        int sum = 1;
        for (int factor = 2; factor * factor < number; factor++) {
            if (number % factor == 0) {
                sum += factor + number / factor;
            }
            if (factor * factor == number) sum += number;
        }
        return sum;
    }
}
