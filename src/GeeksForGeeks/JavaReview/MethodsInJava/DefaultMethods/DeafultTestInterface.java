package GeeksForGeeks.JavaReview.MethodsInJava.DefaultMethods;

/**
 * Created by Nikhil on 1/8/2017 4:03 AM.
 */
public interface DeafultTestInterface {
    void function1();
    default void function2(){
        System.out.println("Inteface1 Function2");
    }
}
