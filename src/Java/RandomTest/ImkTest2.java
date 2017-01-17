package Java.RandomTest;

import java.util.Calendar;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by Nikhil on 1/4/2017 4:24 AM.
 */
public class ImkTest2 {
    public static void main (String[] args) {
        /*SortedSet<Element> s = new TreeSet<Element>();
        s.add(new Element(15));
        s.add(new Element(10));
        s.add(new Element(25));
        s.add(new Element(10));
        System.out.println(s.first() + " " + s.size());*/

       System.out.println(String.format("Local time: %tH:%tM:%tS", Calendar.getInstance(),Calendar.getInstance(),Calendar.getInstance()));
    //    /*B.*/	System.out.println(String.format("Local time: %1$tB", Calendar.getInstance()));
       // /*C.*/	System.out.println(String.format("Local time: %tT", Calendar.getInstance().toString()));
       // /*D.*/	System.out.println(String.format("Local time: %1$", Calendar.getInstance()));
       // /*E.*/	System.out.println(String.format("Local time: %tT", Calendar.getInstance()));

    }
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
