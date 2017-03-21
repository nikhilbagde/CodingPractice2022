package Java.Threading;

/**
 * Created by Nikhil on 3/21/2017 4:53 AM.
 */
public class C3_CallingRunFromMain extends Thread {
    public static void main(String[] args) {
        C3_CallingRunFromMain obj = new C3_CallingRunFromMain();
        ////fine, but does not start a separate call stack
        obj.run();
    }

    public void run() {
        System.out.println(" Thread is Running!");
    }
}
/*  Call stack
        |---------|
        |  run()  |
        |  main() |
        |---------|
 */
