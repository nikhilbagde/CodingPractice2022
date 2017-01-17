package Java.RandomTest;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by Nikhil on 1/4/2017 3:31 AM.
 */
public class IkmTest {
    private static int count;
    static {
        System.out.println("In block 1");
        count = 10;
    }

    private int[] data;
    {
        System.out.println("In block 2");
        data = new int[count];
        for (int i = 0; i < count; i++) {
            data[i] = i;
        }
    }

    public static void main (String[] args) {
        /*System.out.println("Count = " + count);
        System.out.println("Before 1st call to new");
        IkmTest test1 = new IkmTest();
        System.out.println("Before 2nd call to new");
        IkmTest test2 = new IkmTest();
        */
        int a = 9, b = 2;
        float f;
        f = a / b;
        System.out.println("f = " + f);
        f = f / 2;
        System.out.println("f = " + f);
        f = a + b / f;
        System.out.println("f = " + f);


        /*SortedSet<Element> s = new TreeSet<Element>();
        s.add(new Element(15));
        s.add(new Element(10));
        s.add(new Element(25));
        s.add(new Element(10));
        System.out.println(s.first() + " " + s.size());*/

    }

    class Element implements Comparable {
        int id;

        Element(int id) {
            this.id = id;
        }

    public int compareTo(Object obj) {
        Element e = (Element)obj;
        return  this.id - e.id;
    }

    public String toString() {
        return "" + this.id;
    }
}

}
