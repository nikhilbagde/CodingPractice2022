package Java.Threading;

/**
 * Created by Nikhil on 3/21/2017 6:19 AM.
 */

//Annonymous class that extends thread class
public class C8_MultiTaskMutiThreads {
    public static void main(String[] args) {
        //notice lambda goes inside of thread constructor.
        Thread t1 = new Thread(() -> System.out.println("Task 1"));
        Thread t2 = new Thread(() -> System.out.println("Task 2"));

        t1.start();
        t2.start();
    }
}

//Annonymous class that implements runnable interface
class C8_MultiTaskMutliThreadRunnable {
    public static void main(String[] args) {
        //notice lambda goes directly after equal to sign.
        Runnable r1 = () -> System.out.println("task 1");
        Runnable r2 = () -> System.out.println("Task 2");

        //Now again create a Thread class object and pass runnable object to Thread constructor

        Thread t1 = new Thread(r1, " First Runnable Thread");
        Thread t2 = new Thread(r2, " First Runnable Thread");

        t1.start();
        t2.start();
    }
}
