package Java.Threading;

/**
 * Created by Nikhil on 3/21/2017 4:44 AM.
 */
public class C1_Sleeping implements Runnable {
    public static void main(String[] args) {
        C1_Sleeping obj1 = new C1_Sleeping();
        C1_Sleeping obj2 = new C1_Sleeping();
        Thread thread1 = new Thread(obj1);
        Thread thread2 = new Thread(obj2);
        thread1.start();
        thread2.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; ++i) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }

            System.out.println(i + "th Thread is Running!");

        }
    }
}

/*
As you know well that at a time only one thread is executed.
If you sleep a thread for the specified time,
the thread scheduler picks up another thread and so on.
 */