package Algorithm.Implementation.Easy;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Nikhi on 9/25/2016.
 * https://www.hackerrank.com/challenges/bon-appetit
 */
public class Bonappetit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalItems = sc.nextInt();
        int indexK = sc.nextInt();
        int[] a = new int[totalItems];
        int actualCharge = 0;
        int totalCharge = 0;
        for(int i =0; i < totalItems ;i++){
            a[i] = sc.nextInt();
            if(i!=indexK)
                actualCharge += a[i];

            totalCharge += a[i];
        }
        actualCharge = actualCharge/2;
        int charged = sc.nextInt();
        if(totalItems >= 2 && totalItems <= Math.pow(10,5) &&   //Constrains.
                indexK >= 0 && indexK < totalItems
                && charged >=0 && charged <= totalCharge)  {
            if(charged > actualCharge){
                System.out.println(charged - actualCharge);
            }else{
                System.out.println("Bon Appetit");
            }
        }
    }
}


/*
Anna and Brian order  items at a restaurant, but Anna declines to eat any of the  item (where ) due to an allergy. When the check comes, they decide to split the cost of all the items they shared; however, Brian may have forgotten that they didn't split the  item and accidentally charged Anna for it.

You are given , , the cost of each of the  items, and the total amount of money that Brian charged Anna for her portion of the bill. If the bill is fairly split, print Bon Appetit; otherwise, print the amount of money that Brian must refund to Anna.

Input Format

The first line contains two space-separated integers denoting the respective values of  (the number of items ordered) and  (the -based index of the item that Anna did not eat).
The second line contains  space-separated integers where each integer  denotes the cost, , of item  (where ).
The third line contains an integer, , denoting the amount of money that Brian charged Anna for her share of the bill.

Constraints

Output Format

If Brian did not overcharge Anna, print Bon Appetit on a new line; otherwise, print the difference (i.e., ) that Brian must refund to Anna (it is guaranteed that this will always be an integer).

Sample Input 0

4 1
3 10 2 9
12
Sample Output 0

5
Explanation 0
Anna didn't eat item , but she shared the rest of the items with Brian. The total cost of the shared items is  and, split in half, the cost per person is . Brian charged her  for her portion of the bill, which is more than the  dollars worth of food that she actually shared with him. Thus, we print the amount Anna was overcharged, , on a new line.

Sample Input 1

4 1
3 10 2 9
7
Sample Output 1

Bon Appetit
Explanation 1
Anna didn't eat item , but she shared the rest of the items with Brian. The total cost of the shared items is  and, split in half, the cost per person is . Because this matches the amount, , that Brian charged Anna for her portion of the bill, we print Bon Appetit on a new line.
 */