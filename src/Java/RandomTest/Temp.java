package Java.RandomTest;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by Nikhil on 1/4/2017 2:44 AM.
 */
class Temp {
   // protected static int count = 0;
/*
    public Temp() {
        count++;
    }

    static int getCount() {
        return count;
    }*/


    /*public boolean isLeapYear(int year) {
        Calendar cal = Calendar.getInstance();
        return cal.isLeapYear(year);
    }*/

    public static boolean isLeapYearA(int year) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, 1, 1);
        int days = cal.getMaximum(Calendar.DAY_OF_MONTH);
        return (days == 29);
    }

    public static  boolean isLeapYearB(int year) {
        GregorianCalendar gc = new GregorianCalendar();
        return gc.isLeapYear(year);
    }

    /*public static  boolean isLeapYearC(int year) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, Calendar.FEBRUARY, 1);
        int days = cal.getLastDay(Calendar.DAY_OF_MONTH);
        return (days == 29);
    }*/

    public static boolean isLeapYearD(int year) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        int days = cal.getActualMaximum(Calendar.DAY_OF_YEAR);
        return (days > 365);
    }

    static int total = 10;
    public void call() {
        int total = 5;
        System.out.println(this.total);
    }

    public static void main(String[] args) {
        /*System.out.println(isLeapYearB(1600));
        System.out.println(isLeapYearD(1600));
        System.out.println(isLeapYearA(1600));*/

        /*System.out.println("Current JVM Heap Size:" + Runtime.getRuntime().totalMemory());
        System.out.println("Maximum JVM Heap Size:" + Runtime.getRuntime().maxMemory());
        System.out.println("Free JVM Heap Size:" + Runtime.getRuntime().freeMemory());*/
       /* *//*B.*//*	System.out.println("Current JVM Heap Size:"+Runtime.totalMemory());
        System.out.println("Maximum JVM Heap Size:"+Runtime.maxMemory());
        System.out.println("Free JVM Heap Size:"+Runtime.freeMemory());
        *//*C.*//*	System.out.println("Current JVM Heap Size:"+Runtime.getMax());
        System.out.println("Maximum JVM Heap Size:"+Runtime.getUsed());
        System.out.println("Free JVM Heap Size:"+Runtime.getInit());
        *//*D.*//*	System.out.println("Current JVM Heap Size:"+Runtime.getRuntime().getCurrentSize());
        System.out.println("Maximum JVM Heap Size:"+Runtime.getRuntime().getMaxSize());
        System.out.println("Free JVM Heap Size:"+Runtime.getRuntime().getFreeSize());
        *//*E.*//*	System.out.println("Current JVM Heap Size:" + Runtime.getRuntime().getTotalHeapMemory(););
        System.out.println("Maximum JVM Heap Size:" + Runtime.getRuntime().getMaxHeapMemory());
        System.out.println("Free JVM Heap Size:" + Runtime.getRuntime().getFreeHeapMemory());*/
        int x= 5;
        x = ~x;
        //System.out.println(x);

        //x = !x;



           // public static void main (String args []) {
                Test a1 = new Test();
               // a1.call();
            //}


        //7
        String str1 = "My String";
        String str2 = new String ("My String");
        /*A.	*/
        System.out.println(str1.equals(str2));
        /*B.	*/
        System.out.println(str1.matches(str2));
        /*C.	*/ //String.parse(str1) == str2;
        /*D.	*/
        System.out.println(str1.hashCode() == str2.hashCode());
        /*E.	*/
        System.out.println(str1 == str2);
    }
}