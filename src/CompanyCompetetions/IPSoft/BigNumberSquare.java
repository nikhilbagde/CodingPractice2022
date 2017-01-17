package CompanyCompetetions.IPSoft;

import java.math.BigInteger;

/**
 * Created by Nikhi on 11/18/2016.
 */
public class BigNumberSquare {
    public static void main(String[] args) {
        //1. Given a big number which cant fit in any one literal
        // Is given in string formate in reverse order.
        //Square that number and then put back on string in reverse order.
        String inputNumber = "0123456778999999999";
        inputNumber = new StringBuffer(inputNumber).reverse().toString();

        BigInteger big = new BigInteger(inputNumber);
        big = big.pow(2);
        inputNumber = new StringBuilder(big.toString()).reverse().toString();
        System.out.println(inputNumber);
    }
}
