package GeeksForGeeks.JavaReview.Interfaces;

/**
 * Created by Nikhil on 1/8/2017 9:24 AM.
 */
interface J{
    void fun1();
    interface K{
        void fun1();
    }
}
class L implements J{           //only implements J
    public void fun1(){
        System.out.println("In L, Implementing fun1 from J");
    }
}
class M implements J.K{
    public void fun1(){
        System.out.println("In M, Implementing fun1 from interface J.K");
    }
}
public class InterfaceInsideInterface {
    public static void main(String[] args) {
        J jl = new L();
        jl.fun1();

        J.K jkm = new M();
        jkm.fun1();
    }
}
