package Java.Threading;

/**
 * Created by Nikhil on 3/21/2017 5:25 AM.
 */
public class C5_PriorityThread extends Thread {
    public static void main(String[] args) {
        C5_PriorityThread obj1 = new C5_PriorityThread();
        C5_PriorityThread obj2 = new C5_PriorityThread();
        C5_PriorityThread obj3 = new C5_PriorityThread();
        C5_PriorityThread obj4 = new C5_PriorityThread();

        obj3.setPriority(MAX_PRIORITY);
        obj4.setPriority(NORM_PRIORITY);
        obj2.setPriority(MIN_PRIORITY);
        obj1.setPriority(MAX_PRIORITY);

        obj1.start();
        obj2.start();
        obj3.start();
        obj4.start();


    }

    public void run() {
        System.out.println("Name:" + Thread.currentThread().getName());
        System.out.println("Priority:" + Thread.currentThread().getPriority());
    }
}
