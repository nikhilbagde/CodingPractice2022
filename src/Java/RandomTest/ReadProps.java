package Java.RandomTest;
import java.util.*;
import java.io.*;
public class  ReadProps {
public static void main(String[] args)throws Exception {
        Properties p = new Properties();
        p.load(new FileInputStream("C:\\Users\\Nikhi\\Google Drive\\IdeaProjects\\HackerRank\\src\\JavaReview\\RandomTest\\props.properties"));
        String a = p.getProperty("a");
        Integer b = new Integer(p.getProperty("b"));
        System.out.println(a + b);
        }
}
