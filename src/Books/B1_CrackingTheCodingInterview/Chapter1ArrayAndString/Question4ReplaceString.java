package Books.B1_CrackingTheCodingInterview.Chapter1ArrayAndString;

/**
 * Created by Nikhi on 10/26/2016.
 */
public class Question4ReplaceString {
    public static void main(String[] args) {
        String str = "abc d e f";
        //replaceSpace(str.toCharArray(), str.length());
        String str1 = str.replaceAll("\\s+","%20");
        String str2 = str.replaceAll("\\s", "a");

        System.out.println(str1);

    }
    public static void replaceSpace(char [] arr, int length){
        //Put counter for space count
        int spaceCount = 0;
        for (char a: arr) {
            if(a == ' '){
                spaceCount++;
            }
        }
        int newLength =  length + spaceCount *2 + 1;

        arr[newLength]  ='\0';
        for (int i = arr.length - 1 ; i > 0; i--) {
            if(arr[i] == ' '){
                arr[newLength-1] = '0';
                arr[newLength-2] = '2';
                arr[newLength-3] = '%';
                newLength -=3;
            }else{
                arr[newLength - 1] = arr[i];
                newLength -=1;
            }
        }
    }
}
