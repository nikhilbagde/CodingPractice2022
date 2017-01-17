package GeeksForGeeks.JavaReview.Inheritance;

/**
 * Created by Nikhil on 1/8/2017 8:01 AM.
 */

class G{
    private void fun1(){
        System.out.println("In G fun1");
    }
    public void fun2(){
        System.out.println("In G fun2");
    }

    class H extends G{
        public void fun1(){
            System.out.println("In H fun1");
            super.fun1();
        }
        public void fun2(){
            System.out.println("In H fun2");
        }
    }

    public static void main(String[] args) {
        G gh = new G().new H();
        gh.fun1();
    }
}
/*
    Binding at compile time : private method, instance variables -> Depends upon Reference Type on LHS side.
    Binding at run time: instance methods -> Depends upon object created on RHS side.
 */

public class InnerClassExtendingOuterClass {
    public static void main(String[] args) {
        G g = new G();
        G.H h = new G().new H();

        h.fun1();       //can access fun1 as its public + reference type binding at compile time with H.

        G gh = new G().new H();
        //gh.fun1(); cant access fun1 beacuse its private in G,
        // for private method bonding happens at compile time.
        // Hence instead of looking for fun1 in H it looks it in G.
    }
}

