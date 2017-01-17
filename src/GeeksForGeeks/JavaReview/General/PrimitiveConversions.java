package GeeksForGeeks.JavaReview.General;

/**
 * Created by Nikhil on 1/9/2017 8:27 AM.
 */
public class PrimitiveConversions {
    public static void main(String[] args) {
        String name = "name";
        int a = Integer.valueOf(name);
        int a1 = Integer.parseInt(name);
        System.out.println(a);

        char [] chars = {'a','b','c'};
        String string1 = chars.toString();
    }
}
