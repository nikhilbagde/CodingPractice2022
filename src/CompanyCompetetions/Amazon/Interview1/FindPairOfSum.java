package CompanyCompetetions.Amazon.Interview1;

/**
 * Created by Nikhil on 4/6/2017 6:59 PM.
 */
public class FindPairOfSum {
    public static void main(String[] args) {
        int[] array = {1, 4, 45, 6, 10, -8};
        int sum = 46;
        findPairOfSum(array, sum);

    }

    private static void findPairOfSum(int[] a, int sum) {
        boolean[] result = new boolean[1000];
        for (int i = 0; i < a.length; i++) {
            int temp = sum - a[i];
            if (temp > 0 && result[temp]) {
                System.out.println(a[i] + " " + temp);
            }
            result[Math.abs(a[i])] = true;
        }
    }

}
