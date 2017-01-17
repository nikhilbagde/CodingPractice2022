package CompanyCompetetions.IKE;

import java.io.File;

/**
 * Created by Nikhil on 1/4/2017 3:53 AM.
 */
public class FileClass1 {
    //public class  FileClass{
        public static void main(String[] args){
            File file = new File("C:\\Users\\Nikhi\\Google Drive\\IdeaProjects\\HackerRank\\src\\JavaReview\\RandomTest\\test.txt");
            File backup = new File("C:\\Users\\Nikhi\\Google Drive\\IdeaProjects\\HackerRank\\src\\JavaReview\\RandomTest\\test.txt.bak");
            backup.delete();
            file.renameTo(backup); //Location 1
        }
    //}
}
