package Java.Threading;

/**
 * Created by Nikhil on 3/21/2017 6:15 AM.
 */

//Way 1; Extending Thread Class
public class C7_OneTaskMultiThread extends Thread {
    public static void main(String[] args) {
        C7_OneTaskMultiThread t1 = new C7_OneTaskMultiThread();
        C7_OneTaskMultiThread t2 = new C7_OneTaskMultiThread();
        C7_OneTaskMultiThread t3 = new C7_OneTaskMultiThread();

        t1.start();
        t2.start();
        t3.start();
    }

    public void run() {
        System.out.println("Task 1");
    }
}

class C7_OneTaskMultiThreadRunnable implements Runnable {
    public static void main(String[] args) {
        Thread t1 = new Thread(new C7_OneTaskMultiThreadRunnable());
        Thread t2 = new Thread(new C7_OneTaskMultiThreadRunnable());
        t1.start();
        t2.start();
    }

    @Override
    public void run() {
        System.out.println("Task 1");
    }
}

