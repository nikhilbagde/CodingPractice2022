package ProjectEuler.Set2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Nikhil on 2/5/2017 1:45 PM
 * The numbers  to  written out in words are
 * First character of each word will be capital letter for example:is
 * Given a number, you have to write it in words.
 * 0<=N<10^12
 */
public class P17NumberToWords {
    static String [] ones = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    static String [] elevenToTwenty = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen", "Twenty"};
    static String [] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    static String [] mul10 = {"Hundred", "Thousand", "Million", "Billion", "Trillion"};

    public static void main(String[] args) {
        //test
        for (int i = 0; i < 999; i++) {
            System.out.println(last3Digits(i));
        }

        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            long N = scanner.nextLong();
            if(N ==0) System.out.println("Zero");
            else {
                int group = 0;
                List<String> parts = new ArrayList<>();
                for (; N > 0 ; ++group) {
                    long n = N % 1000;
                    N /= 1000;
                    if(n>0){
                        String part = "";
                        if(group == 0)
                            part = last3Digits(n);
                        else
                            part = last3Digits(n) + " " + mul10[group];
                        parts.add(part);
                    }
                }
                String result = "";
                for (int i = 0; i < parts.size(); i++) {        //to print it in reverse order as I am storing it in reverse
                    if(i>0) result = result + " ";
                    result = result + parts.get(parts.size() - 1 - i);
                }
                System.out.println(result);
            }
        }
    }

    private static String last3Digits(long n){
        // 0 to 999
        long hundreth = n /100;
        long lastTwo = n % 100;

        if(hundreth == 0){          //0 to 99
            return last2Digits(lastTwo);
        }else{ //100 to 999
            if(lastTwo == 0)        //100 200 300 400
                return ones[(int) hundreth] + " Hundred";
            else                    //101-199 201-299 301-399
                return ones[(int) hundreth] + " Hundred " + last2Digits(lastTwo);
        }
    }
    private static String last2Digits(long n){
        //0 to 99
        if(n <10) return ones[(int) n];
        if(n<=20) return elevenToTwenty[(int) n - 10];
        long tenth = n / 10;
        long unith = n % 10;
        if(unith == 0) return tens[(int) tenth];
        else return tens[(int) tenth] + " " + ones[(int) unith];
    }
}
