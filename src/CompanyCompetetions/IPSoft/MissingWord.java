package CompanyCompetetions.IPSoft;

import java.util.*;

/**
 * Created by Nikhi on 11/11/2016.
 * How to convert list to Array -> list.toArray()
 * How to convert list to String of array -> list.toArray(new String[list.size])
 */
public class MissingWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = "I am using HackerRank to improve prgramming I";
        String t = "am HackerRank to improve";
        String[] missingWordsArray = missingWords(s, t);

        missingWords2(s, t);
        for (String ss: missingWordsArray) {
            System.out.println(ss);

        }
    }

    public static String[] missingWords(String s, String t){
        List<String> list = new LinkedList<>();
        String[] sArray = s.split("\\s+");
        String[] tArray = t.split("\\s+");

        int i = 0;
        for (int j = 0; j < sArray.length; j++) {
            //Iterate over SuperArray and increment index of SubArray only when match found.
            //Iterate over subArray only till its size to eliminate array out of bound exception.
            if(i< tArray.length && !sArray[j].equals(tArray[i])){
                list.add(sArray[j]);
            }else if(i >= tArray.length){                   //Done Iterating subArray ? Then
                for (int k = j; k < sArray.length; k++) {   //just copy all words to missingWord list.
                    list.add(sArray[k]);
                }
                break;
            }else{
                //There was a match.
                i++;                                        //increment subArray with SuperArray when match found
            }
        }
        return list.toArray(new String[list.size()]);
    }

    private static void missingWords2(String s, String t) {
        ArrayList<String> list1 = new ArrayList<>(Arrays.asList(s.split(" ")));
        ArrayList<String> list2 = new ArrayList<>(Arrays.asList(t.split(" ")));

        list1.removeAll(list2);
        System.out.println("Another Way:" + list1.toString());

    }
}
