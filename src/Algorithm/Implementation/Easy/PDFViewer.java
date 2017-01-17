package Algorithm.Implementation.Easy;

/**
 * Created by Nikhi on 12/8/2016 1:31 AM.
 */
public class PDFViewer {
    public static void main(String[] args) {
        java.util.Scanner in = new java.util.Scanner(System.in);
        int n = 26;
        int h[] = new int[n];
        for (int h_i = 0; h_i < n; h_i++) {
            h[h_i] = in.nextInt();
        }
        String word = in.next();
        /*int a = 'a';    //97
        int z = 'z';    //122
        System.out.println(a + "" +z);*/
        int maxH = getMaxHeigh(word, h);
        System.out.println(calculateArea(maxH, word.length()));

    }
    private static int getMaxHeigh(String word, int[] h){
        int maxH = 0;
        for (char c: word.toCharArray()) {
            if(h[c-97]>maxH){
                maxH = h[c-97];
            }
        }
        return maxH;
    }
    private static int calculateArea(int height, int width){
        return height*width;
    }
}
