package GeeksForGeeks.JavaReview.ArraysInJava;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Nikhil on 1/7/2017 5:56 AM.
 */
public class ArraysInJava {
    int anInt;
    float aFloat;
    public static void main(String[] args) {

        //Primitives type
        int [] array1= {1,2,3};
        int [] array2= {1,2,3};

        if(Arrays.equals(array1, array2)){
            System.out.println("Same");
        }else{
            System.out.println("NOT Same");
        }

        //Array of array
        Object[] array3 = {array1};
        Object[] array4 = {array2};

        if(Arrays.deepEquals(array3, array4)){
            System.out.println("Same");
        }else{
            System.out.println("Not Same");
        }

        ArraysInJava obj1 = new ArraysInJava();
        obj1.anInt =10;
        obj1.aFloat = 10.0f;

        ArraysInJava obj2 = new ArraysInJava();
        obj1.anInt =10;
        obj1.aFloat = 10.0f;

        Object[] arrayobjects1 = {obj1, obj2};
        Object[] arrayobjects2 = {obj1, obj2};
        /*Object[] arrayobjects = new Object[2];
        arrayobjects[0] = obj1;
        arrayobjects[1] = obj2;*/

        System.out.println("Comparing Object Array");
        if(Arrays.equals(arrayobjects1, arrayobjects2)){
            System.out.println("Equals");
        }else{
            System.out.println("No");
        }

        final ArraysInJava obj3 = new ArraysInJava();
        ArraysInJava obj4 = new ArraysInJava();
        //obj3 = obj4;

        final int[] array5 = {1,2,3,4,5};
        for (int i = 0; i <array5.length ; i++) {
            array5[i] = array5[i] *10;
        }
        //Array print as a String.
        System.out.println(Arrays.toString(array5));
        /*for (int i = 0; i < array5.length; i++) {
            System.out.println(array5[i]);
        }*/


        final int[] array6 = {1,2,3,4};
        int[] array7 = {10,20,30,40};

        array7 = array6;
        //array6 = array7; cant assign to final reference varaible type.


        //Jaggaed Arrays.
        int[][] array8 = new int[3][];

        array8[0] = new int[4];
        array8[1] = new int[3];
        array8[2] = new int[2];

        int count = 0;
        for (int i = 0; i < array8.length; i++) {
            for (int j = 0; j < array8[i].length; j++) {
                array8[i][j] = ++count;
            }
        }
        for (int i = 0; i < array8.length; i++) {
            for (int j = 0; j < array8[i].length; j++) {
                System.out.print(array8[i][j] +" ");
            }
            System.out.println();
        }

        //Array out of bound index expection
        int[] array9 = new int[3];      //0 1 2 3
        //array9[3] = 10;
        //System.out.println(array9[3]);

        //Printing 2D Array using deepToString
        System.out.println(Arrays.deepToString(array8));


        //Sort Array
        //Sort Array in Reverse Order -> For this convert primitive type array to reference type Object array
        //
        int[] array11 = {1,2,3,4,5,6,6,7,8,10};         //Array objects can have primitives tyoe also refernece type
        Integer[] array12 = new Integer[array11.length];    //but its not true for ArrayList or any Collections.
                                                            //They can only have reference types as its eleemtns.

        Arrays.sort(array11);
        System.out.println(Arrays.toString(array11));

        //Arrays.sort(array12, Collections.reverseOrder());

        //Sort Array using user Defined type comparator
        Student [] arr = {new Student(111, "bbbb", "london"),
                new Student(131, "aaaa", "nyc"),
                new Student(121, "cccc", "jaipur")};

        System.out.println("Unsorted");
        for (int i=0; i<arr.length; i++)
            System.out.println(arr[i]);

        Arrays.sort(arr, new Sortbyroll());

        System.out.println("\nSorted by rollno");
        for (int i=0; i<arr.length; i++)
            System.out.println(arr[i]);


        //copy of array
        int[] array13 = {1,2,33,4};
        int [] copyOfArray13 = Arrays.copyOf(array13, array13.length);
        int [] copyOfArray1 = Arrays.copyOf(array13, 10);
        //System.arraycopy();

        //binary Search in array
        int[] array14 = {1,2,3,4,5,6,7,8,9,10};
        int index = Arrays.binarySearch(array14, 8);
        System.out.println(index);

        int index2 = Arrays.binarySearch(array14, 5,9, 2);
        System.out.println(index2);

    }

}
class Student
{
    int rollno;
    String name, address;

    // Constructor
    public Student(int rollno, String name,
                   String address)
    {
        this.rollno = rollno;
        this.name = name;
        this.address = address;
    }

    // Used to print student details in main()
    public String toString()
    {
        return this.rollno + " " + this.name +
                " " + this.address;
    }
}

class Sortbyroll implements Comparator<Student>
{
    // Used for sorting in ascending order of
    // roll number
    public int compare(Student a, Student b)
    {
        return a.rollno - b.rollno;
    }
}
