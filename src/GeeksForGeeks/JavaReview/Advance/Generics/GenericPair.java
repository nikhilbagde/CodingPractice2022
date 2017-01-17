package GeeksForGeeks.JavaReview.Advance.Generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Nikhil on 1/8/2017 2:35 PM.
 */
public class GenericPair<A,B> {
    A obj1;
    B obj2;

    public GenericPair() {
    }

    public GenericPair(A obj1, B obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    @Override
    public String toString() {
        return "{" + obj1 + " " + obj2 + '}'+ "\n";


    }

    public static void main(String[] args) {
        GenericPair<Integer, Integer> pair = new GenericPair<>(1,3);
        List<GenericPair> listOfPair = new ArrayList<>();

        for (int i = 0; i < 10 ; i++) {
            listOfPair.add(new GenericPair<>(new Random().nextInt(), new Random().nextInt()));
        }
        System.out.println(listOfPair);
    }
}
