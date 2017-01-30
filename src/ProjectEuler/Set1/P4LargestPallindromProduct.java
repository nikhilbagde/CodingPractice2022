package ProjectEuler.Set1;

import java.util.Scanner;

/**
 * Created by Nikhil on 1/29/2017 5:55 AM.
 */
public class P4LargestPallindromProduct {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while(T-- >0){
            int N = scanner.nextInt();
            long result = -1;
            for (int i = 100; i <= 999; i++) {
                for (int j = 100; j < i; j++) {
                    int mul = i * j;
                    if(pallindrom(mul)){
                        result = Math.max(result, mul);
                    }
                }
            }
            System.out.println("result = " + result);
        }
    }
    private static boolean pallindrom(int n){
        String temp = String.valueOf(n);
        return temp.equals(new StringBuilder(temp).reverse().toString());
    }
}
