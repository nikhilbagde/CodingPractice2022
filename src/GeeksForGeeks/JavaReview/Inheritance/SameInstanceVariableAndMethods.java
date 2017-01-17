package GeeksForGeeks.JavaReview.Inheritance;

/**
 * Created by Nikhil on 1/8/2017 8:10 AM.
 */
class I{
    int a = 10;
    public void fun1(){
        System.out.println("In I fun1");
    }
}
class J extends I{
    int a = 100;
    public void fun1(){
        System.out.println("In J fun1");
    }
}
/*
    Binding at compile time : private method, instance variables -> Depends upon Reference Type on LHS side.
    Binding at run time: instance methods -> Depends upon object created on RHS side.
 */
public class SameInstanceVariableAndMethods {
    public static void main(String[] args) {
        I i = new I();
        System.out.println(i.a);    //10 OK
        i.fun1();                   //In I OK

        I ij = new J();
        System.out.println(ij.a);   //10 ? WOW!  | Instance variable binding happens at compile time
        ij.fun1();                  //In J OK

        J j = new J();
        System.out.println(j.a);    //100 OK
        j.fun1();                   //In J OK
    }


}
