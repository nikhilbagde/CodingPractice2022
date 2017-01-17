package CompanyCompetetions.WeightWatcher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Nikhi on 12/23/2016 8:01 PM'
 */
public class Problem1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String bombs1 = "..B....";
        String bombs2 = "..B.B..B";
        String bombs3 = "B.B.B.BB.";
        String bombs4 = "..B.B..B";
        String bombs5 = "..B.BB..B.B..B...";
        int force = scanner.nextInt();
        //String s = scanner.nextLine();
       // explode(bombs5.toCharArray(), force);
        explode(bombs5, force);

    }

    private static String[] explode(char[] bombs, int force){
        // "..B.BB..B.B  .  .  B  .  .  ."
        //  012345678910 11 12 13 14 15
        //char[] bombsArr = bombs.toCharArray();
        String[] result = new String[100];
        int left = -1, right= -1, i= 0;
        boolean firstIterationDone= false;
        while(!allBombDiffused(bombs)) {
            firstExplosion(bombs, force);
            //Now we only have to deal with < > and x  | ".<.X<>><.X.><.>..",
            for (int index = 0; index < bombs.length; index++) {
                if (bombs[index] == '.' /*|| bombs[index] == '<' || bombs[index] == '>'*/) continue;
                if (bombs[index] == 'B') {
                    if(index-force < 0 || index+ force > bombs.length) {
                        bombs[index] = '.';
                        continue;
                    }
                    if(index-force>=0) left = index - force;
                    if( index+force < bombs.length) right = index + force;
                    if (left >= 0) {        //left position
                        bombs[left] = (bombs[left] == '>') ? 'x' : '<';
                    }
                    if (right < bombs.length) {
                        bombs[right] = (bombs[right] == '<') ? 'x' : '>';
                    }
                    bombs[index] = '.';
                    continue;
                }
                //if(index == bombs.length-1)firstIterationDone = true;

                //move < to force times left
                if(firstIterationDone && bombs[index] == '<'){
                    if(index-force < 0){
                        bombs[index] = '.';
                    }else if(index-force >0){       //still in bound
                        bombs[index-force] = bombs[index-force] == '>' ? 'x' : '<';
                        bombs[index] = '.';
                    }
                }

                //move > to force times right
                if(firstIterationDone && bombs[index] == '>'){
                    if(index+force > bombs.length){
                        bombs[index] = '.';
                    }else if(index+force < bombs.length){       //still in bound
                        bombs[index+force] = bombs[index+force] == '<'? 'x' : '>';
                        bombs[index] = '.';
                    }
                }
            }
            firstIterationDone = true;
            result[i++] = Arrays.toString(bombs);
        }
        return result;
    }
    private static boolean allBombDiffused(char[] bombs){
        for (char bomb : bombs) {
            if (bomb != '.') return false;
        }
        return true;
    }
    private static char[] firstExplosion(char[] bombs, int force){
        //removing all B's first
        for (int location = 0; location < bombs.length; location++) {
            //for every B find left and right index of effect.
            if(bombs[location] == 'B'){
                if(isLeftBound(location, force)){
                    bombs[location-force] = bombs[location-force]== '>' ? 'x' : '<';
                }
                if(isRightBound(location, force, bombs.length)){
                    bombs[location+force] = bombs[location+force]== '<' ? 'x' : '>';
                }
                bombs[location] = '.';
            }
        }
        return bombs;
    }
    private static boolean isLeftBound(int currentLocation, int force){
        return currentLocation-force >= 0;
    }
    private static boolean isRightBound(int currentLocation, int force, int max){
        return currentLocation+force < max;
    }
    private static void explode(String bombs, int force){
        List<Integer> listOfBombIndex = new ArrayList<>();
        char [] bombsA = bombs.toCharArray();
        char [] newBomb = new char[bombs.length()];
        for (int position = 0; position < bombsA.length; position++) {
            if(bombsA[position] == 'B'){
                if(isLeftBound(position, force)){
                    newBomb[position-force] = newBomb[position-force]== '>' ? 'x' : '<';
                }
                if(isRightBound(position, force, bombsA.length)){
                    newBomb[position+force] = newBomb[position+force]== '<' ? 'x' : '>';
                }
                newBomb[position] = '.';
            }else {
                //newBomb[position] = '.';
            }
        }
    }
}


    /*
                            explode("..B.BB..B.B..B...", 1)
                    Returns:
                    ["..B.BB..B.B..B...",
                    ".<.X<>><.X.><.>..",
                    "<.<<>.X><.><>..>.",
                    ".<<..X.X>.<>.>..>",
                    "<<..<.X.>X..>.>..",
                    "<..<.<.><>>..>.>.",
                    "..<.<..<>.>>..>.>",
                    ".<.<..<..>.>>..>.",
                    "<.<..<....>.>>..>",
                    ".<..<......>.>>..",
                    "<..<........>.>>.",
                    "..<..........>.>>",
                    ".<............>.>",
                    "<..............>.",
                    "................>",
                    "................."]
                             */
