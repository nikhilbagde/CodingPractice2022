package Java.RandomTest;

/**
 * Created by Nikhil on 1/4/2017 4:17 AM.
 */
public class Parent {
    protected static int count = 0;
    public Parent() { count++; }
    static int getCount() { return count; }
}

/*
public class Child2 extends Parent {
    public Child2() { count++; }
    public static void main(String [] args) {
        System.out.println("Count = " + getCount());
        Child obj = new Child();
        System.out.println("Count = " + getCount());
    }
}
*/

