package CompanyCompetetions.Optimizely;/*

Write a function that when given an array of elevations representing peaks
on a 2D mountain range will return the elevation of lakes formed when the
valleys of that range are filled with rain water.

The array of elevations passed into your function will be ordered from left
to right but the order of the returned array of lake elevations is unimportant.

   +--------------------------------------------------------------------------+
14 |                                                                          |
13 |                                                                          |
12 |                                                                          |
11 |                           /\                                             |
10 |                          /  \                                            |
 9 |                         /    \~~~~~~~~~~~~~~~~~~~~~~/\                   |
 8 |              /\~~~~~~~~/      \~ ~ ~ ~ ~ ~ ~ ~ ~ ~ /  \                  |
 7 |             /  \~ ~ ~ /        \~ ~ ~ ~ ~ ~ ~ ~ ~ /    \                 |
 6 |            /    \~ ~ /          \~ ~ ~ /\~ ~ ~ ~ /      \                |
 5 |           /      \~ /            \~ ~ /  \~ ~ ~ /        \~~/\           |
 4 |          /        \/              \~ /    \~ ~ /          \/  \          |
 3 |         /                          \/      \~ /                \         |
 2 |        /                                    \/                  \        |
 1 |       /                                                          \       |
 0 |~~~~~~/                                                            \~~~~~~|
   |~ ~ ~  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  ~  ~|
   |  ~  ~  ~  ~   ~   ~   ~   ~   ~   ~   ~   ~   ~   ~   ~   ~   ~   ~  ~  ~|
   |   ~     ~     ~     ~     ~     ~     ~     ~     ~     ~     ~     ~    |
   +--------------------------------------------------------------------------+

 EXAMPLE:
 Function is passed the array [8,11,6,9,5]

 Your function would return the following array representing the elevations of
 the series of lakes formed by filling in the valleys:
 [8,9,5]

*/

import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
    public static void main(String[] args) {
        int[] input1 = {8,11,6,9,5};
        Map<String, String> map = new HashMap<>();


        getLevel3(input1);
    }


    public static void getLevel3(int[] input){
        int current = 0, index=0;
        boolean noNextMax = false;
        int[] result = new int[input.length+1];
        List<Integer> resultList = new ArrayList<>();

        while(!noNextMax && current < input.length-1){
            int next = current+1;
            while(!noNextMax && next<input.length){
                if(input[current]<input[next]){
                    result[index++]= input[current];
                    resultList.add(input[current]);
                    current=next;
                    break;
                }
                if(next == input.length-2){
                    noNextMax = true;
                }
                next++;
            }
        }
        //8 11 6 9 5
        int[] reverseResult = new int[input.length];
        int index1 = 0;
        int last = input.length-1;
        boolean noPrevMax = false;

        List<Integer> reverseResultList = new ArrayList<>();
        while(!noPrevMax && last >= 0){
            int prev = last-1;
            while(!noPrevMax && prev >= 0){
                if(input[last]<input[prev]){
                    reverseResult[index1++]= input[last];
                    reverseResultList.add(input[last]);
                    last=prev;    //
                    break;
                }
                if(prev==1 || prev==0){
                    noPrevMax = true;
                }
                prev--;
            }
        }

        Collections.sort(reverseResultList, Collections.reverseOrder());
        resultList.addAll(reverseResultList);

        System.out.println(resultList);

    }
}
