package GeeksForGeeks.JavaReview.FinalKeyWord;

/**
 * Created by Nikhil on 1/8/2017 2:18 AM.
 */
public class BlankFinal {
    public static void main(String[] args) {
        A2 a2 = new A2(10);
        System.out.println(a2.anInt);

        A2 a21 = new A2(100);
        System.out.println(a21.anInt);
    }
}
class A2{
    final int anInt;
    A2(int a){
        anInt = a;
    }

}
