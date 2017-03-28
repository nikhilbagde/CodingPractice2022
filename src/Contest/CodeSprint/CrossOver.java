package Contest.CodeSprint;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Nikhil on 3/25/2017 11:02 AM.
 * https://www.hackerrank.com/contests/nse-isb-codesprint/challenges/crossover
 */
public class CrossOver {
    private static int[] stocks;
    private static double[] stockAve;
    private static DecimalFormat df = new DecimalFormat("00.00");

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        /*int n = in.nextInt();       //total stocks
        tempInput();
        stocks = new int[n];       //stocks
        for(int p_i=0; p_i < n; p_i++){
            stocks[p_i] = in.nextInt();
        }*/

        tempInput();

        stockAve = new double[stocks.length];
        stockAve[0] = stocks[0];


        for (int i = 1; i < stockAve.length; ++i) {
            stockAve[i] = Double.parseDouble(df.format((stockAve[i - 1] + stocks[i])));
        }
        System.out.println(Arrays.toString(stockAve));
        checkCrossOver();

        System.out.println("Again");
        System.out.print(" ");
        printArray(stockAve);

    }

    private static void printArray(double[] a) {
        for (int i = 0; i < a.length; ++i) {
            //  System.out.printf("%3.3d, ", a[i]);
            System.out.printf("%-3.1f, ", a[i]);
        }
    }

    private static void checkCrossOver() {
        if (stockAve.length < 300) return;
        for (int i = 300; i < stockAve.length; ++i) {
            //if(stockAve[])
        }
        getSTMA();
    }

    private static void getLTMA() {
        if (stockAve.length < 300) return;

    }

    private static void getSTMA() {
        if (stockAve.length < 60) return;
        double[] STMA = new double[stocks.length - 60 + 1];
        for (int i = 60; i < stockAve.length; ++i) {
            STMA[i - 60] = Double.parseDouble(df.format((stockAve[i] - stockAve[i - 60]) / 60));
        }
        System.out.println(Arrays.toString(STMA));
        System.out.print(" ");
        printArray(STMA);
    }

    private static void tempInput() {
        stocks = new int[400];
        for (int i = 0; i < 400; ++i) {
            stocks[i] = i + 1;
        }
        System.out.println("Input");
        System.out.println(Arrays.toString(stocks));
    }
}
/*
Input:
10
4 5 6 4 5 7 3 4 5 6
400
4 5 6 4 5 7 3 4 5 6 4 5 6 4 5 7 3 4 5 6 4 5 6 4 5 7 3 4 5 6 4 5 6 4 5 7 3 4 5 6 4 5 6 4 5 7 3 4 5 6 4 5 6 4 5 7 3 4 5 6 4 5 6 4 5 7 3 4 5 6 4 5 6 4 5 7 3 4 5 6 4 5 6 4 5 7 3 4 5 6 4 5 6 4 5 7 3 4 5 6 4 5 6 4 5 7 3 4 5 6 4 5 6 4 5 7 3 4 5 6 4 5 6 4 5 7 3 4 5 6 4 5 6 4 5 7 3 4 5 6 4 5 6 4 5 7 3 4 5 6 4 5 6 4 5 7 3 4 5 6 4 5 6 4 5 7 3 4 5 6 4 5 6 4 5 7 3 4 5 6 4 5 6 4 5 7 3 4 5 6 4 5 6 4 5 7 3 4 5 6 4 5 6 4 5 7 3 4 5 6 4 5 6 4 5 7 3 4 5 6 4 5 6 4 5 7 3 4 5 6 4 5 6 4 5 7 3 4 5 6 4 5 6 4 5 7 3 4 5 6 4 5 6 4 5 7 3 4 5 6 4 5 6 4 5 7 3 4 5 6 4 5 6 4 5 7 3 4 5 6 4 5 6 4 5 7 3 4 5 6 4 5 6 4 5 7 3 4 5 6 4 5 6 4 5 7 3 4 5 6 4 5 6 4 5 7 3 4 5 6 4 5 6 4 5 7 3 4 5 6 4 5 6 4 5 7 3 4 5 6 4 5 6 4 5 7 3 4 5 6 4 5 6 4 5 7 3 4 5 6 4 5 6 4 5 7 3 4 5 6 4 5 6 4 5 7 3 4 5 6 4 5 6 4 5 7 3 4 5 6 4 5 6 4 5 7 3 4 5 6

OutPut:
6 6.0 5.4
7 5.0 5.0
8 3.5 4.6
10 5.5 5.0
 */
/*
This problem is all about share prices and moving averages!

You are given  integers , where  denotes the price of the stock at day .

Then, we define:


 := the average price of the stock over days , so it is an average measured at day  over the most recent  days. This value is called Short term moving average.

 := the average price of the stock over days , so it is an average measured at day  over the most recent  days. This value is called Long term moving average.
Notice that  is defined for , while  is defined for .

In this problem, values of  and  are rounded to exactly 2 decimal points, so for example  is rounded to , while  is rounded to .

Now, let's say that a crossover occurs at day  if and only if both  and  are defined at days  and , and either one of the below conditions is fulfilled:


 and
 and
 and
Given the stock prices across  days, detect all crossovers. For each crossover, print the day at which it occurred along with the values of  and  for this day.

Input Format

The first line of input contains a single integer  (the number of days).

The second line of input contains  space-separated integers  denoting the stock prices for each day.

Constraints

Output Format

For each occurrence of a crossover, print three space-separated values for the date at which it occurred, the value of  for this date, and the value of  for this date. Print each crossover on its own line and order the crossovers in order from the smallest date to the largest. The values of both  and  must be correct to  decimal places.

Example

For the purpose of explanation, let's assume that  is measured across  days instead of , and that  is measured across  days instead of . This will be our input for  days:

10
4 5 6 4 5 7 3 4 5 6
The first day at which a crossover can be measured is day . Let's write down the values of  and  for all days starting from day :













From the above values it can be deduced that crossovers occur only at days: , and , so our output will be the following:

6 6.0 5.4
7 5.0 5.0
8 3.5 4.6
10 5.5 5.0

 */
