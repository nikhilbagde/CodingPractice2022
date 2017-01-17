package GeeksForGeeks.JavaReview.Random2;

/**
 * Created by Nikhil on 1/7/2017 3:15 AM.
 */
public class VariableHiding {
    private int instanceVariable = 10;
    int instanceVariable2 = 20;

    public void function(){
        int instanceVariable2 = 10;
        System.out.println(instanceVariable2);
        System.out.println(this.instanceVariable2);

        int a = 100_00_000_00;
        System.out.println(a);
    }

    public static void main(String[] args) {
        VariableHiding obj = new VariableHiding();
        obj.function();
    }

}
