package GeeksForGeeks.JavaReview.MultiThreading;

/**
 * Created by Nikhil on 1/8/2017 12:26 PM.
 */
class B implements Runnable{
    public void run(){
        try{
            System.out.println(Thread.currentThread().getId() + "Is Running");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
public class ThreadByRunnableInterface {
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            A a = new A();
            a.start();
        }

    }

}
