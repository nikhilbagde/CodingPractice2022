package CompanyCompetetions.JAvaDe;

/**
 * Created by Nikhi on 4/27/2017.
 */
public class Test2 {
    public static void main(String[] args) {
        int [] a = {1};
        Test2 test = new Test2();
        test.inc(a);
        System.out.println(a[a.length-1]);
    }
    void inc(int[] i){
        i[i.length-1]++;
    }
}
