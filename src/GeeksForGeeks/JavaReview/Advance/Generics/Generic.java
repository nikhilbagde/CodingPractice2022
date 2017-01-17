package GeeksForGeeks.JavaReview.Advance.Generics;

/**
 * Created by Nikhil on 1/8/2017 2:32 PM.
 */
public class Generic<T,U,V> {
    T obj1;
    U obj2;
    V obj3;

    public Generic() {
    }

    public Generic(T obj1, U obj2, V obj3) {
        this.obj1 = obj1;
        this.obj2 = obj2;
        this.obj3 = obj3;
    }

    @Override
    public String toString() {
        return "Generic{" +
                "obj1=" + obj1 +
                ", obj2=" + obj2 +
                ", obj3=" + obj3 +
                '}';
    }

    public static void main(String[] args) {
        Generic<Integer, String , Double> combined = new Generic<>();
        Generic<Integer, String , Double> combined1 = new Generic<>(1,"Nikhil",9.7);
        System.out.println(combined1);
    }
}
