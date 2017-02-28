package GeeksForGeeks.DataStructure.Arrays.Set2;

/**
 * Created by Nikhil on 2/27/2017 7:45 PM.
 * Maximum sum such that no two elements are adjacent
 */
public class P12MaximumCountineousSumWithNoAdjacent {
    public static void main(String[] args) {
        int[] array = {5, 5, 10, 100, 10, 5};
        maxConSum(array);       //expected 110

        int[] array1 = {1, 2, 3};
        maxConSum(array1);      //expected 4

        int[] array2 = {1, 20, 3};
        maxConSum(array2);      //expected 20
    }

    //Kanode algorithm. Iterate one by one, and keep track of maxSoFar and maxTillNow.
    //Update maxSoFar only when maxTillNow > maxSoFar.
    private static void maxConSum(int[] array) {
        int maxSoFarEven = 0, maxTillNowEven = 0;
        int maxSoFarOdd = 0, maxTillNowOdd = 0;
        for (int i = 0; i < array.length; ++i) {
            if ((i & 1) == 1) {//odd
                maxSoFarOdd = maxSoFarOdd + array[i];
                if (maxSoFarOdd < 0) maxSoFarOdd = 0;
                if (maxSoFarOdd > maxTillNowOdd) maxTillNowOdd = maxSoFarOdd;
            } else if ((i & 1) == 0) {
                maxSoFarEven = maxSoFarEven + array[i];
                if (maxSoFarEven < 0) maxSoFarEven = 0;
                if (maxSoFarEven > maxTillNowEven) maxTillNowEven = maxSoFarEven;
            }
        }
        System.out.println("maxSoFar = " + (maxTillNowOdd > maxTillNowEven ? maxTillNowOdd : maxTillNowEven));
    }
}
