package CompanyCompetetions.IKE;

/**
 * Created by Nikhil on 1/4/2017 5:06 AM.
 */
class C extends A.B {
    C(A car, float f) {
        car.super();
        System.out.println("C");
    }
    public static void main(String str[]){
        new C(new A(), 5.0f);
    }
}
