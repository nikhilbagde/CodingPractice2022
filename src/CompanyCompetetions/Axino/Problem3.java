package CompanyCompetetions.Axino;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Nikhi on 4/27/2017.
 */
public class Problem3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        List<Integer> list = new ArrayList<>(Collections.nCopies(N, 0));

        for (int i = 0; i < M; i++) {
            int a = scanner.nextInt()-1;
            int b = scanner.nextInt()-1;
            int k = scanner.nextInt();
            for (int j = a; j <=b ; j++) {
                list.set(j, list.get(j)+k);
                System.out.println(list);
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            max = Math.max(max, list.get(i));
        }
        System.out.println(max);

    }
}
