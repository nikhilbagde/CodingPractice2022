package GeeksForGeeks.JavaReview.Random2;

/**
 * Created by Nikhil on 1/7/2017 3:25 AM.
 */
public class IntegerObjectVsPrimitveInteger {
    public static void main(String[] args) {
        int a  = 100;           //primitive type variable
        Integer b = 129;        //refernce type variable
        Integer e = 129;
        //in java we have corresponding object type variable for primitive type variable.
        boolean c = true;
        Boolean d = false;

        if(a == b){
            System.out.println( "Yes");
        }else {
            System.out.println("NO");
        }

        if(b == e){
            System.out.println("Yes");
        }else{
            System.out.println("NO");
        }

        Integer integer1 = new Integer(40);
        Integer integer2 = new Integer(80);

        System.out.println(integer1 == integer2 ? "Yes" : "NO");

        Integer integer3 = 40;      // -128 to 127 are cached.
        Integer integer4 = 40;
        System.out.println(integer3 == integer4 ? "Yes" : "NO");

        Integer integer5 = -129;      // -128 to 127 are cached.
        Integer integer6 = -129;
        System.out.println(integer5 == integer6 ? "Yes" : "NO");

        Integer integer7 = 128;      // -128 to 127 are cached.
        Integer integer8 = 128;
        System.out.println(integer7 == integer8 ? "Yes" : "NO");

        System.out.println(2+0+1+5+"GeeksforGeeks"+(2+0+1+6));

        String s = "Learn Share Learn";
        int output = s.indexOf('a',3);// returns 8
        System.out.println(output);


        String s1 = "Nikhil";
        String s2 = "Pratik";

        System.out.println(s1.compareTo(s2));

        //Decimal To Binary
        int aaa = 10;
        System.out.println(Integer.toBinaryString(aaa));


    }
}
