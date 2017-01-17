package Algorithm.Implementation.Easy;

import java.util.Scanner;

/**
 * Created by Nikhi on 9/24/2016.
 * https://www.hackerrank.com/challenges/jumping-on-the-clouds
 */
public class Jumpingontheclouds {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int clouds[] = new int[n];   //its binary integer input 0 0 1 0 0 1 0 for clouds (Normal or thunderstrom)
        int jumps = 0;

        for(int c_i=0; c_i < n; c_i++){
            clouds[c_i] = in.nextInt();
        }
        if(n>=2 && n<=100){
            int i=0;
            while(i!=n-1){

                if(i+2!=n && clouds[i+2] == 0){         // or could use, i+2 <= n
                    jumps++;
                    i+=2;
                }else if(clouds[i+1] == 0){
                    i++;
                    jumps++;
                }
                //if(i==n){

                //}
            }
            System.out.println(jumps);
        }
    }
}

/*
Emma is playing a new mobile game involving  clouds numbered from  to . A player initially starts out on cloud , and they must jump to cloud . In each step, she can jump from any cloud  to cloud  or cloud .

There are two types of clouds, ordinary clouds and thunderclouds. The game ends if Emma jumps onto a thundercloud, but if she reaches the last cloud (i.e., ), she wins the game!

jump(1).png

Can you find the minimum number of jumps Emma must make to win the game? It is guaranteed that clouds  and  are ordinary-clouds and it is always possible to win the game.

Input Format

The first line contains an integer,  (the total number of clouds).
The second line contains  space-separated binary integers describing clouds .

If , the  cloud is an ordinary cloud.
If , the  cloud is a thundercloud.
Constraints

Output Format

Print the minimum number of jumps needed to win the game.

Sample Input 0

7
0 0 1 0 0 1 0
Sample Output 0

4
Sample Input 1

6
0 0 0 0 1 0
Sample Output 1

3
Explanation

Sample Case 0:
Because  and  in our input are both , Emma must avoid  and . Bearing this in mind, she can win the game with a minimum of  jumps:

jump(2).png

Sample Case 1:
The only thundercloud to avoid is . Emma can win the game in  jumps:

jump(5).png
 */