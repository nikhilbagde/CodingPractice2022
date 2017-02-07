package ProjectEuler.Set3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;
import static java.lang.System.out;

/**
 * Created by Nikhil on 2/6/2017 4:54 AM.
 */
public class P23NonAbundantSums {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        int T = parseInt(reader.readLine());
        while (T-- > 0) {
            int N = parseInt(reader.readLine());
            int result = 1;
            out.println("result = " + result);
        }
    }
}
