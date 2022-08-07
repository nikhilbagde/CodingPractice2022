package OTT.P6_HackerRank.WarmUp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Nikhil on 2/10/2017 4:56 AM.
 */
public class P8TimeConversion {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String time = in.next();

        String ampm = time.substring(time.length() - 2);
        String fullTime = time.substring(0, time.length() - 2);
        String[] array = fullTime.split(":");
        int hour = Integer.parseInt(array[0]);
        int min = Integer.parseInt(array[1]);
        int sec = Integer.parseInt(array[2]);

        String result = "";
        if (ampm.equals("AM")) {
            if (hour == 12) {
                result = result + "00" + ":";
            } else {
                result += (hour < 10 ? "0" : "") + hour + ":";
            }
            result += (min < 10 ? "0" : "") + min + ":";
            result += (sec < 10 ? "0" : "") + sec;
        } else {
            if (hour == 12) {
                result = result + "12" + ":";
            } else {
                result += (hour + 12) + ":";
            }
            result += (min < 10 ? "0" : "") + min + ":";
            result += (sec < 10 ? "0" : "") + sec;
        }
        System.out.println(result);
        System.out.println(Arrays.toString(array));
        System.out.println(fullTime + " " + (ampm));
    }
}
