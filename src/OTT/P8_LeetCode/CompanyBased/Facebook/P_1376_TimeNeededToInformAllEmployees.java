package LeetCode.CompanyBased.Facebook;

import java.util.*;

/**
 * @author Nikhil Bagde
 * @date 4/24/2021- 8:14 PM
 **/
public class P_1376_TimeNeededToInformAllEmployees {
    public static void main(String[] args) {

        /*
        n 6
         hId 2
        man[2,2,-1,2,2,2]
        tim [0,0,1,0,0,0]
         */
        int n = 6;
        int headId = 2;
        int [] manager = {2,2,-1,2,2,2};
        int [] informTime = {0,0,1,0,0,0};
        numOfMinutes(n,headId,manager,informTime);
    }
    public static int numOfMinutes2(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int curManager = manager[i];
            if (curManager >= 0) {
                Set<Integer> set = map.getOrDefault(curManager, new HashSet<>());
                set.add(i);
                map.put(curManager, set);
            }
        }
        int minutes = 0;
        Queue<Integer> employeeQueue = new LinkedList<>();
        Queue<Integer> timeQueue = new LinkedList<>();
        employeeQueue.offer(headID);
        timeQueue.offer(0);
        while (!employeeQueue.isEmpty()) {
            int employee = employeeQueue.poll();
            int time = timeQueue.poll();
            minutes = Math.max(minutes, time);
            int totalTime = time + informTime[employee];
            Set<Integer> subordinates = map.getOrDefault(employee, new HashSet<>());
            for (int subordinate : subordinates) {
                employeeQueue.offer(subordinate);
                timeQueue.offer(totalTime);
            }
        }
        return minutes;
    }
    public static int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {


        //create a map of manager to his subordinates as Integer <-> Set<Integer>
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int curManager = manager[i];
            if(curManager>=0){
                Set<Integer> subOrdinates = map.getOrDefault(curManager, new HashSet<>());
                subOrdinates.add(i);            // notice not adding curManager but ith index
                map.put(curManager, subOrdinates);
            }
        }

        int mintues = 0;
        ///BFS
        mintues = BFS(headID, informTime, map);
        System.out.println("mintues = " + mintues);
        //DFS
        mintues = DFS(headID, informTime, map);
        System.out.println("mintues = " + mintues);
        return mintues;

    }

    private static int BFS(int headID, int[] informTime, Map<Integer, Set<Integer>> map) {
        int minutes = 0;

        Queue<Integer> empQ = new LinkedList<>();
        Queue<Integer> timeQ = new LinkedList<>();

        empQ.offer(headID);
        timeQ.offer(0);

        while(!empQ.isEmpty()){
            int employee = empQ.poll();
            int time =  timeQ.poll();
            minutes = Math.max(time, minutes);

            int totalTime = time + informTime[employee];
            Set<Integer> subordinates = map.getOrDefault(employee, new HashSet<Integer>());
            for(int subOrdinate : subordinates){
                empQ.offer(subOrdinate);
                timeQ.offer(totalTime);  //minutes + informTime[employee]
            }
        }
        return minutes;
    }

    private static int DFS(int headID, int[] informTime, Map<Integer, Set<Integer>> map) {
        int minutes = 0;
        for( int emp : map.getOrDefault(headID, new HashSet<>()) ){
            minutes = Math.max(minutes,  DFS(emp, informTime, map));
        }
        return minutes + informTime[headID];
    }
}
