package CompanyCompetetions.IKE;

/**
 * Created by Nikhil on 1/4/2017 3:10 AM.
 */
import java.util.Set;

public class MyCollection<T> {

        private Set<T> set;
        public Set<T> getCollection() {
            return this.set;
        }
    /*public void TestCollection1(MyCollection<?> collection) {
        Set<> set = collection.getCollection();

    }
*//*    B.	*//*public void TestCollection2(MyCollection<?> collection) {
        Set<T> set = collection.getCollection();

    }
*//*    C.	*//*public void TestCollection3(MyCollection<?> collection) {
        Set<E> set = collection.getCollection();

    }*/
/*    D.	*/public void TestCollection4(MyCollection<?> collection) {
        Set set = collection.getCollection();
        System.out.println("In D");

    }
    /*E.	*/public void TestCollection5(MyCollection<?> collection) {
        Set<?> set = collection.getCollection();
        System.out.println("In E");

    }

    public static void main(String[] args) {
        MyCollection obj = new MyCollection();
        obj.TestCollection4(new MyCollection<>());
        obj.TestCollection5(new MyCollection<>());
    }


}
