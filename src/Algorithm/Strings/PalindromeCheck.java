package Algorithm.Strings;

/**
 * Created by Nikhil on 1/13/2017 3:53 AM.
 */
public class PalindromeCheck {
    public static void main(String[] args) {
        checkPalindrome("String","gnirtS");
    }
    private static void checkPalindrome(String a, String b){
        System.out.println(new StringBuilder(a.toLowerCase()).reverse().toString().equals(b.toLowerCase()));
    }
}
