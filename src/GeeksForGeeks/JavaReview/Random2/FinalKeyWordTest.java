package GeeksForGeeks.JavaReview.Random2;

/**
 * Created by Nikhil on 1/7/2017 2:59 AM.
 */
public class FinalKeyWordTest {
    public static void main(String[] args) {
        final int a = 10;
        final char z = 'z';

        final TestFinalWithReferenceObjects obj1 = new TestFinalWithReferenceObjects();
        obj1.Anumber = 100;

        TestFinalWithReferenceObjects obj2=  new TestFinalWithReferenceObjects();
        obj2.Anumber = 110;
        //obj2 = obj1;
        //obj1 = obj2;

        TestFinalWithReferenceObjects obj3 = new TestFinalWithReferenceObjects();
        obj3 = obj2;
        System.out.println(obj3.Anumber);


    }
}

class TestFinalWithReferenceObjects{
    int Anumber = 10;
    char aChar = 'a';
    String string = "Pratik" + "Nikihl";
}
