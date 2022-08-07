package LeetCode.Medium;

/**
 * Created by Nikhil on 4/2/2017 8:10 PM.
 */
public class P413ArithmaticSlices {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        System.out.println(numberOfArithmeticSlices(a));
        System.out.println(numberOfArithmeticSlices2(a));
    }

    private static int numberOfArithmeticSlices(int[] a) {
        int result = 0;
        int[] temp = new int[a.length];
        //0 1 2 3
        //1 2 3 4
        for (int i = 1; i < a.length; i++) {
            temp[i - 1] = a[i] - a[i - 1];
        }
        System.out.println(java.util.Arrays.toString(temp));
        int count = 0, total = 0;
        for (int i = 0; i < temp.length - 3; i++) {
            if (temp[i] == temp[i + 1] && temp[i + 1] == temp[i + 2]) {
                count++;
                total += count;
            } else {
                count = 0;
            }

        }
        return total;
    }

    private static int numberOfArithmeticSlices2(int[] a) {
        int count = 0, total = 0;
        for (int i = 2; i < a.length; i++) {
            if (Math.abs(a[i] - a[i - 1]) == Math.abs(a[i - 1] - a[i - 2])) {
                ++count;
                total += count;
            } else {
                count = 0;
            }
        }
        return total;
    }
}
