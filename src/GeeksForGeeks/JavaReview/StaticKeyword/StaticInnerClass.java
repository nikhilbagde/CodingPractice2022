package GeeksForGeeks.JavaReview.StaticKeyword;

/**
 * Created by Nikhil on 1/8/2017 1:32 AM.
 */
class A {
    int anInt = 10;
    static int anInt1 = 20;

    public void function1(){

    }
    public static void function2(){

    }

    public class B{            //inner class
        //can access static and not static variable and methods.
        public void function3(){
            System.out.println(anInt + " " + anInt1 );
            function1();
            function2();
        }
    }
    public static class C{     //static inner class
        public void function4(){
            System.out.println(anInt1);
            function2();
        }
    }
}

public class StaticInnerClass{
    public static void main(String[] args) {
        A.B objb = new A().new B();     //not static class object
        A.C objc = new A.C();
    }
}