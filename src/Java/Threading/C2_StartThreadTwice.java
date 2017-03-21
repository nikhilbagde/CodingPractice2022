package Java.Threading;

/**
 * Created by Nikhil on 3/21/2017 4:51 AM.
 * No. After starting a thread, it can never be started again.
 * If you does so, an IllegalThreadStateException is thrown.
 * In such case, thread will run once but for second time, it will throw exception.
 */
public class C2_StartThreadTwice extends Thread {
    public static void main(String[] args) {
        C2_StartThreadTwice obj = new C2_StartThreadTwice();
        obj.start();
        obj.start();
    }

    public void run() {
        System.out.println(" Thread is Running!");
    }
}
