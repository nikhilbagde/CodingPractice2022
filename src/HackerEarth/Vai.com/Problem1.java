package HackerEarth.Vai.com;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by Nikhi on 10/16/2016.
 * Sample Input(Plaintext Link)
 3
 0100 0200
 1100 1300
 1331 1441
 Sample Output(Plaintext Link)
 1
 2
 2

 */
public class Problem1 {
    public static void main(String[] args) throws Exception{
        /*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);*/

        //Scanner
        Scanner s = new Scanner(System.in);
        int testCaes = s.nextInt();

        for (int i = 0; i < testCaes; i++) {
            String startTime  = s.next();
            String endTime  = s.next();

            String hour1 = "" + startTime.charAt(0) +  startTime.charAt(1);
            String min1 = "" + startTime.charAt(2) +  startTime.charAt(3);

            String hour2 = "" + endTime.charAt(0) +  endTime.charAt(1);
            String min2 = "" + endTime.charAt(2) +  endTime.charAt(3);

            int counter = 0;
            int hour11 = Integer.parseInt(hour1);
            int min11 = Integer.parseInt(min1);
            int hour22 = Integer.parseInt(hour2);
            int min22 = Integer.parseInt(min2);

            for (int j = hour11; j <= hour22 ; j++) {
                if(j == hour11) {
                    for (int k = min11; k <= 59; k++) {
                        String time =  "" + ((j<10 ? "0"+j : ""+j)) + "" + (k<10 ? "0"+k : ""+k);
                            if(isPallindrom(time)){
                                counter++;
                                break;
                            }
                    }
                    continue;
                }
                if(j== hour22){
                    for (int k = 0; k <= min22; k++) {
                        String time =  "" + ((j<10 ? "0"+j : ""+j)) + "" + (k<10 ? "0"+k : ""+k);
                        if(isPallindrom(time)){
                            counter++;
                            break;
                        }
                    }
                }else {
                    for (int k = 0; k < 59; k++) {
                        String time =  "" + ((j<10 ? "0"+j : ""+j)) + "" + (k<10 ? "0"+k : ""+k);
                        if (isPallindrom(time)) {
                            counter++;
                            break;
                        }
                    }
                }
            }
            System.out.println(counter);
        }
    }
    public static boolean isPallindrom(String time){
        return time.charAt(0) == time.charAt(3) && time.charAt(1) == time.charAt(2);
    }
}

/*
Question 1. Max. Marks 100
Micro and his Son
Our programmer friend Micro just taught his son, Micro Junior, how to read a clock. Few days back he also taught him about palindromes. Now as we know that Micro Junior looks for opportunities to trouble his father, so he started asking him questions. He asked him T questions. In each he gave his father a starting time and an ending time and asked the number of times in between which are palindromes (see sample explanation for more clarity) . Now Micro asked for your help to solve this problem.

Input:
The first line consists of T, the number of questions.
Next T lines consist of a starting time S and an ending time E separated by a space. Time is given in 24-hour format without any colons. (See sample input)

Output:
Print the answer for each question in a new line.

Constraints:
1 ≤ T ≤ 1000
It is assured that every time given is valid. Time starts from 0000 to 2359
S ≤ E

Sample Input(Plaintext Link)
 3
0100 0200
1100 1300
1331 1441
Sample Output(Plaintext Link)
 1
2
2

Explanation
Between 0100 and 0200, only palindromic time is 0110.
Between 1100 and 1300, palindromic times are 1111 and 1221.
Between 1331 and 1441, palindromic times are 1331 and 1441.

Time Limit: 1.0 sec(s) for each input file.
Memory Limit: 256 MB
Source Limit: 1024 KB
Marking Scheme: Marks are awarded if any testcase passes.
Allowed languages: JavaReview, JavaReview 8
 */