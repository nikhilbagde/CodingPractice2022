package CompanyCompetetions.Yahoo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Nikhi on 11/29/2016.
 */
public class FantacyScoreSort {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        HashMap<Integer, Integer> pointMap = new HashMap<>();

        //while(!(s = sc.nextLine()).equals("")){
        while(!(s = bf.readLine()).equals("")){
            if(!s.equals("PRINT")) {
                String[] players = s.split(",");
                int playerId = Integer.parseInt(players[0]);
                int rushingYard = Integer.parseInt(players[1]);
                int passingYard = Integer.parseInt(players[2]);
                int passingTDS = Integer.parseInt(players[3]);
                int interceptions = Integer.parseInt(players[4]);

                int points = (rushingYard * 2) + passingYard + (passingTDS * 6) - interceptions;
                pointMap.put(playerId, points);
            }else{
                TreeMap<Integer, Integer> sortedMap = sortMapByValue(pointMap);
                Map<Integer, Integer> treeMap = new TreeMap<>(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        if(pointMap.get(o1) > pointMap.get(o2)){    //map.get(o1) -> gives points for player 1
                            return -1;
                        }else if(pointMap.get(o1) < pointMap.get(o2)){
                            return 1;
                        }else if(pointMap.get(o1).equals(pointMap.get(o2))){
                            //o1 and o2 are nothing but playerId
                            //it was given when both the values are same then
                            // sort on player Id ranking in ascending.
                            if(o1 > o2) return 1;
                        }
                        return -1;
                    }
                });
                treeMap.putAll(pointMap);
                int rank = 0;
                System.out.println("Leaders");
                int counter = 0;
                for (Map.Entry<Integer,Integer> entry: treeMap.entrySet()) {
                    if(counter<10)
                        System.out.println(++rank + "," + entry.getKey()+ ","+ entry.getValue());
                    counter++;
                }

            }
        }



    }
    private static TreeMap<Integer, Integer> sortMapByValue(HashMap<Integer, Integer> map){
        Comparator<Integer> comparator = new ValueComparator(map);
        TreeMap<Integer, Integer> result = new TreeMap<Integer, Integer>(comparator);
        result.putAll(map);
        return result;
    }

    private static class ValueComparator implements Comparator<Integer>{
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        ValueComparator(HashMap<Integer, Integer> map){
            this.map.putAll(map);
        }

        @Override
        public int compare(Integer s1, Integer s2) {
            if(map.get(s1) >= map.get(s2)){
                return -1;
            }else{
                return 1;
            }
        }
    }
}
/*class SortByScore implements Comparator<Integer>{

    @Override
    public int compare(Integer o1, Integer o2) {
        return 0;
    }
}*/
/*
108,90,287,0,0
109,31,137,2,0
110,31,226,4,3
PRINT
 */