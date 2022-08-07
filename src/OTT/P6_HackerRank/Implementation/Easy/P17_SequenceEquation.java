package OTT.P6_HackerRank.Implementation.Easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P17_SequenceEquation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numbers = scanner.nextInt();
        int[] p = new int[numbers];
        for (int i = 0; i < numbers; i++) {
            int num = scanner.nextInt();
            p[i] = num;
        }
        int[] ans = permutationEquation(p);
        //System.out.println(Arrays.toString(ans));
    }
    static int[] permutationEquation(int[] p) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < p.length; i++) {
            map.put(p[i], i+1);
        }
        System.out.println(map);

        int [] ans = new int[p.length];
        for (int i = 0; i < p.length; i++) {
            ans[i] = map.get(map.get(i+1));
            System.out.println(ans[i]);
        }

        return ans;
    }
}
