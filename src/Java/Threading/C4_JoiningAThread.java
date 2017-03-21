package Java.Threading;

/**
 * Created by Nikhil on 3/21/2017 4:58 AM.
 */
public class C4_JoiningAThread extends Thread {
    public static void main(String[] args) {
        C4_JoiningAThread obj1 = new C4_JoiningAThread();
        C4_JoiningAThread obj2 = new C4_JoiningAThread();
        C4_JoiningAThread obj3 = new C4_JoiningAThread();

        System.out.println("In Main:" + obj1.getName() + obj1.getState() + obj1.isAlive());
        System.out.println("In Main:" + obj2.getName() + obj2.getState() + obj2.isAlive());
        System.out.println("In Main:" + obj3.getName() + obj3.getState() + obj3.isAlive());

        obj1.start();

        try {
            //obj1.join();
            System.out.println("In Main:" + obj1.getName() + obj1.getState() + obj1.isAlive());
            obj1.join(1500);    //milliseconds.
            System.out.println("In Main:" + obj1.getName() + obj1.getState() + obj1.isAlive());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("In Main:" + obj2.getName() + obj2.getState() + obj2.isAlive());
        System.out.println("In Main:" + obj3.getName() + obj3.getState() + obj3.isAlive());

        obj2.start();
        obj3.start();

        System.out.println("In Main:" + obj2.getName() + obj2.getState() + obj2.isAlive());
        System.out.println("In Main:" + obj3.getName() + obj3.getState() + obj3.isAlive());
    }

    public void run() {
        for (int i = 0; i < 5; ++i) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            System.out.println(Thread.currentThread().getName());
            System.out.print(i + "th Thread of " + this.getName() + "'s Thread, is Running!");
            System.out.println("\nPriority:" + this.getPriority() + "\nString:" + this.toString() + "\nId: " + this.getId() + "\nState: " + this.getState() + "\nisAlive:" + this.isAlive());
            System.out.println();
        }
    }
}
