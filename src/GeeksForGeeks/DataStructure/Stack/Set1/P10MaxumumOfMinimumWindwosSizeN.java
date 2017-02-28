package GeeksForGeeks.DataStructure.Stack.Set1;

/**
 * Created by Nikhil on 2/25/2017 4:10 PM.
 */
public class P10MaxumumOfMinimumWindwosSizeN {
    public static void main(String[] args) {
        int[] array = {10, 20, 30, 50, 10, 70, 30};
        printMaximumOfMinimumOfWindowSizeN(array);
    }

    /*
    10, 20, 30, 50, 10, 70, 30 N=7
    for windows size from 1 to n.
    for windows size 1 -> 10 , 20, 30, 50, 10, 70, 30 -> MAX = 70
    for windows size 2 -> {10,20}, {20,30}, {30,50}, {50,10}, {10,70}, {70,30} (6)
                            10,        20       30      10      10      30
                             MAX  = 30
    for windows size 3 -> {10,20,30}, {20,30,50}, {30,50,10}, {50,10,70}, {10,70,30} (5)
                            10,        20           10              10          10
                             MAX  = 30

     */
    private static void printMaximumOfMinimumOfWindowSizeN(int[] array) {
        for (int k = 1; k <= array.length; ++k) {
            int maxOfMin = array[0];
            for (int i = 0; i <= array.length - k; ++i) {
                int min = array[i];
                for (int j = 1; j < k; ++j) {
                    if (array[j + i] < min)
                        min = array[min + i];
                    if (min > maxOfMin)
                        maxOfMin = min;
                }
            }
            System.out.print(maxOfMin + " ");
        }
    }
}
