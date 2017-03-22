package Java.Threading;

/**
 * Created by Nikhil on 3/21/2017 8:34 AM.
 */
public class C10_WaitAndNotify {
    private int amount = 10000;

    public static void main(String[] args) {
        C10_WaitAndNotify obj = new C10_WaitAndNotify();

        new Thread(() -> obj.withDraw(15000)).start();

        new Thread(() -> obj.deposit(0)).start();

        new Thread(() -> obj.withDraw(15000)).start();

        new Thread(() -> obj.deposit(10000)).start();

    }

    synchronized void withDraw(int newAmount) {
        if (this.amount < newAmount) {
            System.out.println("Insufficient Balance");
            try {
                while (this.amount < newAmount)
                    wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Withdrawing...");
            //once got notify signal.
            amount -= newAmount;
            System.out.println("Remaining Amount=" + amount);
        }
    }

    synchronized void deposit(int newAmount) {
        System.out.println("Depositing...");
        amount += newAmount;
        System.out.println("Deposited" + newAmount + "Total Amount now" + amount);
        notify();
    }
}
