package Java.Threading;

/**
 * Created by Nikhil on 3/21/2017 4:41 AM.
 */
public class C0_ImplementRunnable implements Runnable {
    public static void main(String[] args) {
        C0_ImplementRunnable implementRunnable = new C0_ImplementRunnable();
        Thread thread = new Thread(implementRunnable);
        thread.start();
    }

    @Override
    public void run() {
        System.out.println("Thread is Running!");
    }
}
