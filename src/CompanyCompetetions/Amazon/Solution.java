package Algorithm;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Nikhi on 9/28/2016.
 *
 */
public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        String _command = in.nextLine();
        String res = movePlane(_command);

    }
    public static int [] netDistance(int distance ,String direction, int [] a, int removeLastCommandFlag){
        direction = direction.trim();
        switch (direction){
            case "D":
                if (removeLastCommandFlag == 1) a[1] += distance;
                else a[1] -= distance;
                break;
            case "U":
                if (removeLastCommandFlag == 1) a[1] -= distance;
                else a[1] += distance;
                break;
            case "L":   //a[0] = a[0] - distance;
                if (removeLastCommandFlag == 1) a[0] += distance;
                else a[0] -= distance;
                break;
            case "R":   //a[0] = a[0] + distance;
                if (removeLastCommandFlag == 1) a[0] -= distance;
                else a[0] += distance;
                break;
        }
        return a;
    }
    static String movePlane(String command) {
        if(command.equals("")){
            return "(999,999)";
        }
        int netX = 0, netY = 0;
        int [] a = {netX, netY}; //new int[2];
        int removeLastCommandFlag = 0;
        char [] _command = command.toCharArray();
        int i = 0;
        char lastCommand = ' ';
        int lastDistance = 0;
        do{
            int distance= 0;
            String direction = "";
            if(i==0 && Character.isDigit(_command[i])){
                distance = Integer.parseInt("" + _command[i]);
                direction =  "" + _command[i+1];
                a = netDistance(distance , direction, a, removeLastCommandFlag);
                lastCommand = _command[i+1];
                lastDistance = distance;
                i+=2;
            }else if(Character.isDigit(_command[i]) && Character.isLetter(_command[i+1])){
                distance = Integer.parseInt("" + _command[i]);
                direction =  "" + _command[i+1];
                a = netDistance(distance , direction, a, removeLastCommandFlag);
                lastCommand = _command[i+1];
                lastDistance = distance;
                i+=2;
            }else if(Character.isLetter(_command[i]) && _command[i]=='X'){
                a = netDistance(lastDistance , ""+lastCommand, a, removeLastCommandFlag=1);
                i++;
            }else if(Character.isLetter(_command[i])){
                direction = "" + _command[i];
                a = netDistance(distance+1 , direction, a, removeLastCommandFlag);
                lastCommand = _command[i];
                lastDistance = distance+1;
                i++;
            }
        }while(i<_command.length);

        System.out.println("("+a[0]+", "+a[1]+")");

        return "("+a[0]+", "+a[1]+")";
    }

}




        /*char cache = ' ';
        int horizontalDistance = 0, verticalDistance = 0;
        for (int i = 0; i < command.length(); i++) {
            char c = command.charAt(i);
            int firstCharFlag = 0;
            if(i==0){
                firstCharFlag = 1;
            }
            if(command.charAt(i) == 'D'){
                if(firstCharFlag != 1 && Character.isDigit(command.charAt(i-1)) ) {
                    distDown = Integer.parseInt("" + command.charAt(i - 1));
                } else if( firstCharFlag != 1 && Character.isLetter(command.charAt(i-1))){
                    distDown++;
                }
                cache = 'D';

            }else if(command.charAt(i) == 'U'){
                if(firstCharFlag != 1 && Character.isDigit(command.charAt(i-1)) ) {
                    distUp = Integer.parseInt("" + command.charAt(i - 1));
                }else if( firstCharFlag != 1 && Character.isLetter(command.charAt(i-1))){
                    distUp++;
                }
                cache = 'U';
            }else  if(command.charAt(i) == 'L'){
                if(firstCharFlag != 1 && Character.isDigit(command.charAt(i-1)) ) {
                    distLeft = Integer.parseInt("" + command.charAt(i - 1));
                }else if( firstCharFlag != 1 && Character.isLetter(command.charAt(i-1))){
                    distLeft++;
                }
                cache = 'L';
            }else if( command.charAt(i) == 'R'){
                if(firstCharFlag != 1 && Character.isDigit(command.charAt(i-1)) ) {
                    distRight = Integer.parseInt("" + command.charAt(i - 1));
                }else if( firstCharFlag != 1 && Character.isLetter(command.charAt(i-1))){
                    distRight++;
                }
                cache = 'R';
            }else if( command.charAt(i) == 'X'){
                if(firstCharFlag != 1 && Character.isDigit(command.charAt(i-1)) ) {
                    distDown = command.charAt(i - 1);
                }
            }

            int planX = 0;
            //int planXPositive = 0;
            int planY = 0;
            //int planYPositive = 0;

            if(distLeft> distRight){
                horizontalDistance = distLeft - distRight;
                planX = -1;
            }else if (distLeft < distRight){
                horizontalDistance = distRight - distLeft;
                //planXPositive = 1;
                planX = 1;
            }else if( distLeft == distRight){
                horizontalDistance = 0;

            }


            if(distUp> distDown){
                verticalDistance = distUp - distDown;
                planY = 1;
            }else if (distUp < distDown){
                verticalDistance = distDown - distUp;
                planY = -1;
            }else if( distUp == distDown){
                verticalDistance = 0;
            }

            if(planX ==  1 && planY == 1){
                System.out.println("("+ horizontalDistance + ", " + verticalDistance +")");
            }else if(planX == -1 && planY == 1){
                System.out.println("(-"+ horizontalDistance + ", " + verticalDistance +")");
            }else if(planX == -1 && planY == -1){
                System.out.println("(-"+ horizontalDistance + ", -" + verticalDistance +")");
            }else if(planX == 1 && planY == -1){
                System.out.println("("+ horizontalDistance + ", -" + verticalDistance +")");
            }

        }
*/



/*
        //Test Code
        for ( Map.Entry<Integer, String> entry : distanceDirectionMap.entrySet()) {
            System.out.println(entry.getKey() +  entry.getValue() );
        }
*/



