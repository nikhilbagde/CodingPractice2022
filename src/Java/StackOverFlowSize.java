package Java;

public class StackOverFlowSize {
    public static void main(String[] args) {
        int n = 0;
        print(n);
    }
    public static void print(int n){
        System.out.println(n);      // prints till 19202. !
        print(n+1);
    }
}
