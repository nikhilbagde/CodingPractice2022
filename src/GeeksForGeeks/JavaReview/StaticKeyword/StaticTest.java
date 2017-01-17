package GeeksForGeeks.JavaReview.StaticKeyword;

/**
 * Created by Nikhil on 1/8/2017 1:10 AM.
 */
public class StaticTest {
    public static int anInt = 10;          //static variable          -> class
    int anInt1 = 20;                //non static            -> object


    public void function2(){                    //-> object
        //static wrongVarable = 10;
    }

    public static void functiin1(){             //-> classs

    }

}
class Test1{
    public static void main(String[] args) {
        StaticTest staticTestObj = new StaticTest();
        staticTestObj.anInt1++;
        staticTestObj.function2();

        //access static variables
        StaticTest.functiin1();
        StaticTest.anInt++;

    }
}
