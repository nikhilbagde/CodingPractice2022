package Contest.CodeChef.DEC16;



/**
 * Created by NikhiL on 12/3/2016.
 * Sample Input:
 *  2
    8 4
    1 2 2 3 4 5 5 6
    4 4
    1 1 1 3
    Output:
    5
    1
 */
public class RosesForAlexSubmitted {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        int testCases = sc.nextInt();
        if(1<= testCases && testCases <=10) {
            for (int i = 0; i < testCases; i++) {
                int totalRoses = sc.nextInt();              //case 1 : 8
                int oneSetOfRoses = sc.nextInt();           //csae 1 : 4

                //constrain checking
                if(constrinaChecking(totalRoses, oneSetOfRoses)){
                    int[] rosesArray = new int[totalRoses];
                    java.util.HashMap<Integer, Integer> numberFrequency = new java.util.HashMap<>();
                    int minRose = 0;

                    //Initial Setup of array and Map
                    //Map created to get frequency of numbers. And then sort them according to their frequency
                    //Intention of getting freq and sorting it from highest to lowest, as we need to find min cuts
                    //words with same frequency would be together, hence can decrease possible cut length. (could be confusing!)
                    //Then convert it to array with highest to lowest frequency.
                    for (int rosesIndex = 0; rosesIndex < totalRoses; rosesIndex++) {
                        int value = sc.nextInt();
                        if(1<=value && value<= Math.pow(10,18)) {
                            rosesArray[rosesIndex] = value;                 //case 1: rosesArray =[1 2 2 3 4 5 5 6]
                            //if (rosesIndex == 0) minRose = rosesArray[rosesIndex];
                            //if (rosesArray[rosesIndex] < minRose) minRose = rosesArray[rosesIndex];
                            if (!numberFrequency.containsKey(rosesArray[rosesIndex])) {
                                numberFrequency.put(rosesArray[rosesIndex], 1); //case 1: numberFrequency = [1:1, 2:2, 3:1, 4:1, 5:2, 6:1]
                            } else {
                                numberFrequency.put(rosesArray[rosesIndex], numberFrequency.get(rosesArray[rosesIndex]) + 1);
                            }
                        }
                    }
                    //Sort TreeMap on values (frequency Highest to lowest)
                    java.util.SortedMap<Integer, Integer> sortedOnFrequency = new java.util.TreeMap<>(new SortOnValues2(numberFrequency));
                    sortedOnFrequency.putAll(numberFrequency); //case 1: [2:2, 5:2, 1:1, 3:1, 4:1, 6:1]
                    //System.out.println(sortedOnFrequency);

                    //Convert Highest to lowest frequency map to Array again.
                    int[] newArray = new int[totalRoses];
                    int index = 0;
                    for (java.util.Map.Entry<Integer, Integer> Entry : sortedOnFrequency.entrySet()) {
                        for (int j = 0; j < Entry.getValue(); j++) {
                            newArray[index++] = Entry.getKey();     // case 1: newArray[2, 2, 5, 5, 1, 3, 4, 6]
                        }

                    }

                    //Process Array
                    //getCutCount(oneSetOfRoses, rosesArray, sortedOnFrequency);
                    System.out.println(getCutCount(oneSetOfRoses, newArray));
                }
            }
        }

    }

    // 2 2 5 5 1 3 4 6
    private static int getCutCount(int rosesInOneSet, int [] rosesArray){
        int possibleSet = rosesArray.length/rosesInOneSet;
        java.util.Set<Integer> indexSet = new java.util.HashSet<>();
        int cutCount =0;
        for (int roseIndex = 0; roseIndex < possibleSet; roseIndex++) {
            // 2 2 5 5 1 3 4 6
            int count = rosesInOneSet;
            //Consider from 1st element using 2 for loops.
            for (int arrayIndex = 0; arrayIndex <= rosesArray.length - rosesInOneSet ; arrayIndex++) {
                //If its index already considered, then skip it to save computation by adding it to set which is done later.
                if(indexSet.contains(arrayIndex)) continue; //already considered hence skip
                for (int arrayIndexOther = 0; arrayIndexOther < rosesArray.length; arrayIndexOther++) {
                    if(indexSet.contains(arrayIndexOther)) continue; //already considered hence skip
                    if(arrayIndex!= arrayIndexOther     //for i!=j
                            && rosesArray[arrayIndexOther] >= rosesArray[arrayIndex]){  //consider all values which are greater or equal.
                        if(count == 1){ //we want 4 roses in 1 set. Put Counter to count that.
                            break;
                        }
                        if(rosesArray[arrayIndexOther]> rosesArray[arrayIndex]) cutCount++; //final Cut count when value is strictly greater.
                        indexSet.add(arrayIndex);       //Here save considered index.
                        indexSet.add(arrayIndexOther);
                        count--;
                    }
                }
            }
        }
        return cutCount;
    }
    private static boolean constrinaChecking(int totalRoses, int oneSetOfRoses ){
        return 2<= totalRoses && totalRoses<= Math.pow(10,5) && 1<= oneSetOfRoses && oneSetOfRoses <= totalRoses && totalRoses%oneSetOfRoses == 0;
    }
}
//Sorting of map values logic.
class SortOnValues2 implements java.util.Comparator<Integer>{
    private java.util.SortedMap<Integer,Integer> sortedMap = new java.util.TreeMap<>();
    SortOnValues2(java.util.HashMap<Integer,Integer> mapIn){
        sortedMap.putAll(mapIn);
    }
    @Override
    public int compare(Integer o1, Integer o2){
        return sortedMap.get(o1) > sortedMap.get(o2) ? -1 : 1;
    }
}

/*
Test Cases: T =10
 */