package GeeksForGeeks.JavaReview.Interfaces;

/**
 * Created by Nikhil on 1/8/2017 9:11 AM.
 */
interface C{
    default void fun1(){
        System.out.println("In C fun1");
    }
}
interface D{
    default void fun1(){
        System.out.println("In D fun1");
    }
}
class E implements C, D{
    public void fun1(){         //must add public to override.
        System.out.println("In E fun1 Overriding");
        C.super.fun1();         //which method to call SIMPLE
        D.super.fun1();         //INTERFACE_NAME.super.functionName()
    }
}
public class MultipleImpleInterfaceDefaultCase {
    public static void main(String[] args) {
        C ce = new E();     //same
        ce.fun1();

        D de = new E();     //same
        de.fun1();

        E e = new E();
        e.fun1();
    }
}
