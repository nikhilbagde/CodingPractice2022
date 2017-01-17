package CompanyCompetetions.IKE;


import java.io.IOException;

/**
 * Created by Nikhil on 1/4/2017 3:35 AM.
 */
public class FileClass {
    public static void main(String args[]) throws IOException {
        /*String f="file1.java";
        File f1 = new File(f);*/
        //*****
    /*    InputStream iout = new FileInputStream(f1);
        *//*B.*//*	RandomAccessFile rf = new RandomAccessFile(f1);
        *//*C.*//*	Reader iout1 = new FileReader(f1);
        *//*D.*//*	InputStream iout2 = new InputStream(f1);
        *//*E.*//*	FileOutputStream iout3 = new FileOutputStream(f1);*/
/*
        Character c = new Character("C");
        *//*B.*//*	Integer i = new Integer();*/
        /*C.*/	Double d = new Double("17.46d");
        /*D.*/	Boolean b = new Boolean("false");
        /*E.*/	Float f = new Float(23.43);

        System.out.println(d);
        System.out.println(b);
        System.out.println(f);
    }

}

/*
Question 17:
Adjust Text Size:

There is a requirement to get employee details from the database, save the details into a Microsoft Excel file and then download it. Which of the following JavaReview code blocks will fulfill this requirement using high cohesion (assume here that methods contain the required code)?
	A.	class Employee {
            public void connectToDatabase(){}
            public void getEmployeeDetails(){}
            public void writeEmployeeDetailsToExcelFile(){}
            public void downloadEmployeeDetailsFile(){}
    }

	B.	class DatabaseConnection {
            public DBConnection getConnection(){}
}
class Employee {
            public void getEmployeeDetails(){}
            public void writeEmployeeDetailsToExcelFile(){}
            public void downloadEmployeeDetailsFile(){}
}

	C.	interface EmployeeDetails {
            public void connectToDatabase();
            public void writeEmployeeDetailsToExcelFile();
            public void downloadEmployeeDetailsFile();
}
class Employee implements EmployeeDetails {
            public void connectToDatabase(){}
            public void getEmployeeDetails(){}
            public void writeEmployeeDetailsToExcelFile(){}
            public void downloadEmployeeDetailsFile(){}
 }

	D.	class DatabaseConnection {
            public DBConnection getConnection(){}
}
class FileOperation {
           public void writeToFile(String fileName, String filePath, String fileType, DataBean dataBean) {}
           public void downloadFile(String fileName, String filePath, String fileType){}
}
class Employee {
          public List<EmployeeBean> getEmployeeDetails(){}
}

	E.	class Employee {
             public List<EmployeeBean> getEmployeeDetails(){}
             class DatabaseConnection {
                public DBConnection getConnection(){}
             }
             class FileOperation {
                 public void writeToFile(String fileName, String filePath, String fileType, DataBean dataBean) {}
                 public void downloadFile(String fileName, String filePath, String fileType){}
             }
 */