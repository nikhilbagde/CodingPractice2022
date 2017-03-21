package Java.Threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Nikhil on 3/21/2017 5:30 AM.
 */
public class C6_ThreadPool implements Runnable {
    private String message;

    C6_ThreadPool(String message) {
        this.message = message;
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        //at a
        for (int i = 0; i < 10; ++i) {
            Runnable worker = new C6_ThreadPool(" " + i);
            executorService.execute(worker);
        }
        executorService.shutdown();

        while (!executorService.isTerminated()) {
        }
        System.out.println("Finished All Threads");

    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " (Start) message = " + message);
        processmessage();//call processmessage method that sleeps the thread for 2 seconds
        System.out.println(Thread.currentThread().getName() + " (End)");//prints thread name
    }

    private void processmessage() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
