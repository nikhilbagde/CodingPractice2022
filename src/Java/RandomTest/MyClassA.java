package Java.RandomTest;

/**
 * Created by Nikhil on 1/4/2017 4:37 AM.
 */
class MainClassA {
    public static void main(String[] args) {
        System.out.println("Class A " + args[0]);
    }
}
class MainClassB {
    public static void main(String[] args) {
        System.out.println("Class B");
        MainClassA.main(args);
    }
}
