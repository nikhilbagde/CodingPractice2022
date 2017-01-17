package GeeksForGeeks.JavaReview.MethodsInJava;

/**
 * Created by Nikhil on 1/8/2017 3:14 AM.
 */
public class PassByValuePrimitiveWrapper {

    public static void main(String[] args) {
        Integer integer = new Integer(10);
        integer = increament(integer);
        System.out.println(integer);
    }
    private static Integer increament(Integer obj){
        obj = obj + 1;
        System.out.println(obj);
        return obj;
    }

}
