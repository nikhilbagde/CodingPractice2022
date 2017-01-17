package CompanyCompetetions.Audible;

import java.util.*;

/**
 * Created by Nikhi on 12/1/2016.
 */
public class ZombieClustering {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        //int[][] array = new int[n][n];
        String[] strArray = new String[n];
        for (int i = 0; i < n; i++) {
            strArray[i] = sc.next();
        }
        System.out.println(zombieCluster(strArray));

    }
    static int zombieCluster(String[] zombies) {

        Set<Integer> cluster =new HashSet<>();

        //int[][] array = new int[zombies.length][zombies.length];
        for (int i = 0; i < zombies.length; i++) {
            String str = zombies[i];
            for (int j = 0; j < str.length(); j++) {
                if(i!=j && str.charAt(j)=='1'){
                    cluster.add(i);
                    cluster.add(j);

                }
                //array[i][j] = str.charAt(j);
            }
        }
        if(cluster.size()==0){
            return zombies.length;
        }
        return zombies.length - cluster.size() +1;

    }
}
