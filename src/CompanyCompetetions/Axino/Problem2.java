package CompanyCompetetions.Axino;

import com.sun.org.apache.xml.internal.resolver.readers.SAXCatalogParser;

import java.util.Scanner;

/**
 * Created by Nikhi on 4/27/2017.
 */
public class Problem2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int [] array = new int[N];
        for (int i = 0; i < M; i++) {
            int a = scanner.nextInt()-1;
            int b = scanner.nextInt()-1;
            int k = scanner.nextInt();
            for (int j = a; j <=b ; j++) {
                array[j] = array[j] + k;
            }
        }
        int totalSum = 0;
        for (int i = 0; i < array.length; i++) {
            totalSum += array[i];
        }
        System.out.println(totalSum/array.length);

    }
}
