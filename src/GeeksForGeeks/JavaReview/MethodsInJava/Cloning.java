package GeeksForGeeks.JavaReview.MethodsInJava;

/**
 * Created by Nikhil on 1/8/2017 3:29 AM.
 */
public class Cloning {
    public static void main(String[] args) throws CloneNotSupportedException {
        B b1 = new B();
        B b2 = (B) b1.clone();

        b2.aa = 101;
        System.out.println("B1 = " + b1.aa + " B2 " + b2.aa);

        b1.a.anInt = 11;
        System.out.println("B1 = " + b1.a.anInt + " B2 " + b2.a.anInt);

        b2.a.anInt = 12;
        System.out.println("B1 = " + b1.a.anInt + " B2 " + b2.a.anInt);

    }
}
class A{
    int anInt = 10;
    int b = 20;

}
class B implements Cloneable{
    int aa = 100;
    int bb = 200;

    A a = new A();
    public Object clone() throws CloneNotSupportedException{
        B b = (B) super.clone();
        b.a = new A();
        return b;
    }
}
