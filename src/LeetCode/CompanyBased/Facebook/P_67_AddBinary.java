package LeetCode.CompanyBased.Facebook;

/**
 * @author Nikhil Bagde
 * @package LeetCode.CompanyBased.Facebook
 * @created 04/23/2021
 * @date 4/23/2021- 12:20 AM
 * @project HackerRank2017
 **/
public class P_67_AddBinary {
    public static void main(String[] args) {

        addBinary("11","1");

    }

    public static String addBinary(String a, String b) {

        StringBuilder sb = new StringBuilder();

        int i = a.length()-1,  j = b.length()-1;
        int sum = 0, carry = 0;
        while(i>=0 || j>=0){
            sum  = carry;

            if(i>=0) sum += Character.getNumericValue(a.charAt(i--));
            if(j>=0) sum += Character.getNumericValue(b.charAt(j--));

            carry = sum / 2;             // REMEMBER: This should be calculate before sum %= 2;
            sum = sum %2;

            sb.insert(0, sum);
        }

        if(carry>0){
            sb.insert(0,carry);
        }
        System.out.println("sb.toString() = " + sb.toString());
        return sb.toString();

    }
}
