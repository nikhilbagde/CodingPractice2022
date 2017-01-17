package Algorithm.Strings;

import java.util.Scanner;

/**
 * Created by Nikhi on 9/28/2016.
 */
public class ReducedString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String testString = " ";// = sc.next();
        StringBuilder  str = new StringBuilder(sc.next());

        for(int i = 1; i<str.length(); i++){
            if(str.charAt(i) == str.charAt(i-1)){
                str.deleteCharAt(i-1);
                str.deleteCharAt(i-1);
                i=0;
            }
        }

        //String finalString = reduceString(testString);
        /*if(!finalString.equals("")){
            System.out.println(finalString);
        }else{
            System.out.println("Empty String");
        }*/
        if(str.length()==0){
            System.out.println("Empty String");
        }else{
            System.out.println(str.toString());
        }
    }
    public static String reduceString(String a){
        //for(int i=0;i<a.length()-1;i++){
        if(a.length()==0){
            return "";
        }
            int i = 0;
            do{
                if(a.charAt(i) == a.charAt(i+1)){
                    StringBuilder str = new StringBuilder(a);
                    //str.setCharAt(i,' ');
                    //str.setCharAt(i+1,' ');
                    str.deleteCharAt(i);
                    str.deleteCharAt(i+1);
                    a = str.toString().trim().replaceAll("\\s+","");
                    //i+=1;
                    a = reduceString(a);
                }
                i++;
            }while(i<a.length()-1);

        //}
        return a.trim().replaceAll("\\s+","");
    }

}
