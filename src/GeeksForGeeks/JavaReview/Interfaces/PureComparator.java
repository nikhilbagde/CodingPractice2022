package GeeksForGeeks.JavaReview.Interfaces;

import java.util.*;

/**
 * Created by Nikhil on 1/8/2017 9:49 AM.
 */
class N {
    private double rating;
    private int number;
    private String name;

    public N(double rating, int number, String name) {
        this.rating = rating;
        this.number = number;
        this.name = name;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "N{" + "R=" + rating + ", num=" + number +  ", N='" + name + '\'' +'}' + "\n";
    }
}

class ByRating implements Comparator<N>{
    @Override
    public int compare(N o1, N o2) {        //reversed rating
        return o1.getRating() > o2.getRating() ? 1 : (o1.getRating() < o2.getRating() ? -1 : 0);
    }
}

class ByName implements Comparator<N>{
    @Override
    public int compare(N o1, N o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

class ByNumber implements Comparator<N>{
    @Override
    public int compare(N o1, N o2){
        return o1.getNumber() > o2.getNumber() ? 1 : (o1.getNumber() < o2.getNumber() ? -1 : 0);
    }
}
class ByRatingReverse implements Comparator<N>{
    @Override
    public int compare(N o1, N o2) {        //reversed rating
        return o1.getRating() > o2.getRating() ? -1 : (o1.getRating() < o2.getRating() ? 1 : 0);
    }
}

class ByNameReverse implements Comparator<N>{
    @Override
    public int compare(N o1, N o2) {
        return o2.getName().compareTo(o1.getName());
    }
}

class ByNumberReverse implements Comparator<N>{
    @Override
    public int compare(N o1, N o2){
        return o1.getNumber() > o2.getNumber() ? -1 : (o1.getNumber() < o2.getNumber() ? 1 : 0);
    }
}
public class PureComparator {
    public static void main(String[] args) {
        List<N> list = new ArrayList<>();
        list.add(new N(9.0, 4,"Nikhil"));
        list.add(new N(9.1, 6,"Pratik"));
        list.add(new N(9.2, 1,"Sushil"));
        list.add(new N(9.3, 2,"Mohan"));
        list.add(new N(9.4, 3,"Gaju"));
        list.add(new N(9.5, 5,"Amey"));

        System.out.println("Original List \n" + list);

        Collections.sort(list, new ByName());
        System.out.println("Sorting by Name \n" + list);   //internally its list.toString();
        //System.out.println(Arrays.deepToString(list.toArray()));

        Collections.sort(list, new ByRating());         //reversed rating
        System.out.println("Sorting by Rating \n" + list);

        Collections.sort(list, new ByNumber());
        System.out.println("Sorting by Number \n" + list);  //list.toString()


        //To reverse Order Two Cases
        //1. Create New Class, Implement comparator and overrider compare method with reverse logic
        //2. If you already have natural sorting custom comparator class defined
            //use that class, to create a  new comaprator using, Collections.reverseOrder( Object of natural order Comparator class)
            // and then use above object to Collections.sort( CollectionName, Comparator Object from above)


        //Way 1:
        //ReverseOrder Comparator
        Comparator<N> reverseOrderByName = Collections.reverseOrder(new ByName());
        Comparator<N> reverseOrderByRating = Collections.reverseOrder(new ByRating());
        Comparator<N> reverseOrderByNumber = Collections.reverseOrder(new ByNumber());

        list.sort(reverseOrderByName); //or can use listNameItself.sort().
        System.out.println("Reverse Sorting by Name (Collection.reverseOrder())\n" + list);

        Collections.sort(list, reverseOrderByRating);
        System.out.println("Reverse Sorting by Rating (Collection.reverseOrder()) \n" + list);

        Collections.sort(list, reverseOrderByNumber);
        System.out.println("Reverse Sorting by Number (Collection.reverseOrder()) \n" + list);


        //Way 2:
        Collections.sort(list, new ByRatingReverse());
        System.out.println("Reverse Order by Rating (Creating Class imp Comparator) \n " + list);
        Collections.sort(list, new ByNameReverse());
        System.out.println("Reverse Order by Name (Creating Class imp Comparator) \n " + list);
        Collections.sort(list, new ByNumberReverse());
        System.out.println("Reverse Order by Number (Creating Class imp Comparator) \n " + list);
    }
}
