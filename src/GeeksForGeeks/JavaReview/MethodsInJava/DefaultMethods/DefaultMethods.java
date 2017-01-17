package GeeksForGeeks.JavaReview.MethodsInJava.DefaultMethods;

/**
 * Created by Nikhil on 1/8/2017 4:02 AM.
 */

public class DefaultMethods implements DeafultTestInterface, DefaultMethodInterface2{
    @Override
    public void function1() {
        System.out.println("From Default Test Interface 1");
    }

    @Override
    public void function3() {
        System.out.println("From Defualy Test Interface 2");
    }

    public void function2(){
        //which function2 call from these two interface ?
        // as both these interfaces have function2 in it.

        DeafultTestInterface.super.function2();
        DefaultMethodInterface2.super.function2();
    }

    public static void main(String[] args) {
        DefaultMethods obj = new DefaultMethods();
        obj.function2();
    }
}
