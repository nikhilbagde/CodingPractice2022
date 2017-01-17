package CompanyCompetetions.Yahoo;

import java.util.Scanner;

/**
 * Created by Nikhi on 11/28/2016.
 */
public class PlayerIdExtrator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = null;

        while(( s = sc.nextLine())!=null){
            String toPrint = "";
            //s = s.replaceAll("\\s+", "");
            String [] array1 = s.split("\\s+");
            //s = s.replaceAll("^[.] [a-zA-Z] ^[.]", "");
            char[] array = s.toCharArray();
            for (int i = 0; i < array1.length; i++) {

                if(array1[i].contains("[") || array1[i].contains("]")){
                    toPrint += array1[i] + ",";
                }
            }
            if(toPrint.length()>2)
            toPrint = toPrint.substring(0,toPrint.length()-1);
            System.out.println(toPrint.replaceAll("\\[","").replaceAll("\\]",""));
        }
    }
}
