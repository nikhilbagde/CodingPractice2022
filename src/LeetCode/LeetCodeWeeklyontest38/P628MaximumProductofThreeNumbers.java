package LeetCode.LeetCodeWeeklyontest38;

import Algorithm.CheatSheet.Graph.*;
import Algorithm.CheatSheet.Graph.Stack;

import java.util.*;

/**
 * Created by Nikhi on 6/24/2017.
 */
public class P628MaximumProductofThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[scanner.nextInt()];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.println(maximumProduct(array));
    }
    public static int maximumProduct(int[] nums) {
        PriorityQueue<Integer> p = new PriorityQueue<>((o1, o2) -> o1> o2 ? 1 : (o1 <o2) ? -1 : 0);
        PriorityQueue<Integer> n = new PriorityQueue<>((o1, o2) -> o1> o2 ? 1 : (o1 <o2) ? -1 : 0);

        for (int a :nums) {
            if(a<0){
                //if(n.size()<3) {
                    n.add(a);
                /*}else if( n.size() > 3 && n.peek() > a){
                    n.poll();
                    n.add(a);
                }*/
            }else {
                if(p.size()<3) {
                    p.add(a);
                }else if( p.size() >= 3 && p.peek() < a){
                    //p.poll();
                    p.add(a);
                }

            }
        }
        System.out.println("PQ n" + n);
        System.out.println("PQ p" + p);

        if(n.size() ==0){
            return p.poll() * p.poll() * p.poll();
        }
        if(p.size() ==0 && n.size()>3){
            int result = 1;
            result *= n.poll();
            n.poll();
            result *= n.poll();
            n.poll();
            return result * n.poll();
        }
        int result= 1, count =3;
        result *= p.peek() == null ? 1 : p.poll();
        while(p.size()> 0 && n.size()>0 && count>0){
            if(p.peek() < Math.abs(n.peek())){
                result *= n.poll() * n.poll();
            }else {
                result *= p.poll() * p.poll();
            }
            count--;
        }
        return result;
    }
}


/*
Given an integer array, find three numbers whose product is maximum and output the maximum product.

Example 1:
Input: [1,2,3]
Output: 6
Example 2:
Input: [1,2,3,4]
Output: 24
Note:
The length of the given array will be in range [3,104] and all elements are in the range [-1000, 1000].
Multiplication of any three numbers in the input won't exceed the range of 32-bit signed integer.
 */

/*
Input:
[-4,-3,-2,-1,60]
Output:
120
Expected:
720

 */

/*
[1,2,3,4]
 */

/*
[-947,-836,-583,88,121,-200,-281,-610,952,529,-1,-122,101,-105,708,96,140,-333,-532,-407,-425,-953,350,-559,-733,826,996,671,-560,-793,298,256,309,-441,-281,693,-864,-553,30,-416,567,367,182,-983,955,-196,-321,792,-288,-627,830,303,670,805,-323,125,200,-140,765,642,124,-659,-675,372,-833,-385,844,529,-665,-370,-453,326,656,-628,-230,-433,-146,-42,609,-454,-393,701,854,-705,147,-834,154,-996,-180,-639,-395,-108,-868,919,186,-289,643,537,-462,28]

 */