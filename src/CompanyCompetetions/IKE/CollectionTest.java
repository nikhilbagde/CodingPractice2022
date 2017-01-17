package CompanyCompetetions.IKE;

/**
 * Created by Nikhil on 1/4/2017 4:42 AM.
 */

import java.util.ArrayList;

public class CollectionTest {
    public static void addToString(ArrayList<?> collection, Object element) {
        //collection.add(element.toString());
    }
    public static void main(String[] args) {
      /*  ArrayList<String> collection = new ArrayList<String>();
        addToString(collection, "One");
        System.out.printf("Size of collection is %s",collection.size());
        ResourceBundle bundle = ResourceBundle.getBundle("Messages", new Locale("zh", "CN"));
*/
        /*FileInputStream in = new FileInputStream(file1);
        FileOutputStream out = new FileOutputStream(file2);
        in.copyTo(out);
        *//*B.	*//*
        FileSystem.Files.copyFile(file1, file2);

        *//*C.*//*	FileChannel in = new FileInputStream(file1).getChannel();
        FileChannel out = new FileOutputStream(file2).getChannel();
        out.transferFrom(in, 0, in.size());
        *//*D.*//*	Files.copy(file1.toPath(), file2.toPath());
        *//*E.*//*	FileReader reader = new FileReader(file1);
        FileWriter writer = new FileWriter(file2);
        writer.write(reader);*/

       // public static void main(String[] args) {
            /*String a = null;
            try {
                System.out.print(a.length());
            }
            catch (Exception ex) {
                System.out.print(a);
            }
            finally {
                a = "String";
                System.out.print(a.length());
            }*/
        //}
        int x = 0, y = 4, z = 5;
        if (x > 0)
            if (y < 3)
                System.out.println("One");
            else if (y < 4)
                System.out.println("Two");
            else if (z > 5)
                System.out.println("Three");
            else
                System.out.println("Four");
    }
}
