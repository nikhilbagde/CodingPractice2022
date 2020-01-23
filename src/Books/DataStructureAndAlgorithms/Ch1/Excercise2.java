package Books.DataStructureAndAlgorithms.Ch1;

public class Excercise2 {
    public static void main(String[] args) {
        GameEntry[] A = new GameEntry[10];
        GameEntry[] B = A.clone();
        A[4].scores = 550;          // object is not yet initialized this will give null pointer exception.

        System.out.println(B[4].scores);

    }
}

class GameEntry{
    int scores;
}
