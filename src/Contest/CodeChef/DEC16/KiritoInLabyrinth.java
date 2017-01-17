package Contest.CodeChef.DEC16;

/**
 * Created by Nikhi on 12/2/2016.
 */
public class KiritoInLabyrinth {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        int testCases = sc.nextInt();
        int totalRooms = sc.nextInt();
        int[] roomArray = new int[totalRooms];
        for (int i = 0; i < testCases; i++) {
            for (int roomIndex = 0; roomIndex < totalRooms; roomIndex++) {
                roomArray[roomIndex] = sc.nextInt();
            }
            System.out.println(findPairs(roomArray));
        }

    }
    /*
    0  1 2 3 4 5 6
    13 2 8 6 3 1 9 ->5
    1 2 2 3 3 1 -> 2
     */
    private static int findPairs(int[] roomArray) throws IllegalArgumentException{
        int pairs = 0;
        /*for (int rootIndex = 0; rootIndex < roomArray.length-1; rootIndex++) {
            if(findGCD(roomArray[rootIndex],roomArray[rootIndex+1]) > 1){
                pairs++;
            }
        }*/
        int firstIndex = 0, secondIndex = 1;
        while (secondIndex< roomArray.length){
            if(findGCD(roomArray[firstIndex],roomArray[secondIndex]) > 1){
                pairs++;
                firstIndex++;       //firstIndex= secondIndex; secondIndex++
                secondIndex++;
            }else if(secondIndex-firstIndex == 1){
                secondIndex++;
            }else { //(secondIndex-firstIndex > 1){
                firstIndex++;
            }
        }
        return pairs+1;
    }
    private static int findGCD(int first, int second){
        if(second == 0){
            return first;
        }
        return findGCD(second, first%second);
    }
}
