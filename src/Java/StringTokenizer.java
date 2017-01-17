package Java;

/**
 * Created by Nikhil on 1/7/2017 4:26 AM.
 */
public class StringTokenizer {
    public static void main(String[] args) {
        String name = "Pratik lost his     concentration";
        String name1 = "Pratik :lo:st hisconc:entration";
        String name2 = "Pratikl:osthi:sconcen:tra:tion";

        java.util.StringTokenizer stringTokenizer = new java.util.StringTokenizer(name, " ");
        String a = "Nikhil";

        while(stringTokenizer.hasMoreTokens())
            System.out.println(stringTokenizer.nextToken());

        System.out.println("---------");
        stringTokenizer = new java.util.StringTokenizer(name1, ":");
        while(stringTokenizer.hasMoreTokens())
            System.out.println(stringTokenizer.nextToken());

        System.out.println("---------");
        stringTokenizer = new java.util.StringTokenizer(name1, "\n");
        while(stringTokenizer.hasMoreTokens())
            System.out.println(stringTokenizer.nextToken());


        System.out.println("---------");
        stringTokenizer = new java.util.StringTokenizer(name2, ":", true);
        while(stringTokenizer.hasMoreTokens())
            System.out.println(stringTokenizer.nextToken());

    }
}
