package OTT.P7_GeeksForGeeks.DataStructure.Arrays.Set1;

/**
 * Created by Nikhil on 2/19/2017 3:30 PM.
 * Let Array be {1, 4, 45, 6, 10, -8} and sum to find be 16
 */
public class P1PairOfSumInArray {
    public static void main(String[] args) {
        int[] array = {1, 4, 45, 6, 10, -8};
        int sum = 16;
        findPairOfSum(array, sum);
        findPairOfSum1(array, sum);
    }

    //O(N)
    private static void findPairOfSum1(int[] array, int sum) {
        for (int first = 0; first < array.length; ++first) {
            for (int second = first + 1; second < array.length; ++second) {
                if (first + second == sum) System.out.println(first + " + " + second + " = " + sum);
            }
        }
    }
    private static void findPairOfSum(int[] array, int sum) {
        int[] bitArray = new int[1000];
        for (int i = 0; i < array.length; ++i) {
            int temp = sum - array[i];
            if (temp >= 0 && bitArray[temp] == 1) {
                System.out.println(array[i] + " " + temp);
            }
            bitArray[array[i]] = 1;
        }

    }
}
