package GeeksForGeeks.JavaReview.Inheritance;

/**
 * Created by Nikhil on 1/8/2017 7:32 AM.
 */


class C{
    static void function1(){
        System.out.println("C Static function1");
    }
}
class D extends C{
    static void function1(){
        System.out.println("D Static function1");
    }
}
public class StaticShadowing {
    public static void main(String[] args) {
        C cd = new D();
        C.function1();
        D.function1();
    }
}