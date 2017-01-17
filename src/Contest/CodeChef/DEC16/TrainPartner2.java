package Contest.CodeChef.DEC16;


/**
 * Created by Nikhi on 12/2/2016.
 */
public class TrainPartner2 {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        int testCases = sc.nextInt();
        int[] berthNumbers = new int[testCases];
        for (int i = 0; i < testCases; i++) {
            berthNumbers[i] = sc.nextInt();
        }
        findPartner(berthNumbers);
    }
    private static void findPartner(int[] berthNumbers){
        for (int i = 0; i < berthNumbers.length; i++) {
            int nextBerth = getPair(berthNumbers[i]);
            System.out.println(nextBerth + getNextBirthString(nextBerth));
        }
    }
    private static int getPair(int berthNumber){
        int berth = berthNumber%8;
        int multiplier = berthNumber/8;
        if(berth== 7 || berth == 0){ //case 0->7, 7->0
            return 8 * multiplier + (berth == 7 ? 8 : -1);  //Pairs are: 7-8, 8(0)-7
        }else if(berth >=4){ //case 4->1, 5->2, 6->3
            return (8 * multiplier + (berth-3));
        }
        return (8 * multiplier + (berth+3));
    }
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
