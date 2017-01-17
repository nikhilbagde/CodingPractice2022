package Java.RandomTest;

/**
 * Created by Nikhil on 1/4/2017 5:07 AM.
 */
public class IkmTest3 {
    public IkmTest3() {
        this(10);
    }
    public IkmTest3(int data) {
        this.data = data;
    }
    public void display() {
        class Decrementer {
            public void decrement () {
                data--;
            }
        }
        Decrementer d = new Decrementer();
        d.decrement();
        System.out.println("data = " + data);
    }

    private int data;

    public static void main (String [] args) {
        int data = 0;
        IkmTest3 t = new IkmTest3();
        t.display();
        System.out.println("data = " + data);
    }
}
