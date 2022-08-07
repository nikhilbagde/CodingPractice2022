package OTT.P6_HackerRank.Implementation.Medium;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
/**
 * Created by nbagde on 8/18/2018.
 */
public class FormingAMagicSquare {
    private static Scanner scanner = new Scanner(System.in);
    static int cost = 0;
    static int [] countArray;
    public static void main(String[] args) {
        int[][]s = new int [3][3];

        input(s);
        computeMagicMatrix(s);

    }
    private static int[][] input(int s[][]){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                s[i][j] = scanner.nextInt();
            }
        }
        return s;
    }

    private static void getCount(int[][]s , int [] countArray){
        int[] a = twoDtoOneD(s);

        //using stream
        IntStream stream = IntStream.of(a);
        HashMap<Integer,List<Integer>> map = stream.mapToObj(c->new Integer((Integer) c)).collect(Collectors.groupingBy(b->b,HashMap::new, Collectors.toList() ));
        //System.out.println(map);

        //count array
        //int [] countArray = new int[10];
        Arrays.fill(countArray,0);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                countArray[s[i][j]]++;
            }
        }
        //System.out.println(Arrays.toString(countArray));

    }
    private static int[] twoDtoOneD(int[][]s){
        int[] a = new int[9];
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                a[count++] = s[i][j];
            }
        }
        return a;
    }
    private static void computeMagicMatrix(int[][]s){
        int count = 0;
        countArray = new int[10];
        getCount(s, countArray);

        while(!hasAllUniqueNumbers(s, countArray)){
            computeRow(s, countArray);

            if(!hasAllUniqueNumbers(s, countArray))
                computeColumn(s, countArray);

            count++;
            if(count>=3) break;
        }
        System.out.println("Cost = " + cost);
        print(s);

    }
    private static void computeRow(int[][]s, int[]countArray){
        for (int i = 0; i < 3; i++) {
            int rowSum = 0, repeating=0;
            int [] storedPosition = new int[2];
            for (int j = 0; j < 3; j++) {
                rowSum+= s[i][j];
                if(countArray[s[i][j]]>1){
                    repeating = Math.max(repeating,s[i][j] );
                    storedPosition[0]=i;
                    storedPosition[1]=j;
                }
            }
            if(rowSum<15 && repeating!=0){
                int diff = 15 - rowSum;
                s [storedPosition[0]] [storedPosition[1]] = repeating+diff;
                cost+= diff;
            }
        }
        getCount(s, countArray);
    }
    private static boolean hasAllUniqueNumbers(int[][]s, int[] countArray){
        for (int i = 1; i < countArray.length; i++) {
            if(countArray[i]>1)
                return false;
        }
        return true;
    }
    private static void computeColumn(int[][]s, int[]countArray){
        for (int i = 0; i < 3; i++) {
            int columnSum = 0, repeating=0;
            int [] storedPosition = new int[2];
            for (int j = 0; j < 3; j++) {
                columnSum+= s[j][i];
                if(countArray[s[j][i]]>1){
                    repeating = Math.max(repeating,s[j][i] );
                    storedPosition[0]=j;
                    storedPosition[1]=i;
                }
            }
            if(columnSum<15 && repeating!=0){
                int diff = 15 - columnSum;
                s [storedPosition[0]] [storedPosition[1]] = repeating+diff;
                cost+= diff;
            }
        }
        getCount(s, countArray);
    }
    private static void print(int[][]s){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print( s[i][j] + " ");
            }
            System.out.println();
        }
    }

}
