package Java.JavaInterviewBook;

import java.util.*;

/**
 * Created by Nikhil on 3/4/2017 3:45 AM.
 */
public class Q17_JavaBestPratices {
    //Aware while using set on collections
    private Set<String> set1 = new HashSet<>();

    public static void main(String[] args) {
        //instead of using null use
        List list = Collections.EMPTY_LIST;
        Set set = Collections.EMPTY_SET;
        Map<Integer, String> map = Collections.EMPTY_MAP;

        //Use ArrayList or HashMap opposite to Vectors Hashtables
        //how to synchronize these

        List listSynchronized = Collections.synchronizedList(list);
        Map mapSynch = Collections.synchronizedMap(map);


    }

    //exposes to world
    public Set<String> getXXX() {
        return set1;
    }

    //exposes to world
    public void setXXX(Set<String> set) {
        this.set1 = set;
    }

    //Better approach.
    public void addXXX(String car) {
        set1.add(car);
    }

    public void removeXXX(String car) {
        set1.remove(car);
    }

    public Set<String> getXXXEfficient() {
        //use factory method .... This will handle thread problems.
        return Collections.unmodifiableSet(set1);
    }

}
