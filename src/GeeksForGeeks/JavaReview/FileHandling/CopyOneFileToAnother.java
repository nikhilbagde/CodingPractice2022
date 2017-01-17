package GeeksForGeeks.JavaReview.FileHandling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Nikhil on 1/8/2017 1:16 PM.
 */
public class CopyOneFileToAnother {
    public static void main(String[] args) throws IOException {
        FileInputStream fio = new FileInputStream("C:\\Users\\Nikhi\\Desktop\\input.txt");
        FileOutputStream fout = new FileOutputStream("C:\\Users\\Nikhi\\Desktop\\output.txt");

        int line;
        while( (line = fio.read())!= -1){
            fout.write(line);
        }
        fio.close();
        fout.close();
    }
}
