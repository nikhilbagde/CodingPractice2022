package GeeksForGeeks.JavaReview.Random2;

/**
 * Created by Nikhil on 1/7/2017 2:20 AM.
 */
public class ScopeTest {

    static public int ab;     //this is class level variable
    private int abprivaate;     //this is class level variable
    static protected  int protectedVariable = 100;

    private static void printA(){
        int ab;                 //method level variable
        System.out.println("A");
    }

    class Iterator{
        int ab;                 //inner class level variable,
    }
    int anInt;                  //instance level variable

}
