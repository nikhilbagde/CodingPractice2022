package LeetCode.Medium;

/**
 * Created by Nikhil on 4/1/2017 8:50 PM.
 */
public class P67AddBinary {
    public static void main(String[] args) {

    }

    private static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carray = 0;

        while (j >= 0 || i >= 0) {
            int sum = carray;
            if (j >= 0) sum += b.charAt(j--) - '0';
            if (i >= 0) sum += a.charAt(i--) - '0';
            sb.append(sum % 2);
            carray = sum / 2;
        }
        if (carray != 0) sb.append(carray);
        return sb.reverse().toString();
    }

}
