package Java.Threading;

/**
 * Created by Nikhil on 3/21/2017 7:36 AM.
 */
public class C9_DeadLock {
    public static void main(String[] args) {
        final String message1 = "Nikhil";
        final String message2 = "Vandana";

        /*
        Thread 1 acquires lock on message1 and then goes to sleep.
        Now, if JVM starts Thread 2 and which acquires lock on message 2 and goes to sleep.

              message1          message2
                 ^                 ^
                T1                T2

        Now, if JVM switches back to t1, it tries to get lock on message2 which t2 has already lock on,
        hence it goes to waiting state.

        Similarly, when t1 goes to waiting state, JVM focuses on T2 and t2 is trying to get lock on message1
        on which t1 has already acquired lock and which is waiting t2 to release lock on message2.

        And T2 goes to waiting for T1 to release lock on message1.
        !DEADLOCK!


         */


        Thread t1 = new Thread() {
            public void run() {
                //first synchronize first object.
                synchronized (message1) {
                    System.out.println("Thread 1 locked resource 1");
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //Now synchronize first object.
                synchronized (message2) {
                    System.out.println("Thread 1 locked resource 2");
                }

            }
        };


        Thread t2 = new Thread() {
            public void run() {
                synchronized (message2) {
                    System.out.println("Thread 2 locked resource 2");
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


                synchronized (message1) {
                    System.out.println("Thread 2 locked resource 1");
                }
            }
        };

        t1.start();
        t2.start();

    }
}
