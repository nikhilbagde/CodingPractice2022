package Java.RandomTest;

/**
 * Created by Nikhil on 1/4/2017 5:16 AM.
 */
public class IntegerTest {
    public static void main(String[] args) {
        int x = -1;
        x = x >>> 0;
        System.out.println(x);
        /*B.*/	x = x >> 32;
        System.out.println(x);
        /*C.*/	x = x >>> 1;
        System.out.println(x);
        /*D.*/	x = x >> 1;
        System.out.println(x);
        /*E.*/	x = x >>> 32;
        System.out.println(x);

    }
}
