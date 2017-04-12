package CompanyCompetetions.Amazon.Interview1;

/**
 * Created by Nikhil on 4/6/2017 4:02 PM.
 */
public class InverseInteger {
    public static void main(String[] args) {
        System.out.println(reverseInteger(1234));
    }

    private static int reverseInteger(int n) {
        int result = 0;
        while (n != 0) {
            result = result * 10 + n % 10;
            n /= 10;
        }
        return result;
    }
}
