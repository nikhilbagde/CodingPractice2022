package Java;

import java.util.Scanner;

/**
 * Created by Nikhi on 11/18/2016.
 */
public class JavaRegex {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String IP = in.next();
            System.out.println(IP.matches(new MyRegex().pattern));
        }

    }

}
class MyRegex{
    String zeroTo255NotWorking = "(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])";
    String zeroTo255 = "([0-9]|[0-9][0-9]|(0|1)[0-9][0-9]|2[0-4][0-9]|25[0-5])";
    public String pattern = zeroTo255 + "." + zeroTo255 + "." + zeroTo255 + "." + zeroTo255;
}
/*
This is the easiest way to understand the ip adress
class myRegex { String zeroTo255 = "([0-9]|[0-9][0-9]|(0|1)[0-9][0-9]|2[0-4][0-9]|25[0-5])"; public String pattern = zeroTo255 + "." + zeroTo255 + "." + zeroTo255 + "." + zeroTo255; }
Tergets:
1----> ip adress should be 0-255;
2----> it should contain only digits;
3----> should not exceed 3 digit number i.e (255);
Approach:
1--> it can contain single digit i.e ([0-9]);
2--> It can contain two digits i.e ([0-9][0-9]);
3--> Range is (099 to 199)i.e((0|1)[0-9][0-9]);
4--> range is (200 - 249) i.e (2[0-9][0-9]) ;
5--> range is (250-255) i.e (25[0-5]);
Total :
"([0-9]|[0-9][0-9]|(0|1)[0-9][0-9]|2[0-4][0-9]|25[0-5])"
 */