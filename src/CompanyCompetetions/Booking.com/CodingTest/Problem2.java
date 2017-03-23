package CompanyCompetetions.Booking.com.CodingTest;

import java.util.*;

import static java.lang.System.in;

/**
 * Created by Nikhi on 12/7/2016.
 * To use RetainAll on list, it has to be Object of ArrayList
 * ArrayList<String> list1 = new ArrayList<>(Arrays.asList(String []))';
 * ArrayList<String> list2 = new ArrayList<>(Arrays.asList(String []))';
 * list2.retainAll(list1);
 */
public class Problem2 {
    static Map<Short, Integer> map = new TreeMap<>();
    static String[] words;

    public static void main(String[] args) {
        input();
    }

    private static void input() {
        Scanner scanner = new Scanner(in);
        words = scanner.nextLine().toLowerCase().split("\\s+");
        ArrayList<String> originalWords2 = new ArrayList<>(Arrays.asList(words));
        map = new TreeMap<>();

        int count = Integer.parseInt(scanner.nextLine());
        int frequency = 0;

        while (count-- > 0) {
            short id = Short.parseShort(scanner.nextLine());
            String[] review = scanner.nextLine().toLowerCase().replaceAll("[.,]", "").split("\\s+");
            ArrayList<String> reviewList = new ArrayList<>(Arrays.asList(review));

            reviewList.retainAll(originalWords2);
            frequency = reviewList.size();

            map.put(id, map.containsKey(id) ? map.get(id) + frequency : frequency);
        }

        TreeMap<Short, Integer> map1 = new TreeMap<>(((o1, o2) ->
                map.get(o1) > map.get(o2) ? -1 :
                        (map.get(o1) < map.get(o2) ? 1 : o1.compareTo(o2))));

        map1.putAll(map);
        System.out.println(map);
        System.out.println(map1);

        System.out.println(map1.keySet());
    }
}
/*
Input
breakfast beach citycenter location metro view staff price
5
1
This hotel has a nice view of the citycenter. The location is perfect.
2
The breakfast is ok. Regarding location, it is quite far from citycenter but price is cheap so it is worth.
1
Location is excellent, 5 minutes from citycenter. There is also a metro station very close to the hotel.
1
They said I couldn't take my dog and there were other guests with dogs! That is not fair.
2
Very friendly staff and good cost-benefit ratio. Its location is bit far from citycenter.

Output
2 1
 */
