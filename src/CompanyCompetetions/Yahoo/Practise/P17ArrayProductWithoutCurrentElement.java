package CompanyCompetetions.Yahoo.Practise;

/**
 * Created by Nikhil on 2/28/2017 12:07 AM.
 */
public class P17ArrayProductWithoutCurrentElement {
    public static void main(String[] args) {
        int[] array = {2, 3, 1, 4, 3, 2};
        int sum = 1;
        for (int i = 0; i < array.length; ++i) {
            sum *= array[i];
        }
        for (int i = 0; i < array.length; ++i) {
            System.out.println("For " + (i + 1) + (i == 0 ? "st = " : (i == 1) ? "nd = " : (i == 2) ? "rd = " : "th = ") + sum / array[i]);
        }
    }
}
