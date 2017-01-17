package Java.Advanced;

import java.util.Scanner;

/**
 * Created by Nikhi on 12/22/2016 10:46 AM.
 */
public class JavaStaticInitializerBlock {
    //Write your code here
    static int B;
    static int H;
    static boolean flag= true;

    static{
        Scanner scanner = new Scanner(System.in);
        B = scanner.nextInt();
        H = scanner.nextInt();
        scanner.close();
        flag = false;
        try {
           if(B<0 || H<0){
                throw new Exception("java.lang.Exception: Breadth and height must be positive");
           }
        }catch (Exception e) {
            System.out.println(e);
            System.exit(0);
        }
    }
    public static void main(String args[]){
        if(flag){
            int area = B*H;
            System.out.println(area);
        }
    }
}
