package Algorithm.Strings;

import java.util.regex.Pattern;

/**
 * Created by Nikhil on 1/12/2017 9:36 PM.
 */
public class CheckStringIsANumber {
    public static void main(String[] args) {
        checkStringANumber1("12.34");
    }
    private static void checkStringANumber1(String a){
        Pattern pattern = Pattern.compile(".*\\D.*");       //string without digits
        Pattern pattern2 = Pattern.compile(".*[^0-9].*");   //string without number
        Pattern pattern3 = Pattern.compile("\\d{6}");   //6 digit string

        System.out.println(pattern.matcher(a).matches());
        System.out.println(pattern2.matcher(a).matches());
        System.out.println(pattern3.matcher("123456").matches());
    }
}
