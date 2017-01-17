package Java.RandomTest;

/**
 * Created by Nikhil on 1/4/2017 3:07 AM.
 */
public class Problem7 {
    public static void main(String[] args) {
        String str1 = "My String";
        String str2 = new String ("My String");
        /*A.*/
        System.out.println(str1.equals(str2));
        /*B.*/
        System.out.println(str1.matches(str2));
        /*C.*/	//String.parse(str1) == str2
        /*D.*/
        System.out.println(str1.hashCode() == str2.hashCode());
        /*E.*/
        System.out.println(str1 == str2);
    }
}
