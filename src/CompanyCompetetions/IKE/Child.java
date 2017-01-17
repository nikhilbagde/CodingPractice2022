package CompanyCompetetions.IKE;

/**
 * Created by Nikhil on 1/4/2017 2:45 AM.
 */
public class Child extends Temp {
    public Child() {
        int a = 10;
        count++;
    }
    public static void main(String [] args) {
        System.out.println("Count = " + getCount());
        Child obj = new Child();
        System.out.println("Count = " + getCount());
    }
}
