package GeeksForGeeks.JavaReview.MethodsInJava;

/**
 * Created by Nikhil on 1/8/2017 2:31 AM.
 */
public class MultipleReturn {
    public static void main(String[] args) {
        int anInt = 100;
        TwoValueObject object = calculateSquareAndSquareRoot(anInt);
        System.out.println(object.square + " " + object.squareRoot);
    }
    private static TwoValueObject calculateSquareAndSquareRoot(int number){
        double sqaureRoot = Math.sqrt(number);
        int square = number * number;
        return new TwoValueObject(square,sqaureRoot);
    }
}

class TwoValueObject{
    int square;
    double squareRoot;

    TwoValueObject(int square, double squareRoot){
        this.square = square;
        this.squareRoot = squareRoot;
    }
}

