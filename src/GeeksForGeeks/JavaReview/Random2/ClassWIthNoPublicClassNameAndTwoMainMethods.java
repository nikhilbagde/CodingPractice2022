package GeeksForGeeks.JavaReview.Random2;

/**
 * Created by Nikhil on 1/7/2017 2:04 AM.
 * Both classes A1 and A2 have main methods.
 * Main method is static method and can be overloaded.
 */
class A1{               //compiling this class will give A1.class and A2.class files.
    int aa;
    int bb;
    public static void main(String args[]){
        System.out.println("In A1");
    }
    A1(int a, int b){
        this.aa = a;
        this.bb = b;
    }
    A1(){
        this(5,15); // and not this.A1(1,2);
    }
}
class A2 {
    public static void main(String args[]){
        System.out.println("In A2");
        A1 obj = new A1(10,20);
        System.out.println(obj.aa + " " + obj.bb);
    }
}

