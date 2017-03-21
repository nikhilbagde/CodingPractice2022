package Java.Threading;

/**
 * Created by Nikhil on 3/21/2017 4:39 AM.
 */
public class C0_ExtendThread extends Thread {
    public static void main(String[] args) {
        C0_ExtendThread extendThread = new C0_ExtendThread();
        extendThread.start();
    }

    public void run() {
        System.out.println("Thread is Running!");
    }

}
