package GeeksForGeeks.JavaReview.Interfaces;

/**
 * Created by Nikhil on 1/8/2017 9:05 AM.
 */
interface A{
    int a = 10;
    void fun1();
    default void fun2(){
        System.out.println("In A interface default function 2");
    }
    default void fun3(){
        System.out.println("In A interface default function 3");
    }
}
class B implements A{
    @Override
    public void fun1() {
        System.out.println("In B Fun1");
    }

    @Override
    public void fun2() {
        System.out.println("In B Fun2");
    }

    @Override
    public void fun3() {
        System.out.println("In B Fun3");
        A.super.fun3();                 //NOTICE: INTERFACE.super.fun3()
    }
}
public class DefaultMethodsInInterface {
    public static void main(String[] args) {
        A ab = new B();
        ab.fun2();      // From B, b/c override
        ab.fun3();      //From B b/c override + INTERFACE.super.fun3()
    }
}
