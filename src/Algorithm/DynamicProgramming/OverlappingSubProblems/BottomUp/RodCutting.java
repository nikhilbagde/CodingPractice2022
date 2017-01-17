package Algorithm.DynamicProgramming.OverlappingSubProblems.BottomUp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Nikhil on 1/5/2017 12:28 AM.
 * Step 1: getInput() - provide length of rod and all profits of respective cuts.
 * Step 2: To find max profit,
 *          1. Create two arrays one for keeping track of optimal (maximum) profit for each cut
 *              and another array say rodPieces( where we cut the rod)
 *          2. For each length given,
 *                  - initialize maxProfit to some negative value
 *                  - Then consider all possible cuts from start index to that length.
 *                  - check if what is max profit, (is it without cut or with some cut) ?
 *                      - compare this profit with maxProfit currently we have for this length.
 *                      - plus store value when we find maxProfit, to DS of RocPieces (here we got that cut)
 *                   - store that maxProfit to DS of Optimal profit for that length to use it in future.
 * Step 3: Print Path,
 *          - Use RodPieces DS,
 *             - Start with last value of DS and print it.
 *             - Then decrease that length from given length of Rod. (If there was no Cut it will directly print length of Rod which was given)
 *             - Keep doing this till this length value is not zero.
 */
public class RodCutting {
    private int [] profit;
    private int maxLength;
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        RodCutting rodCutting = new RodCutting();
        rodCutting.getInput();
        //rodCutting.findMaximumProfit();
        rodCutting.findMaximumProfitWithPath();

    }
    private void getInput(){
        System.out.println("Please provide Total length of the Rod ");
        maxLength = scanner.nextInt();
        profit = new int[maxLength+1];
        System.out.println("Please provide Profit respective rod lengths:");
        for (int length = 0; length < profit.length -1; length++) {
            profit[length] = scanner.nextInt();
        }
    }
    /*
    MaxProfit(n) = (profit 0 + profit n) or (profit 1 + profit n-1) or (profit of 2 + profit n-2)..
                       ... or (profit n-1 + profit 1).
                        maximum of all above. and current maximum considered.
     */
    private void findMaximumProfit(){
        int[] optimalProfit = new int[profit.length];
        optimalProfit[0] = 0;

        for (int length = 1; length <= maxLength ; length++) {
            int maximumProfit = Integer.MIN_VALUE;
            for (int start = 0; start < length; start++) {
                int end = length - start - 1;
                maximumProfit = Math.max(maximumProfit , (profit[start] + optimalProfit[end]) );
                logger(length,start, end, maximumProfit, optimalProfit);
            }
            System.out.println();
            optimalProfit[length] = maximumProfit;
        }
        System.out.print("Maximum Profit could obtained = ");
        System.out.println(optimalProfit[optimalProfit.length-1]);
    }
    private void logger(int length, int startOfLength, int endOfLength, int maximumProfit, int[] optimalProfit){
        System.out.println("Length = " + length + "\tPossibilities = " + startOfLength + "\tMaximum Profit = " + maximumProfit);
        System.out.println("Profit [" + startOfLength + "] = " + profit[startOfLength] + "\toptimalProfit[" + endOfLength + "] = " + optimalProfit[endOfLength]);
        System.out.println("Profit:\t" + Arrays.toString(profit));
        System.out.println("Optimal Profit\t" + Arrays.toString(optimalProfit));

    }

    private void findMaximumProfitWithPath(){
        int[] optimalProfit = new int[profit.length];
        int[] cutRodPiecesValues = new int[profit.length];
        optimalProfit[0] = 0;

        for (int length = 1; length <= maxLength ; length++) {
            int maximumProfit = Integer.MIN_VALUE;
            for (int startOfLength = 0; startOfLength < length; startOfLength++) {
                int endOfLength = length - startOfLength - 1;
                if(maximumProfit < (profit[startOfLength] + optimalProfit[endOfLength]) ) {
                    maximumProfit = profit[startOfLength] + optimalProfit[endOfLength];
                    cutRodPiecesValues[length] = startOfLength + 1;
                    //logger(length, startOfLength, endOfLength, maximumProfit, optimalProfit);
                }
            }
            //System.out.println();
            optimalProfit[length] = maximumProfit;
        }
        System.out.print("Maximum Profit could obtained = ");
        System.out.println(optimalProfit[optimalProfit.length-1]);
        printPath(cutRodPiecesValues);
    }
    private void printPath(int[] rodValues){
        int n = rodValues.length-1;
        System.out.print("All Pieces of Rod : ");
        while(n>0){
            System.out.print(rodValues[n] + " + ");
            n= n-rodValues[n];
        }
        System.out.println(" = " + (rodValues.length-1));
    }

}

/*
Test
10
1 5 8 9 10 17 17 20 24 30

7
1 5 8 9 10 17 17

 */