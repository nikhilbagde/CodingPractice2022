package CompanyCompetetions.Booking.com;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Nikhi on 11/23/2016.
 */
public class DifferenceBound {
    public static void main(String args[] ) throws Exception {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        String[] arr=s.trim().split("\\s+");
        if(arr.length <=1){
            System.out.println("");
            System.exit(1);
        }
        /*if(arr.length)*/ //25626 25757 24367 24267 16 100 2 7277
        //String[] arr={"25626","25757","24367","24267","16","100","2","7277"};
        //output  25626 -128 131  -128 -1390 -100 -128 -24267
        //input -127 -127 -127 -127 127 127
        ArrayList<Integer> out = new ArrayList<>();
        int prev=-1;
        for(int i=0;i<arr.length;i++){

            int x=Integer.valueOf(arr[i]);
            if(i==0){
                prev=x;
                out.add(x);
            }else{
                int diff=x-prev;
                if(diff<-127 || diff>127){
                    out.add(-128);
                    out.add(diff);
                }else{
                    out.add(diff);
                }
                prev=x;
            }
        }
        for(int i=0;i<out.size();i++){
            System.out.print(String.valueOf(out.get(i))+" ");
        }
    }
}
