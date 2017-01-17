package GeeksForGeeks.JavaReview.Interfaces;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Nikhil on 1/8/2017 9:42 AM.
 */
class O implements Comparable<O>
{
    private double rating;
    private String name;
    private int year;

    // Used to sort movies by year
    public int compareTo(O m){
        return this.year - m.year;
    }

    // Constructor
    public O(String nm, double rt, int yr)
    {
        this.name = nm;
        this.rating = rt;
        this.year = yr;
    }

    // Getter methods for accessing private data
    public double getRating() { return rating; }
    public String getName()   {  return name; }
    public int getYear()      {  return year;  }
}
public class PureComparable {
    public static void main(String[] args) {
        ArrayList<O> list = new ArrayList<O>();
        list.add(new O("Force Awakens", 8.3, 2015));
        list.add(new O("Star Wars", 8.7, 1977));
        list.add(new O("Empire Strikes Back", 8.8, 1980));
        list.add(new O("Return of the Jedi", 8.4, 1983));

        Collections.sort(list);         //sorted by natural order of year.
                                        //as compareTo uses Year

        System.out.println("Movies after sorting : ");
        for (O movie: list)
        {
            System.out.println(movie.getName() + " " +
                    movie.getRating() + " " +
                    movie.getYear());
        }
    }
}
