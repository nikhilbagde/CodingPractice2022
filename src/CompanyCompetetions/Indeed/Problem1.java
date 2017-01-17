package CompanyCompetetions.Indeed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Nikhi on 12/11/2016 10:31 AM.
 */
public class Problem1 {
    public static void main(String[] args) {
        String [] a = {"3 9"};
        getMinimumUniqueSum(a);
    }
    private static int[] getMinimumUniqueSum(String[] arr) {
        int[] ret = new int[arr.length];
        for ( String pair: arr ) {
            //3 9
            int counter = 0;
            String[] array = pair.split("\\s+");
            int[] arrayInt = new int[array.length];
            for (int i = 0; i < array.length; i++) {
                arrayInt[i] = Integer.parseInt(array[i]);
            }

            int index = 0;
            int from = arrayInt[0];
            int to = arrayInt[1];
            //Converting primitive int array to List..
            List<Integer> list = Arrays.stream(arrayInt).boxed().collect(Collectors.toList());
            for (int i = from; i <= to; i++) {
                int sqr = i;

                if (sqr * sqr == arrayInt[i-from]) {
                    ret[index++] = sqr;
                    counter++;
                }
            }
        }
        return ret;
    }

}
