package GeeksForGeeks.JavaReview.StaticKeyword;

/**
 * Created by Nikhil on 1/8/2017 1:45 AM.
 */
public class OverrridingStaticMethds {
    public static void main(String[] args) {
        B1 objB1 = new B1();
        objB1.print();
    }
}
class A1{
    A1(){

    }
    A1(int a){
        a++;
        System.out.println(a);
    }
    public void print(){
        System.out.println("In A1");
    }
    public static void function1(){
        System.out.println("In A1 Static method");
    }
}
class B1 extends A1{
    public void print(){
        super.print();
        System.out.println("In B1 Print");
    }
    public static void function1(){
        //super.function1();
        System.out.println("In B1 static method");
    }
}


