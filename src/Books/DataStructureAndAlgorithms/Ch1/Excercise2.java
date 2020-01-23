package Books.DataStructureAndAlgorithms.Ch1;

/*
Suppose that we create an array A of GameEntry objects, which has an integer
scores field, and we clone A and store the result in an array B. If we then immediately
set A[4].score equal to 550, what is the score value of the GameEntry
object referenced by B[4]
 */
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
