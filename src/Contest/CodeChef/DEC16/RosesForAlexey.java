package Contest.CodeChef.DEC16;

import java.util.*;

/**
 * Created by Nikhi on 12/2/2016.
 */
public class RosesForAlexey {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        int testCases = sc.nextInt();
        for (int i = 0; i < testCases ; i++) {
            int totalRoses = sc.nextInt();
            int oneSetOfRoses = sc.nextInt();
            int[] rosesArray = new int[totalRoses];
            HashMap<Integer,Integer> numberFrequency = new HashMap<>();
            int minRose = 0;

            //Initial Setup of array and Map
            for (int rosesIndex = 0; rosesIndex < totalRoses; rosesIndex++) {
                rosesArray[rosesIndex] = sc.nextInt();
                if(rosesIndex == 0) minRose = rosesArray[rosesIndex];
                if(rosesArray[rosesIndex]< minRose) minRose = rosesArray[rosesIndex];
                if(!numberFrequency.containsKey(rosesArray[rosesIndex])){
                    numberFrequency.put(rosesArray[rosesIndex], 1);
                }else{
                    numberFrequency.put(rosesArray[rosesIndex], numberFrequency.get(rosesArray[rosesIndex])+1);
                }
            }
            //Sort TreeMap on values
            SortedMap<Integer,Integer> sortedOnFrequency = new TreeMap<>(new SortOnValues(numberFrequency) );
            sortedOnFrequency.putAll(numberFrequency);
            //System.out.println(sortedOnFrequency);

            int [] newArray = new int[totalRoses];
            int index = 0;
            for (Map.Entry<Integer,Integer> Entry: sortedOnFrequency.entrySet()) {
                for (int j = 0; j < Entry.getValue(); j++) {
                    newArray[index++] = Entry.getKey();
                }

            }

            //Process Array
            //getCutCount(oneSetOfRoses, rosesArray, sortedOnFrequency);
            System.out.println(getCutCount(oneSetOfRoses, newArray));


            // maximum number of sets can be made is totalRoses / oneSetOfRoses
            // We want to make those many sets but with less number of cuts as of length.

        }

    }
    private static int getCutCount(int oneSetOfRoses, int [] rosesArray, SortedMap<Integer,Integer> sortedOnFrequency){
        int possibleSet = rosesArray.length/oneSetOfRoses;
        Set<Integer> setGloble = new HashSet<>();
        Set<Integer> setSub = new HashSet<>();
        for (int roseIndex = 0; roseIndex < possibleSet; roseIndex++) {
            //get number with highest frequency.
            for (Integer keyRoseLength : sortedOnFrequency.keySet()) {
                setSub.add(keyRoseLength.hashCode());
                int count = oneSetOfRoses;
                for (Integer keyRoseLengthOther : sortedOnFrequency.keySet()) {
                    if(count ==1) break;
                    if(keyRoseLength.hashCode()!= keyRoseLengthOther.hashCode()
                            && keyRoseLengthOther>= keyRoseLength
                            && !setGloble.contains(keyRoseLengthOther.hashCode())){ //should not be already considered
                        setSub.add(keyRoseLengthOther.hashCode());
                        count--; //till only you have given set of roses in a booke.
                    }
                    //if(setSub.size()==1) setSub.clear();
                }
                setGloble.addAll(setSub);
            }
        }
        return setGloble.size();
    }
    // 2 2 5 5 1 3 4 6
    private static int getCutCount(int rosesInOneSet, int [] rosesArray){
        int possibleSet = rosesArray.length/rosesInOneSet;
        Set<Integer> indexSet = new HashSet<>();
        int cutCount =0;
        for (int roseIndex = 0; roseIndex < possibleSet; roseIndex++) {
            // 2 2 5 5 1 3 4 6
            int count = rosesInOneSet;
            for (int arrayIndex = 0; arrayIndex <= rosesArray.length - rosesInOneSet ; arrayIndex++) {
                if(indexSet.contains(arrayIndex)) continue; //already considered hence skip
                for (int arrayIndexOther = 0; arrayIndexOther < rosesArray.length; arrayIndexOther++) {
                    if(indexSet.contains(arrayIndexOther)) continue; //already considered hence skip
                    if(arrayIndex!= arrayIndexOther
                            && rosesArray[arrayIndexOther] >= rosesArray[arrayIndex]){
                        if(count == 1){
                            break;
                        }
                        if(rosesArray[arrayIndexOther]> rosesArray[arrayIndex]) cutCount++;
                        indexSet.add(arrayIndex);
                        indexSet.add(arrayIndexOther);
                        count--;
                    }
                }
            }
        }
        return cutCount;
    }

}
class SortOnValues implements Comparator<Integer>{
    SortedMap<Integer,Integer> sortedMap = new TreeMap<>();
    SortOnValues(HashMap<Integer,Integer> mapIn){
        sortedMap.putAll(mapIn);
    }
    @Override
    public int compare(Integer o1, Integer o2){
        return sortedMap.get(o1) > sortedMap.get(o2) ? -1 : 1;
    }
}

/*
8 4
1 2 2 3 4 5 5 6  8/4 = 2 sets can be made.
//Sort array in ascending order.
start with first element, delete first element value from array for total number of sets element in array (4)
[find 4 element which are greater than this first element].
 Now negate value of 1st element from rest 4. (count = 3)
 those indices cant be use again
(count number other than it decreased)

Sort the array.
0. run it for 2 iterations (8/4) only
1. Pick the first element. (lowest after sorting)
2. another for loop, count 3 other elements which are greater than first element.
3. Put indices of those element to a set. including first.
4. break inner for loop
5. Other for loop look for next min which is not in set.
6. Step 3 : another for loop, count 3 other elements which are greater than first element.


1. find frequency of number.
2. number with higher frequency would require less cuts as its already have higher frequency.
3. Start from number with highest frequency.

 */