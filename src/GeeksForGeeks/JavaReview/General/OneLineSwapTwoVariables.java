package GeeksForGeeks.JavaReview.General;

/**
 * Created by Nikhil on 1/8/2017 2:10 PM.
 */
public class OneLineSwapTwoVariables {
    public static void main(String[] args) {
        int x = 10;         System.out.println(Integer.toBinaryString(x));
        int y = 20;         System.out.println(Integer.toBinaryString(y));

                            System.out.println(Integer.toBinaryString(x ^ y));
        x = x ^ y ^ (y = x);System.out.println(Integer.toBinaryString(x ^ y ^ (y =x)));
        System.out.println(Integer.toBinaryString(y));

        System.out.println(x  +" "+ y);
    }
}
