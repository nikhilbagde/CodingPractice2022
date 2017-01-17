package DataStructure.MyDataStructures.Recursion;

/**
 * Created by Nikhil on 12/27/2016 3:18 PM.
 */
public class EnglishRuler {
    public static void main(String[] args) {
        int nInches = 2;        //total count
        int majorLengthOfTick = 5;
        drawRuler(nInches,majorLengthOfTick );
    }
    private static void drawRuler(int nInches, int majorLength){
        drawLine(majorLength, 0);
        for (int inch = 1; inch < nInches; inch++) {
            drawInterval(majorLength-1);
            drawLine(majorLength, inch);
        }
    }
    private static void drawLine(int tickLength, int label){
        for (int i = 0; i < tickLength; i++) {
            System.out.print("-");
        }
        if(label>=0)
            System.out.print(" " + label);
        System.out.println();
    }
    private static void drawInterval(int centralLength){
        if(centralLength>=1){       //otherwise do nothing.
            drawInterval(centralLength-1);
            drawLine(centralLength, -1);
            drawInterval(centralLength-1);
        }
    }
    private static void drawLine(int tickLength){
        drawLine(tickLength, -1);   //No label.
    }
}
