package GeeksForGeeks.JavaReview.Advance.Generics;

/**
 * Created by Nikhil on 1/8/2017 2:49 PM.
 */
public class GenericMethod {
    public static void main(String[] args) {
        print(1);
        print(11.10);
        print("Nikhil");
        print('c');
    }
    private static <A> void print(A element){
        System.out.println(element);
    }
}
