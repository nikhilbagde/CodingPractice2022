package Contest.CodeChef.DEC16;


import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Nikhi on 12/2/2016.
 */
public class TrainPartner {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        int[] berthNumbers = new int[testCases];
        for (int i = 0; i < testCases; i++) {
            berthNumbers[i] = sc.nextInt();
        }

        //int[] pairs = findPartner(berthNumbers);
        findPartner(berthNumbers);
    }
    /*
    3UB   |  6UB
    2MB   |  5MB
    1LB   |  4LB
    7SL   |  8SU
    Input: 3 1 5 3
    Output: 4LB 2MB 6UB      */
    private static void findPartner(int[] berthNumbers){
        //int[] pairs = new int[berthNumbers.length];
        //Map<Integer, String> fixedBerthLetter = getBerthLetters();
        for (int i = 0; i < berthNumbers.length; i++) {
            int nextBerth = getPair(berthNumbers[i]);
            //String nextBerthString = nextBerth + getNextBirthString(nextBerth);
            System.out.println(nextBerth + getNextBirthString(nextBerth));
        }

        //return pairs;
    }
    /*private static Map<Integer, String> getBerthLetters(){
        Map<Integer,String> map = new LinkedHashMap<>();
        map.put(1,"LB");        //9     %8=1
        map.put(2,"MB");        //10    %8=2
        map.put(3,"UB");        //11    %8=3
        map.put(4,"LB");        //12    %8=4
        map.put(5,"MB");        //13    %8=5
        map.put(6,"UB");        //14    %8=6
        map.put(7,"SL");        //15    %8=7
        map.put(8,"SU");        //16    %8=0
        return map;
    }*/
    private static int getPair(int berthNumber){
        //Map<Integer,Integer> map = getFixedPair();
        //getModValue first [0-7]
        int berth = berthNumber%8;
        int multiplier = berthNumber/8;
        if(berth== 7 || berth == 0){ //case 0->7, 7->0
            return 8 * multiplier + (berth == 7 ? 8 : -1);  //Pairs are: 7-8, 8(0)-7
        }else if(berth >=4){ //case 4->1, 5->2, 6->3
            return (8 * multiplier + (berth-3));
        }
        //for <4, we just add 3 to get its pair.  1-4,2-5,3-6
        return (8 * multiplier + (berth+3));
    }
    /*private static Map<Integer,Integer> getFixedPair(){
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1,4);
        map.put(2,5);
        map.put(3,6);
        map.put(7,8);
        return map;
    }*/
    private static String getNextBirthString(int nextBerth){
        int mod = nextBerth%8;
        if(mod == 7 || mod == 0){
            return mod==7 ? "SL": "SU";
        }else if(mod == 1 || mod ==4){
            return "LB";
        }else if(mod == 2 || mod == 5){
            return "MB";
        }
        return "UB";
    }
}
