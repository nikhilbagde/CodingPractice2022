package GeeksForGeeks.JavaReview.Inheritance;

/**
 * Created by Nikhil on 1/8/2017 7:39 AM.
 */

class E{
    public void fun1(){
        System.out.println("E fun1");
    }
}

class F extends E{
    public void fun1(){
        System.out.println("F fun1");
        //to call above fun1 -> super.fun1();
        super.fun1();
    }
}
/*
    Binding at compile time : private method, instance variables -> Depends upon Reference Type on LHS side.
    Binding at run time: instance methods -> Depends upon object created on RHS side.
 */

public class PolymorphismTest {
    public static void main(String[] args) {
        E e = new E();
        e.fun1();       //E fun1

        E ef = new F(); //instance methods belongs to object getting created. new F() is getting created. Hence it will go with fun1() if F.
        ef.fun1();      //F fun1

        F f = new F();
        f.fun1();       // F fun1
    }
}
