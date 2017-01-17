package GeeksForGeeks.JavaReview.Interfaces;

/**
 * Created by Nikhil on 1/8/2017 9:17 AM.
 */
class G{
    //interface and class can only have 2 access modifiers = 1. Public 2. Default(none)
    //But when interface is inside a class a member, can have all 4 access modifier: public, private, protected, default
    interface H{
        void fun1();
        default void fun2(){
            System.out.println("In H fun2");
        }
        default void fun3(){
            System.out.println("In H fun3");
        }
    }
}
class I implements G.H{
    @Override
    public void fun1() {
        System.out.println("In I implementing Fun1");
    }
    public void fun2(){
        System.out.println("Overriding fun2");
    }
    public void fun3(){
        System.out.println("Overriding fun3 + calling from interface default");
        G.H.super.fun3();       //just for fun from interface
        G.H.super.fun2();       //just for fun from interface
        this.fun1();            //from same classs.
    }

}
public class InterfaceInsideClass {
    public static void main(String[] args) {
        G.H ghi = new I();
        ghi.fun3();
    }
}

