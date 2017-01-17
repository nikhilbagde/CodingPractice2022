package GeeksForGeeks.JavaReview.ConstructorChaining;

/**
 * Created by Nikhil on 1/8/2017 7:17 AM.
 */
public class A {
    A(){
        System.out.println("A Super Class Constructor");
        System.out.println("Objects HashCode " + this.hashCode());
        System.out.println("Class Name " + this.getClass());
    }
}
