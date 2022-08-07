package OTT.P7_GeeksForGeeks.JavaReview.Collections;

import java.util.*;

/**
 * Created by Nikhil on 1/20/2017 6:45 AM.
 */
public class NavigableMaps {
    public static void main(String[] args) {
        Map<Integer, String> map1 = new HashMap<>();
        map1.put(5,"Sushil");
        map1.put(2,"Mohan");
        map1.put(4,"Gaju");
        map1.put(6,"Nikhil");
        map1.put(3,"Amey");
        map1.put(1,"Pratik");
        map1.put(0,"Tanishq");
        System.out.println(map1);

        System.out.println("\nPrinting Keys");
        for (Integer ele: map1.keySet()) {
            System.out.print(ele + " ");
        }

        System.out.println("\nPrinting values");
        for (String ele: map1.values()) {
            System.out.print(ele + " ");
        }

        System.out.println("\nPrinting keys + values");
        for (Map.Entry<Integer, String> entry : map1.entrySet()) {          //Map.Entry<,> name
            System.out.print(entry + " ");
        }

        //LinkedHashMap
        System.out.println("\n\n#######LinkedhashMap#########");
        Map<Integer, String> map2 = new LinkedHashMap<>();
        map2.put(5,"Sushil");
        map2.put(2,"Mohan");
        map2.put(4,"Gaju");
        map2.put(6,"Nikhil");
        map2.put(3,"Amey");
        map2.put(1,"Pratik");
        map2.put(0,"Tanishq");


        System.out.println(map2);

        System.out.println("\nPrinting Keys");
        for (Integer ele: map2.keySet()) {
            System.out.print(ele + " ");
        }

        System.out.println("\nPrinting values");
        for (String ele: map2.values()) {
            System.out.print(ele + " ");
        }

        System.out.println("\nPrinting keys + values");
        for (Map.Entry<Integer, String> entry : map2.entrySet()) {          //Map.Entry<,> name
            System.out.print(entry + " ");
        }


        System.out.println("\n\n#######TreeMap#########");

        Map<Integer, String> map3 = new TreeMap<>();
        map3.put(5,"Sushil");
        map3.put(2,"Mohan");
        map3.put(4,"Gaju");
        map3.put(6,"Nikhil");
        map3.put(3,"Amey");
        map3.put(1,"Pratik");
        map3.put(0,"Tanishq");
        System.out.println(map3);

        System.out.println("\nPrinting Keys");
        for (Integer ele: map3.keySet()) {
            System.out.print(ele + " ");
        }

        System.out.println("\nPrinting values");
        for (String ele: map3.values()) {
            System.out.print(ele + " ");
        }

        System.out.println("\nPrinting keys + values");
        for (Map.Entry<Integer, String> entry : map3.entrySet()) {          //Map.Entry<,> name
            System.out.print(entry + " ");
        }

        System.out.println("\n\n#######TreeMap#########");

        TreeMap<Integer,String> temp = new TreeMap<>();
        temp.putAll(map3);
        TreeMap<Integer, String> map4 = new TreeMap<>(new sortByValue(temp));
        TreeMap<Integer, String> map5 = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map3.get(o1).compareTo(map3.get(o2));
            }
        });
        TreeMap<Integer, String> map6 = new TreeMap<>( (o1,o2) -> {
            return map3.get(o1).compareTo(map3.get(o2));
        }) ;
        map6.putAll(map3);

        map5.putAll(map3);
        map4.put(5,"Sushil");
        map4.put(2,"Mohan");
        map4.put(4,"Gaju");
        map4.put(6,"Nikhil");
        map4.put(3,"Amey");
        map4.put(1,"Pratik");
        map4.put(0,"Tanishq");
        System.out.println(map4);

        System.out.println("\nPrinting Keys");
        for (Integer ele: map4.keySet()) {
            System.out.print(ele + " ");
        }

        System.out.println("\nPrinting values");
        for (String ele: map4.values()) {
            System.out.print(ele + " ");
        }

        System.out.println("\nPrinting keys + values");
        for (Map.Entry<Integer, String> entry : map4.entrySet()) {          //Map.Entry<,> name
            System.out.print(entry + " ");
        }

        System.out.println("Map5");
        System.out.println("\nPrinting keys + values");
        for (Map.Entry<Integer, String> entry : map5.entrySet()) {          //Map.Entry<,> name
            System.out.print(entry + " ");
        }

        System.out.println("Map6");
        System.out.println("\nPrinting keys + values");
        for (Map.Entry<Integer, String> entry : map6.entrySet()) {          //Map.Entry<,> name
            System.out.print(entry + " ");
        }

    }

    static  class sortByValue implements Comparator<Integer>{
        TreeMap<Integer,String > map = new TreeMap<>();

        sortByValue(TreeMap<Integer,String > mapIn){
            this.map.putAll(mapIn);
        }
        /*
        @Override
        public int compare(String o1, String o2) {
            return map.get(o1).compareTo(map.get(o2));
        }*/

        @Override
        public int compare(Integer o1, Integer o2) {
            return map.get(o1).compareTo(map.get(o2));
        }
    }
}
