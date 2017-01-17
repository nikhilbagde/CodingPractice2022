package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Nikhi on 11/9/2016.
 */
public class ACM1 {
    public static void main(String[] args) throws IOException {
        //Scanner sc = new Scanner(System.in);
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> map = new HashMap<>();
        String line;

        int counter = 1;

        line  = bf.readLine();
        line = line.replaceAll(" ", "");
        char[] array = line.toCharArray();

        for (int i = 0; i < array.length; i++) {
            map.put(counter++, Character.getNumericValue(array[i]));
        }
        //System.out.println(map);

        List<Integer> list = new LinkedList<>();
        list.add(1);
        findroute(map.get(1), map, list);
        int flag = 0;
        for (int i = 0; i < array.length; i++) {

            if(!(list.contains(Character.getNumericValue(array[i])))){
                flag = 1;
                System.out.println("NO");
                break;
            }
        }
        if(flag != 1){
            for ( int a: list) {
                System.out.print(a + " ");
            }
        }

    }

    public static List<Integer> findroute(int value, Map<Integer,Integer> map, List<Integer> list) {
        if (value == 1) {
            return list;
        }
        list.add(value);
        findroute(map.get(value), map, list);
        return list;
    }

}

